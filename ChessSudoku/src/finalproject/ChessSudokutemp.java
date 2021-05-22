package finalproject;

import java.util.*;
import java.io.*;


public class ChessSudokutemp
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
	public HashSet<ChessSudokutemp> solutions = new HashSet<ChessSudokutemp>();


	/* The solve() method should remove all the unknown characters ('x') in the grid
	 * and replace them with the numbers in the correct range that satisfy the constraints
	 * of the Sudoku puzzle. If true is provided as input, the method should find finds ALL 
	 * possible solutions and store them in the field named solutions. */
	public boolean checkRow(int row, int number){
        for(int col=0; col < N; col++){
            if (grid[row][col]==number) return false;
        }
        return true;
    }

    public boolean checkCol(int col, int number){
        for(int row=0; row < N; row++){
            if (grid[row][col]==number) return false;
        }
        return true;
    }

    public boolean checkSquare(int row, int col, int number){
        int rowSection = row/SIZE * SIZE;
        int colSection = col/SIZE * SIZE;
        for (int i = rowSection; i < (rowSection+SIZE); i++){
            for (int j = colSection; j < (colSection+SIZE); j++){
                if(grid[i][j]==number) return false;
            }
        }
        return true;
    }

    // Find a valid number for the current cell
    public void find(int row, int col)throws Exception{

        // If row number exceeds the max row, the grid is solved
        if (row > N-1)throw new Exception( "Success!" ) ;

        // If cell is not 0 (or x), continue with the next cell
        if (grid[row][col]!=0)findNext(row, col);
        else {
            // Guess a valid number for current cell
            for ( int number = 1; number <= N; number++){
                if ( checkRow(row, number) && checkCol(col, number) && checkSquare(row, col, number) ){
                    grid[row][col] = number;
                    // Continue with next cell
                    findNext(row, col);
                }
            }
            grid[row][col]=0;
        }
    }

    // Calls find for the next cell
    public void findNext(int row, int col)throws Exception{
        if (col < (N-1)){
            find(row, col+1);
        } else {
            find(row+1, 0);
        }
    }

    /* The solve() method should remove all the unknown characters ('x') in the Grid
     * and replace them with the numbers from 1-9 that satisfy the Sudoku puzzle. */
    public void solve(boolean allSolutions){
        // Save the time in order to calculate runtime
        long startTime = System.nanoTime();
        try{find(0,0);} 
        catch(Exception e){}

        // Print out the running time in MILLISECONDS of this solve() method
        System.out.println("Runtime: " + (System.nanoTime() - startTime)/1e6);
    }
	
	// Solve method. We will use a recursive BackTracking algorithm.


	/*****************************************************************************/
	/* NOTE: YOU SHOULD NOT HAVE TO MODIFY ANY OF THE METHODS BELOW THIS LINE. */
	/*****************************************************************************/

	/* Default constructor.  This will initialize all positions to the default 0
	 * value.  Use the read() function to load the Sudoku puzzle from a file or
	 * the standard input. */
	public ChessSudokutemp( int size ) {
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
		//InputStream in = new FileInputStream("veryEasy3x3.txt");
                //InputStream in = new FileInputStream("easy3x3.txt");
                InputStream in = new FileInputStream("medium3x3_twelveSolutions.txt");
		// The first number in all Sudoku files must represent the size of the puzzle.  See
		// the example files for the file format.
		int puzzleSize = readInteger( in );
		if( puzzleSize > 100 || puzzleSize < 1 ) {
			System.out.println("Error: The Sudoku puzzle size must be between 1 and 100.");
			System.exit(-1);
		}

		ChessSudokutemp s = new ChessSudokutemp( puzzleSize );
		
		// You can modify these to add rules to your sudoku
		s.knightRule = false;
		s.kingRule = false;
		s.queenRule = false;
		
		// read the rest of the Sudoku puzzle
		s.read( in );

		System.out.println("Before the solve:");
		s.print();
		System.out.println();

		// Solve the puzzle by finding one solution.
		s.solve(false);

		// Print out the (hopefully completed!) puzzle
		System.out.println("After the solve:");
		s.print();
	}
}
