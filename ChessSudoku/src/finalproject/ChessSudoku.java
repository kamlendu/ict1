package finalproject;

import java.util.*;
import java.io.*;


public class ChessSudoku
{
    /* SIZE is the size parameter of the Sudoku puzzle, and N is the square of the size.  For
     * a standard Sudoku puzzle, SIZE is 3 and N is 9.
     */
    public int SIZE, N;

    /* The grid contains all the numbers in the Sudoku puzzle.  Numbers which have
     * not yet been revealed are stored as 0.
     */
    public int grid[][];

    /* Booleans indicating whether of not one or more of the chess rules should be
     * applied to this Sudoku.
     */
    public boolean knightRule;
    public boolean kingRule;
    public boolean queenRule;


    // Field that stores the same Sudoku puzzle solved in all possible ways
    public HashSet<ChessSudoku> solutions = new HashSet<ChessSudoku>();

    // Field that stores coordinates of all queens in the grid (value of this.N)
    private int[][] queenLocations;
    private int queensAdded; // number of queens currently in the grid

    /* The solve() method should remove all the unknown characters ('x') in the grid
     * and replace them with the numbers in the correct range that satisfy the constraints
     * of the Sudoku puzzle. If true is provided as input, the method should find finds ALL
     * possible solutions and store them in the field named solutions. */
    public void solve(boolean allSolutions) {
        // This function recursively fills this.grid
        // Each call of solve tries to fill in one cell of the grid

        // Get the indices of an empty cell:
        int[] cell = this.chooseEmptyCell(); // cell[0] is the row, cell[1] is the column

        if (cell == null) { // BASE CASE
            // if an empty cell was not found, then the grid is already filled/we have a solution,
            // so just end the function call
            return;
        }

        if (queenRule) { this.findQueens(); } // save coordinates of all queens

        // Check if placing a number in this empty cell would break a Sudoku rule:
        int n = 1;
        for (n = 1; n <= this.N; n++) { // try every possible integer [1, N]
            // Check basic Sudoku rules
            if (this.checkBasicRulesConflict(cell[0], cell[1], n)) continue;
            // if conflict found, continue to next n value (no need to check other rules)

            if (knightRule) { // optional KNIGHT RULE
                if (this.checkKnightRuleConflict(cell[0], cell[1], n)) continue;
                // if conflict with knight rule, continue to next n value
            }
            if (kingRule) { // optional KING RULE
                if (this.checkKingRuleConflict(cell[0], cell[1], n)) continue;
                // if conflict with king rule, continue to next n value
            }
            if (queenRule && n == this.N) { // optional QUEEN RULE
                if (this.checkQueenRuleConflict(cell[0], cell[1])) continue;
                // if conflict with queen rule, continue to next n value
            }

            // Code reaches here if no conflicts with any rules found
            // fill in the empty cell with n
            this.grid[cell[0]][cell[1]] = n;

            // call the solve function on the rest of the grid
            this.solve(allSolutions);

            // check if grid is filled
            boolean solutionFound = this.gridFilledCheck();
            if (solutionFound) {
                if (allSolutions) { // If we want all possible solutions
                    // create a new ChessSudoku object
                    ChessSudoku newSudoku = new ChessSudoku(this.SIZE);
                    newSudoku.grid = this.gridDeepCopy(); // copy the solution grid to the new object
                    // add the new sudoku object to the hash set
                    solutions.add(newSudoku);

                    // remove the number that we just added to the cell of interest
                    this.grid[cell[0]][cell[1]] = 0;
                    // let the code continue running/backtrack so that we look through all possible grid combos

                } else return; // otherwise, we've found 1 solution to the grid, so we can stop

            } else { // If unable to fill in the rest of the grid, (we ran into a conflict at a later step)
                // Remove the number and backtrack
                this.grid[cell[0]][cell[1]] = 0;
                // let the code continue running so that a different n value can be tried
            }
        }

        // We reach here if conflict found for every possible n value / we were unable to fill the grid for any n value
        // - do nothing as the function call ends here anyways
    }

    /**********************
     * My private methods *
     **********************/
    private int[][] gridDeepCopy() {
        // This function creates a deep copy of the Sudoku grid
        int[][] newGrid = new int[this.N][this.N];
        for(int i=0; i < this.N; i++) { // iterate through rows
            for(int j=0; j<this.N; j++) { // iterate through columns
                newGrid[i][j] = this.grid[i][j];
            }
        }
        return newGrid;
    }

    private boolean gridFilledCheck() {
        for (int r=0; r<this.N; r++) {
            for (int c=0; c<this.N; c++) {
                if(this.grid[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] chooseEmptyCell() {
        // Returns an array of integers representing the indices of an empty cell in the form {row, column}
        //              It chooses the empty cell based on lowest number of empty cells
        //              in the same row, column, and box
        //              (also a knight's move, king's move, and queen's move away if needed)
        //              because this means fewer valid values can go in that cell,
        //              reducing the number of "branches" in our brute force search algorithm
        // The function returns null if no empty cells are found
        int[][] counts = this.countEmptyCells_allRowsColsBoxes();
        int lowestCount = this.N*this.N+1; // start with max number of cells
        int[] indices = new int[2];
        for (int r=0; r<this.N; r++) {
            for (int c=0; c<this.N; c++) {
                if (this.grid[r][c] == 0) {
                    int count = counts[0][r] + counts[1][c] + counts[2][c/this.SIZE+(r/this.SIZE)*this.SIZE];
                    if (knightRule) count += this.countEmptyCells_KnightRule(r,c);
                    if (kingRule) count += this.countEmptyCells_KingRule(r,c);
                    if (queenRule) count -= this.countFilledCells_QueenRule(r,c);

                    if (count < lowestCount) {
                        indices[0] = r;
                        indices[1] = c;
                        lowestCount = count;
                        if (lowestCount == 1) {return indices;}
                    }
                }
            }
        }
        if (lowestCount < this.N*this.N+1) { return indices; }
        else { return null; }
    }

    private int[][] countEmptyCells_allRowsColsBoxes() {
        // Returns an array of three arrays
        // array 0 has the number of filled cells in every row
        // array 1 has the number of filled cells in every column
        // array 2 has the number of filled cells in every box, indexed as follows:
        //  | 0 | 1 | 2 |
        //      | 3 | 4 | 5 |
        //      | 6 | 7 | 8 | (3x3 sudoku example)
        int[][] counts = new int[3][this.N];
        for(int i=0; i<this.N; i++) { // iterate thru every row
            for(int j=0; j<this.N; j++) { // iterate thru every column
                if (this.grid[i][j] == 0) {
                    counts[0][i]++; counts[1][j]++; // for 0's in same rows and columns
                    counts[2][j/this.SIZE+(i/this.SIZE)*this.SIZE]++; // for 0's in same box
                }
            }
        }
        return counts;
    }

    private int countEmptyCells_KnightRule(int row, int col) {
        // Returns number of empty cells a knight's move away from (row, col)
        // that are not in the same box as (row, col)
        int boxRow = row/SIZE;
        int boxCol = col/SIZE;
        int count = 0;
        if (row+2 < this.N && row+2 >= (boxRow+1)*SIZE) {
            if (col+1 < this.N && col+1 >= (boxCol+1)*SIZE) { if (this.grid[row+2][col+1] == 0) count++; }
            if (col-1 >= 0 && col-1 < (boxCol*SIZE)) { if (this.grid[row+2][col-1] == 0) count++; }
        }
        if (row-2 >= 0 && row-2 < (boxRow*SIZE)) {
            if (col+1 < this.N && col+1 >= (boxCol+1)*SIZE) { if (this.grid[row-2][col+1] == 0) count++; }
            if (col-1 >= 0 && col-1 < (boxCol*SIZE)) { if (this.grid[row-2][col-1] == 0) count++; }
        }
        if (row+1 < this.N && row+1 >= (boxRow+1)*SIZE) {
            if (col+2 < this.N && col+2 >= (boxCol+1)*SIZE) { if (this.grid[row+1][col+2] == 0) count++; }
            if (col-2 >= 0 && col-2 < (boxCol*SIZE)) { if (this.grid[row+1][col-2] == 0) count++; }
        }
        if (row-1 >= 0 && row-1 < (boxRow*SIZE)) {
            if (col+2 < this.N && col+2 >= (boxCol+1)*SIZE) { if (this.grid[row-1][col+2] == 0) count++; }
            if (col-2 >= 0 && col-2 < (boxCol*SIZE)) { if (this.grid[row-1][col-2] == 0) count++; }
        }
        return count;
    }

    private int countEmptyCells_KingRule(int row, int col) {
        // Returns number of empty cells 1 diagonal step from (row, col)
        // that are not in the same box as (row, col)
        int boxRow=row/SIZE;
        int boxCol=col/SIZE;
        int count = 0;
        if (row+1 < this.N && row+1 >= (boxRow+1)*SIZE) {
            if (col+1 < this.N && col+1 >= (boxCol+1)*SIZE) { if (this.grid[row+1][col+1] == 0) count++; }
            if (col-1 >= 0 && col-1 < (boxCol*SIZE)) { if(this.grid[row+1][col-1] == 0) count++; }
        }
        if (row-1 >= 0 && row-1 < (boxRow*SIZE)) {
            if (col+1 < this.N && col+1 >= (boxCol+1)*SIZE) { if (this.grid[row-1][col+1] == 0) count++; }
            if (col-1 >= 0 && col-1 < (boxCol*SIZE)) { if(this.grid[row-1][col-1] == 0) count++; }
        }
        return count;
    }

    private void findQueens() {
        this.queensAdded = 0;
        int[][] coords = new int[this.N][2];
        for (int i=0; i<this.N; i++) {
            for (int j=0; j<this.N; j++) {
                if (this.grid[i][j] == this.N) {
                    coords[this.queensAdded][0] = i;
                    coords[this.queensAdded][1] = j;
                    this.queensAdded++;
                }
            }
        }
        this.queenLocations = coords;
    }

    private int countFilledCells_QueenRule(int row, int col) {
        // Returns number of cells with value this.N a diagonal away from (row, col)
        int count = 0;
        int boxRow=row/SIZE;
        int boxCol=col/SIZE;
        for (int i=0; i < this.queensAdded; i++) {
            if (Math.abs(this.queenLocations[i][0]-row) == Math.abs(this.queenLocations[i][1]-col)) {
                // if the difference between rows and columns are equal, then they are diagonal to each other
                if ((this.queenLocations[i][0] >= (boxRow+1)*SIZE || this.queenLocations[i][0] < (boxRow*SIZE)) &&
                        (this.queenLocations[i][1] >= (boxCol+1)*SIZE || (this.queenLocations[i][1] < (boxCol*SIZE)))) {
                    // only add count if the queen is not in the same box as (row, col)
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkBasicRulesConflict(int row, int col, int num) {
        // This function assumes that we have not 'filled' the empty cell found at (row, col) yet
        // Returns true if 'num' is found in the row, col, or box of interest
        // Covers basic Sudoku rules:
        //              RULE 1: num is not repeated on its row
        //              RULE 2: num is not repeated on its column
        //              RULE 3: num is not repeated in its 3x3 box
        for (int i=0; i<this.N; i++) {
            // check if 'num' is already in the row of interest
            if (this.grid[row][i] == num) return true;
            // check if 'num' is already in the column of interest
            if (this.grid[i][col] == num) return true;
        }

        // Figure out which "box" the empty cell (row,col) is in (using integer/floor division)
        int boxRow = row/this.SIZE;
        int boxCol = col/this.SIZE;
        for (int i=boxRow*this.SIZE; i < (boxRow+1)*this.SIZE; i++) { // iterate thru rows of the box
            for (int j=boxCol*this.SIZE; j < (boxCol+1)*this.SIZE; j++) { // iterate thru cols of the box
                // check if 'num' is already in the box of interest
                if (grid[i][j] == num) return true;
            }
        }

        return false; // if 'number' was not found in the row, col, or box, return false
    }

    private boolean checkKnightRuleConflict(int row, int col, int num) {
        // Returns true if 'num' is found a chess knight's move away from (row, col)
        // A knight's move can be (row +-2, col +-1) or (row +-1, col +-2)
        // Note that there are only 8 possible knight moves away from a single square
        if (row+2 < this.N) {
            if (col+1 < this.N) { if (this.grid[row+2][col+1] == num) return true; }
            if (col-1 >= 0) { if (this.grid[row+2][col-1] == num) return true; }
        }
        if (row-2 >= 0) {
            if (col+1 < this.N) { if (this.grid[row-2][col+1] == num) return true; }
            if (col-1 >= 0) { if (this.grid[row-2][col-1] == num) return true; }
        }
        if (row+1 < this.N) {
            if (col+2 < this.N) { if (this.grid[row+1][col+2] == num) return true; }
            if (col-2 >= 0) { if (this.grid[row+1][col-2] == num) return true; }
        }
        if (row-1 >= 0) {
            if (col+2 < this.N) { if (this.grid[row-1][col+2] == num) return true; }
            if (col-2 >= 0) { if (this.grid[row-1][col-2] == num) return true; }
        }

        return false;
    }

    private boolean checkKingRuleConflict(int row, int col, int num) {
        // Returns true if 'num' is found a king's move away from (row, col)
        // it will only check 1 diagonal step away bc we already checked rows and columns previously
        if (row+1 < this.N) {
            if (col+1 < this.N) { if (this.grid[row+1][col+1] == num) return true; }
            if (col-1 >= 0) { if(this.grid[row+1][col-1] == num) return true; }
        }
        if (row-1 >= 0) {
            if (col+1 < this.N) { if (this.grid[row-1][col+1] == num) return true; }
            if (col-1 >= 0) { if(this.grid[row-1][col-1] == num) return true; }
        }
        return false;
    }

    private boolean checkQueenRuleConflict(int row, int col) {
        // Returns true if any cell diagonal to (row, col) has a value of this.N aka is a queen
        for (int i=0; i < this.queensAdded; i++) {
            if ( Math.abs(this.queenLocations[i][0]-row) == Math.abs(this.queenLocations[i][1]-col)) {
                // if the difference between rows and columns are equal, then they are diagonal to each other
                return true;
            }
        }
        return false;
    }



    /*****************************************************************************/
    /* NOTE: YOU SHOULD NOT HAVE TO MODIFY ANY OF THE METHODS BELOW THIS LINE. */
    /*****************************************************************************/

    /* Default constructor.  This will initialize all positions to the default 0
     * value.  Use the read() function to load the Sudoku puzzle from a file or
     * the standard input. */
    public ChessSudoku( int size ) {
        SIZE = size;
        N = size*size;

        grid = new int[N][N];
        for( int i = 0; i < N; i++ )
            for( int j = 0; j < N; j++ )
                grid[i][j] = 0;
    }


    /* readInteger is a helper function for the reading of the input file.  It reads
     * words until it finds one that represents an integer. For convenience, it will also
     * recognize the string "x" as equivalent to "0". */
    static int readInteger( InputStream in ) throws Exception {
        int result = 0;
        boolean success = false;

        while( !success ) {
            String word = readWord( in );

            try {
                result = Integer.parseInt( word );
                success = true;
            } catch( Exception e ) {
                // Convert 'x' words into 0's
                if( word.compareTo("x") == 0 ) {
                    result = 0;
                    success = true;
                }
                // Ignore all other words that are not integers
            }
        }

        return result;
    }


    /* readWord is a helper function that reads a word separated by white space. */
    static String readWord( InputStream in ) throws Exception {
        StringBuffer result = new StringBuffer();
        int currentChar = in.read();
        String whiteSpace = " \t\r\n";
        // Ignore any leading white space
        while( whiteSpace.indexOf(currentChar) > -1 ) {
            currentChar = in.read();
        }

        // Read all characters until you reach white space
        while( whiteSpace.indexOf(currentChar) == -1 ) {
            result.append( (char) currentChar );
            currentChar = in.read();
        }
        return result.toString();
    }


    /* This function reads a Sudoku puzzle from the input stream in.  The Sudoku
     * grid is filled in one row at at time, from left to right.  All non-valid
     * characters are ignored by this function and may be used in the Sudoku file
     * to increase its legibility. */
    public void read( InputStream in ) throws Exception {
        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < N; j++ ) {
                grid[i][j] = readInteger( in );
            }
        }
    }


    /* Helper function for the printing of Sudoku puzzle.  This function will print
     * out text, preceded by enough ' ' characters to make sure that the printint out
     * takes at least width characters.  */
    void printFixedWidth( String text, int width ) {
        for( int i = 0; i < width - text.length(); i++ )
            System.out.print( " " );
        System.out.print( text );
    }


    /* The print() function outputs the Sudoku grid to the standard output, using
     * a bit of extra formatting to make the result clearly readable. */
    public void print() {
        // Compute the number of digits necessary to print out each number in the Sudoku puzzle
        int digits = (int) Math.floor(Math.log(N) / Math.log(10)) + 1;

        // Create a dashed line to separate the boxes
        int lineLength = (digits + 1) * N + 2 * SIZE - 3;
        StringBuffer line = new StringBuffer();
        for( int lineInit = 0; lineInit < lineLength; lineInit++ )
            line.append('-');

        // Go through the grid, printing out its values separated by spaces
        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < N; j++ ) {
                printFixedWidth( String.valueOf( grid[i][j] ), digits );
                // Print the vertical lines between boxes
                if( (j < N-1) && ((j+1) % SIZE == 0) )
                    System.out.print( " |" );
                System.out.print( " " );
            }
            System.out.println();

            // Print the horizontal line between boxes
            if( (i < N-1) && ((i+1) % SIZE == 0) )
                System.out.println( line.toString() );
        }
    }


    /* The main function reads in a Sudoku puzzle from the standard input,
     * unless a file name is provided as a run-time argument, in which case the
     * Sudoku puzzle is loaded from that file.  It then solves the puzzle, and
     * outputs the completed puzzle to the standard output. */
    public static void main( String args[] ) throws Exception {
        InputStream in = new FileInputStream("veryHard5x5.txt");

        // The first number in all Sudoku files must represent the size of the puzzle.  See
        // the example files for the file format.
        int puzzleSize = readInteger( in );
        if( puzzleSize > 100 || puzzleSize < 1 ) {
            System.out.println("Error: The Sudoku puzzle size must be between 1 and 100.");
            System.exit(-1);
        }

        ChessSudoku s = new ChessSudoku( puzzleSize );

        // You can modify these to add rules to your sudoku
        s.knightRule = false;
        s.kingRule = false;
        s.queenRule = false;
        boolean allSol = false;

        // read the rest of the Sudoku puzzle
        s.read( in );

        System.out.println("Before the solve:");
        s.print();
        System.out.println();

        // Solve the puzzle by finding one solution.
        s.solve(allSol);

        // Print out the (hopefully completed!) puzzle
        System.out.println("After the solve:");
        if (allSol) {
            for(ChessSudoku i: s.solutions) {
                System.out.println("A solution:");
                i.print();
            }
        }
        else {
            s.print();
        }
    }
}