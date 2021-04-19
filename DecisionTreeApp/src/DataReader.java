
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//The DataReader class deals with I/O of the dataset and serialized decision tree objects. It also
//splits the read dataset into training and test sets.
public class DataReader {

    //Datum temp;
    ArrayList<Datum> datalist = new ArrayList<Datum>(); //the total dataset
    ArrayList<Datum> trainData = new ArrayList<Datum>(); //the training dataset
    ArrayList<Datum> testData = new ArrayList<Datum>(); //the test dataset

    //the constructor
    DataReader()
    {

    }
    //Given the name of a CSV file, this method reads the file and stores the
    //information (dataset) in this.datalist in the form of an ArrayList
    void read_data(String filename) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        //read each line of the CSV file
        while (line!=null)
        {
            //split the line based on commas
            String[] data = line.split(",");
            int len = data.length-1;
            double [] tempx = new double[len];

            //convert each of the attributes from string to float
            for (int i=0;i<data.length-1 ;i++)
            {
                tempx[i] = Float.parseFloat(data[i]);
            }
            float f = Float.parseFloat(data[data.length-1]);

            //read the corresponding label
            int jj = Math.round(f);
            //create a new Datum object using the information read from the csv file
            Datum temp = new Datum(tempx , jj);
            //store it in datalist
            this.datalist.add(temp);
            line = br.readLine();
        }

    }

    //This method takes in a fraction value. It breaks the Arraylist (datalist) into two parts according to the input fraction
    //where the size of the training set is equal to the fraction of the datalist provided in the input and the rest forms
    //the test dataset. The training and test datset are stored in this.trainData and this.testData respectively.

    void splitTrainTestData(double trainfraction)
    {
        //determine the number of datapoints to be present in the training set
        int no_of_traincases = (int)Math.round(this.datalist.size()*trainfraction);
        int total = this.datalist.size();

        //shuffle the data before splitting. This is a good practice as it
        // removes any bias present during the collection of the data
        Collections.shuffle(this.datalist , new Random(1));

        //populate this.trainData
        for (int i = 0 ;  i< no_of_traincases ; i++)
        {

            Datum swap = this.datalist.get(i);
            this.trainData.add(swap);

        }

        //pouplate this.testData
        for (int i = no_of_traincases ; i < total ; i++)
        {
            this.testData.add(this.datalist.get(i));
        }

    }


    // given a DecisionTree object and a string, this method stores the given DecisionTree object
    // as a serialized file as the given filename
    public static void writeSerializedTree( DecisionTree dt, String filename)
    {
        try {
            //write object into a file
            FileOutputStream fileOut =
                    new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dt);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in "+ filename);
        } catch (IOException ik) {
            ik.printStackTrace();
        }
    }

    //given a filename as a string, this method returns the serialized DecisionTree object present in the given filename
    public static DecisionTree readSerializedTree(String filename)
    {
        DecisionTree object1 = null;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            object1 = (DecisionTree)in.readObject();

            in.close();
            file.close();

            return object1;
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        return null;
    }

}
