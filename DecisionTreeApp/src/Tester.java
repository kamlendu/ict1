import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Official tests
//==========================================================================================

class DecisionTree_classify1 implements Runnable {

	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh1.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class DecisionTree_classify2 implements Runnable {

	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_partial_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_partial_overlap/thresh1.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class DecisionTree_classify3 implements Runnable {

	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_high_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class DecisionTree_classify4 implements Runnable {

	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh2.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_HighDiffFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_high_overlap/thresh4.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");
		if (DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_HighSameFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");
		if (!DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_MinDiffFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh8.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh1.ser");
		if (DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_MinSameFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh4.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_minimal_overlap/thresh4.ser");
		if (!DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_PartialDiffFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_partial_overlap/thresh4.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_partial_overlap/thresh1.ser");
		if (DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Equals_PartialSameFiles implements Runnable {

	@Override
	public void run() {
		DecisionTree dt1 = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");
		DecisionTree dt2 = ReadFile
				.getDTFromFile("data_high_overlap/thresh1.ser");
		if (!DecisionTree.equals(dt1, dt2)) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_High1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile.getCSVDataReader("data_high_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile
				.getDTFromFile("data_high_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_High2 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 4;
		DataReader dr = ReadFile.getCSVDataReader("data_high_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile
				.getDTFromFile("data_high_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_High3 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 32;
		DataReader dr = ReadFile.getCSVDataReader("data_high_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile
				.getDTFromFile("data_high_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Min1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_minimal_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Min2 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 4;
		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_minimal_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Min3 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 64;
		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_minimal_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Min4 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 128;
		DataReader dr = ReadFile.getCSVDataReader("data_minimal_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_minimal_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Partial1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile.getCSVDataReader("data_partial_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_partial_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Partial2 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 8;
		DataReader dr = ReadFile.getCSVDataReader("data_partial_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_partial_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_Partial3 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 16;
		DataReader dr = ReadFile.getCSVDataReader("data_partial_overlap.csv");
		dr.splitTrainTestData(.5);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_partial_overlap/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

// Student tests
// ==========================================================================================

class Classify_3Attributes1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_3_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_3_attributes/thresh1.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

class Classify_5Attributes1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;

		DataReader dr = ReadFile.getCSVDataReader("data_5_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree dt = ReadFile
				.getDTFromFile("data_5_attributes/thresh1.ser");

		int counter = 0;
		int total = dr.trainData.size();
		for (int i = 0; i < total; i++) {
			double[] attrs = dr.trainData.get(i).x;
			int correctLabel = dr.trainData.get(i).y;
			int classifiedAs = dt.classify(attrs);

			if (verbose) {
				System.out.println("Attributes: " + Arrays.toString(attrs));
				System.out.println("Correct label: " + correctLabel
						+ ", Your classification :" + classifiedAs);
			}
			if (correctLabel == classifiedAs) {
				counter++;
			}
		}
		System.out.println(
				"Number of correct outputs : " + counter + " out of " + total);

		if (counter != total) {
			throw new AssertionError("Test failed.");
		}
		System.out.println("Test passed.");
	}
}

/*
 * Calls dtNode.equals(String) (expects false and no ClassCastException)
 */
class Equals_String implements Runnable {
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void run() {
		DecisionTree dt = ReadFile
				.getDTFromFile("data_high_overlap/thresh4.ser");
        boolean equal=false;
               // @SuppressWarnings("IncompatibleEquals")
               try{
		 equal = dt.rootDTNode.equals("a string");
               }
               catch(Exception ex)
               {
                   
               }

               
		if(equal)
			throw new AssertionError("dtNode.equals(String) returned true");
		else
			System.out.println("Test passed.");
	}
}

/*
 * Calls dtNode.equals(null) (expects false and no ClassCastException)
 */
class Equals_Null implements Runnable {
	@Override
	public void run() {
		DecisionTree dt = ReadFile
				.getDTFromFile("data_high_overlap/thresh4.ser");

		boolean equal = dt.rootDTNode.equals(null);
		if (equal)
			throw new AssertionError("dtNode.equals(null) returned true");
		else
			System.out.println("Test passed.");
	}
}

class FillDTNode_3Attributes1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile.getCSVDataReader("data_3_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_3_attributes/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_3Attributes64 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 64;
		DataReader dr = ReadFile.getCSVDataReader("data_3_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_3_attributes/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_5Attributes1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile.getCSVDataReader("data_5_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_5_attributes/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_5Attributes64 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 64;
		DataReader dr = ReadFile.getCSVDataReader("data_5_attributes.csv");
		dr.splitTrainTestData(1);

		DecisionTree serdt = ReadFile.getDTFromFile(
				"data_5_attributes/thresh" + threshold + ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (!DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

class FillDTNode_NonDecreasingEntropy1 implements Runnable {
	@Override
	public void run() {
		boolean verbose = false;
		boolean force = false;

		int threshold = 1;
		DataReader dr = ReadFile
				.getCSVDataReader("data_non_decreasing_entropy.csv");
		dr.splitTrainTestData(1);

		DecisionTree serdt = ReadFile
				.getDTFromFile("data_non_decreasing_entropy/thresh" + threshold
						+ ".ser");
		DecisionTree dt = new DecisionTree(dr.trainData, threshold);

		if (DecisionTree.equals(serdt, dt)) {
			if (verbose) {
				new DecisionTreeVisualizer(serdt, "Expected");
				new DecisionTreeVisualizer(dt, "Received");
				Tester.pause();
			}
			throw new AssertionError("Test failed.");
		}

		if (verbose && force) {
			new DecisionTreeVisualizer(serdt, "Expected");
			new DecisionTreeVisualizer(dt, "Received (equal to expected)");
			Tester.pause();
		}
		System.out.println("Test passed.");
	}
}

/*
 * Checks that every method (including private ones) in Datum.java is one of the
 * required methods
 */
class Datum_extra_methods implements Runnable {
	@Override
	public void run() {
		Class<Datum> cls = Datum.class;
		TMethod[] requiredMethods = getRequiredMethods();

		for (Method m : cls.getDeclaredMethods()) {
			if (!TMethod.elementOf(m, requiredMethods)) {
				throw new AssertionError("Extra method found: " + m);
			}
		}
	}

	private TMethod[] getRequiredMethods() {
		TMethod[] requiredMethods = new TMethod[1];
		requiredMethods[0] = new TMethod(Modifier.PUBLIC, String.class,
				"toString", new Class[0], new Class[0]);
		return requiredMethods;
	}
}

/*
 * Checks that every method (including private ones) in DataReader is one of the
 * required methods
 */
class DataReader_extra_methods implements Runnable {
	@Override
	public void run() {
		Class<DataReader> cls = DataReader.class;
		TMethod[] requiredMethods = getRequiredMethods();

		for (Method m : cls.getDeclaredMethods()) {
			if (!TMethod.elementOf(m, requiredMethods)) {
				throw new AssertionError(
						"Extra non-private method found: " + m);
			}
		}
	}

	private TMethod[] getRequiredMethods() {
		TMethod[] requiredMethods = new TMethod[4];
		requiredMethods[0] = new TMethod(0, Void.TYPE, "read_data",
				new Class[]{String.class}, new Class[]{Exception.class});
		requiredMethods[1] = new TMethod(0, Void.TYPE, "splitTrainTestData",
				new Class[]{double.class}, new Class[0]);
		requiredMethods[2] = new TMethod(Modifier.PUBLIC + Modifier.STATIC,
				Void.TYPE, "writeSerializedTree",
				new Class[]{DecisionTree.class, String.class}, new Class[0]);
		requiredMethods[3] = new TMethod(Modifier.PUBLIC + Modifier.STATIC,
				DecisionTree.class, "readSerializedTree",
				new Class[]{String.class}, new Class[0]);
		return requiredMethods;
	}
}

/*
 * Checks that every non-private method in DecisionTree is one of the required
 * methods
 */
class DecisionTree_extra_methods implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree> cls = DecisionTree.class;
		TMethod[] requiredMethods = getRequiredMethods();

		for (Method m : cls.getDeclaredMethods()) {
			if (!Modifier.isPrivate(m.getModifiers())
					&& !TMethod.elementOf(m, requiredMethods)) {
				throw new AssertionError(
						"Extra non-private method found: " + m);
			}
		}
	}

	private TMethod[] getRequiredMethods() {
		TMethod[] requiredMethods = new TMethod[4];
		requiredMethods[0] = new TMethod(0, double.class, "calcEntropy",
				new Class[]{ArrayList.class}, new Class[0]);
		requiredMethods[1] = new TMethod(0, int.class, "classify",
				new Class[]{double[].class}, new Class[0]);
		requiredMethods[2] = new TMethod(0, String.class, "checkPerformance",
				new Class[]{ArrayList.class}, new Class[0]);
		requiredMethods[3] = new TMethod(Modifier.PUBLIC + Modifier.STATIC,
				boolean.class, "equals",
				new Class[]{DecisionTree.class, DecisionTree.class},
				new Class[0]);
		return requiredMethods;
	}
}

/*
 * Checks that every non-private method in DTNode is one of the required methods
 */
class DTNode_extra_methods implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree.DTNode> cls = DecisionTree.DTNode.class;
		TMethod[] requiredMethods = getRequiredMethods();

		for (Method m : cls.getDeclaredMethods()) {
			if (!Modifier.isPrivate(m.getModifiers())
					&& !TMethod.elementOf(m, requiredMethods)) {
				throw new AssertionError(
						"Extra non-private method found: " + m);
			}
		}
	}

	private TMethod[] getRequiredMethods() {
		TMethod[] requiredMethods = new TMethod[4];
		requiredMethods[0] = new TMethod(0, DecisionTree.DTNode.class,
				"fillDTNode",
				new Class[]{ArrayList.class}, new Class[0]);
		requiredMethods[1] = new TMethod(0, int.class, "findMajority",
				new Class[]{ArrayList.class}, new Class[0]);
		requiredMethods[2] = new TMethod(0, int.class, "classifyAtNode",
				new Class[]{double[].class}, new Class[0]);
		requiredMethods[3] = new TMethod(Modifier.PUBLIC, boolean.class,
				"equals",
				new Class[]{Object.class}, new Class[0]);
		return requiredMethods;
	}
}

/*
 * Checks that every field (including private ones) in Datum is one of the
 * required fields
 */
class Datum_extra_fields implements Runnable {
	@Override
	public void run() {
		Class<Datum> cls = Datum.class;
		TField[] requiredFields = getRequiredFields();

		for (Field f : cls.getDeclaredFields()) {
			if (!TField.elementOf(f, requiredFields))
				throw new AssertionError("Extra field found: " + f);
		}
	}

	private TField[] getRequiredFields() {
		TField[] requiredFields = new TField[2];
		requiredFields[0] = new TField(0, double[].class, "x");
		requiredFields[1] = new TField(0, int.class, "y");
		return requiredFields;
	}
}

/*
 * Checks that every field (including private ones) in DataReader is one of the
 * required fields
 */
class DataReader_extra_fields implements Runnable {
	@Override
	public void run() {
		Class<DataReader> cls = DataReader.class;
		TField[] requiredFields = getRequiredFields();

		for (Field f : cls.getDeclaredFields()) {
			if (!TField.elementOf(f, requiredFields))
				throw new AssertionError("Extra field found: " + f);
		}
	}

	private TField[] getRequiredFields() {
		TField[] requiredFields = new TField[3];
		requiredFields[0] = new TField(0, ArrayList.class, "datalist");
		requiredFields[1] = new TField(0, ArrayList.class, "trainData");
		requiredFields[2] = new TField(0, ArrayList.class, "testData");
		return requiredFields;
	}
}

/*
 * Checks that every field (including private ones) in DecisionTree is one of
 * the required fields
 */
class DecisionTree_extra_fields implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree> cls = DecisionTree.class;
		TField[] requiredFields = getRequiredFields();

		for (Field f : cls.getDeclaredFields()) {
			if (!TField.elementOf(f, requiredFields))
				throw new AssertionError("Extra field found: " + f);
		}
	}

	private TField[] getRequiredFields() {
		TField[] requiredFields = new TField[3];
		requiredFields[0] = new TField(0, DecisionTree.DTNode.class,
				"rootDTNode");
		requiredFields[1] = new TField(0, int.class, "minSizeDatalist");
		requiredFields[2] = new TField(
				Modifier.PUBLIC + Modifier.STATIC + Modifier.FINAL, long.class,
				"serialVersionUID");
		return requiredFields;
	}
}

/*
 * Checks that every non-private field in DTNode is one of the required fields
 */
class DTNode_extra_fields implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree.DTNode> cls = DecisionTree.DTNode.class;
		TField[] requiredFields = getRequiredFields();

		for (Field f : cls.getDeclaredFields()) {
			if (!Modifier.isPrivate(f.getModifiers())
					&& !TField.elementOf(f, requiredFields))
				throw new AssertionError("Extra field found: " + f);
		}
	}

	private TField[] getRequiredFields() {
		TField[] requiredFields = new TField[8];
		requiredFields[0] = new TField(
				Modifier.PUBLIC + Modifier.STATIC + Modifier.FINAL, long.class,
				"serialVersionUID");
		requiredFields[1] = new TField(0, boolean.class, "leaf");
		requiredFields[2] = new TField(0, int.class, "label");
		requiredFields[3] = new TField(0, int.class, "attribute");
		requiredFields[4] = new TField(0, double.class, "threshold");
		requiredFields[5] = new TField(0, DecisionTree.DTNode.class, "left");
		requiredFields[6] = new TField(0, DecisionTree.DTNode.class, "right");
		requiredFields[7] = new TField(4112, DecisionTree.class, "this$0");
		return requiredFields;
	}
}

/*
 * Checks that every constructor (including private ones) in Datum is one of the
 * required constructors
 */
class Datum_extra_constructors implements Runnable {
	@Override
	@SuppressWarnings("rawtypes")
	public void run() {
		Class<Datum> cls = Datum.class;
		TConstructor[] requiredConstructors = getRequiredConstructors();

		for (Constructor c : cls.getDeclaredConstructors()) {
			if (!TConstructor.elementOf(c, requiredConstructors))
				throw new AssertionError("Extra constructor found: " + c);
		}
	}

	public TConstructor[] getRequiredConstructors() {
		TConstructor[] requiredConstructors = new TConstructor[1];
		// Get rid of "class " at beginning of name
		String name = Datum.class.toString().split(" ")[1];

		requiredConstructors[0] = new TConstructor(0, name,
				new Class[]{double[].class, int.class}, new Class[0]);
		return requiredConstructors;
	}
}

/*
 * Checks that every constructor (including private ones) in DataReader is one
 * of the required constructors
 */
class DataReader_extra_constructors implements Runnable {
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		Class<DataReader> cls = DataReader.class;
		TConstructor[] requiredConstructors = getRequiredConstructors();

		for (Constructor c : cls.getDeclaredConstructors()) {
			if (!TConstructor.elementOf(c, requiredConstructors))
				throw new AssertionError("Extra constructor found: " + c);
		}
	}

	public TConstructor[] getRequiredConstructors() {
		TConstructor[] requiredConstructors = new TConstructor[1];
		// Get rid of "class" at beginning of name
		String name = DataReader.class.toString().split(" ")[1];

		requiredConstructors[0] = new TConstructor(0, name, new Class[0],
				new Class[0]);
		return requiredConstructors;
	}
}

/*
 * Checks that every constructor (including private ones) in DecisionTree is one
 * of the required constructors
 */
class DecisionTree_extra_constructors implements Runnable {
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		Class<DecisionTree> cls = DecisionTree.class;
		TConstructor[] requiredConstructors = getRequiredConstructors();

		for (Constructor c : cls.getDeclaredConstructors()) {
			if (!TConstructor.elementOf(c, requiredConstructors))
				throw new AssertionError("Extra constructor found: " + c);
		}
	}

	public TConstructor[] getRequiredConstructors() {
		TConstructor[] requiredConstructors = new TConstructor[1];
		// Get rid of "class" at beginning of name
		String name = DecisionTree.class.toString().split(" ")[1];

		requiredConstructors[0] = new TConstructor(Modifier.PUBLIC, name,
				new Class[]{ArrayList.class, int.class}, new Class[0]);
		return requiredConstructors;
	}
}

/*
 * Checks that every constructor (including private ones) in DTNode is one of
 * the required constructors
 */
class DTNode_extra_constructors implements Runnable {
	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		Class<DecisionTree.DTNode> cls = DecisionTree.DTNode.class;
		TConstructor[] requiredConstructors = getRequiredConstructors();

		for (Constructor c : cls.getDeclaredConstructors()) {
			if (!TConstructor.elementOf(c, requiredConstructors))
				throw new AssertionError("Extra constructor found: " + c);
		}
	}

	public TConstructor[] getRequiredConstructors() {
		TConstructor[] requiredConstructors = new TConstructor[1];
		// Get rid of "class" at beginning of name
		String name = DecisionTree.DTNode.class.toString().split(" ")[1];

		requiredConstructors[0] = new TConstructor(0, name,
				new Class[]{DecisionTree.class}, new Class[0]);
		return requiredConstructors;
	}
}

/*
 * Checks that every nested class (including private ones) in Datum is one of
 * the required nested classes
 */
@SuppressWarnings("rawtypes")
class Datum_extra_classes implements Runnable {
	@Override
	public void run() {
		Class<Datum> cls = Datum.class;
		Class[] requiredClasses = getRequiredClasses();

		for (Class c : cls.getDeclaredClasses()) {
			if (!Arrays.asList(requiredClasses).contains(c))
				throw new AssertionError("Extra nested class found: " + c);
		}
	}

	public Class[] getRequiredClasses() {
		Class[] requiredClasses = new Class[0];
		return requiredClasses;
	}
}

/*
 * Checks that every nested class (including private ones) in DataReader is one
 * of the required nested classes
 */
@SuppressWarnings("rawtypes")
class DataReader_extra_classes implements Runnable {
	@Override
	public void run() {
		Class<DataReader> cls = DataReader.class;
		Class[] requiredClasses = getRequiredClasses();

		for (Class c : cls.getDeclaredClasses()) {
			if (!Arrays.asList(requiredClasses).contains(c))
				throw new AssertionError("Extra nested class found: " + c);
		}
	}

	public Class[] getRequiredClasses() {
		Class[] requiredClasses = new Class[0];
		return requiredClasses;
	}
}

/*
 * Checks that every nested class (including private ones) in DecisionTree is
 * one of the required nested classes
 */
@SuppressWarnings("rawtypes")
class DecisionTree_extra_classes implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree> cls = DecisionTree.class;
		Class[] requiredClasses = getRequiredClasses();

		for (Class c : cls.getDeclaredClasses()) {
			if (!Arrays.asList(requiredClasses).contains(c))
				throw new AssertionError("Extra nested class found: " + c);
		}
	}

	public Class[] getRequiredClasses() {
		Class[] requiredClasses = new Class[1];
		requiredClasses[0] = DecisionTree.DTNode.class;
		return requiredClasses;
	}
}

/*
 * Checks that every nested class (including private ones) in DTNode is one of
 * the required nested classes
 */
@SuppressWarnings("rawtypes")
class DTNode_extra_classes implements Runnable {
	@Override
	public void run() {
		Class<DecisionTree.DTNode> cls = DecisionTree.DTNode.class;
		Class[] requiredClasses = getRequiredClasses();

		for (Class c : cls.getDeclaredClasses()) {
			if (!Arrays.asList(requiredClasses).contains(c))
				throw new AssertionError("Extra nested class found: " + c);
		}
	}

	public Class[] getRequiredClasses() {
		Class[] requiredClasses = new Class[0];
		return requiredClasses;
	}
}

class Illegal_helper_code implements Runnable {
	private static String[] tests = {"Datum_extra_methods",
			"Datum_extra_fields", "Datum_extra_constructors",
			"Datum_extra_classes", "DataReader_extra_methods",
			"DataReader_extra_fields", "DataReader_extra_constructors",
			"DataReader_extra_classes", "DecisionTree_extra_methods",
			"DecisionTree_extra_fields", "DecisionTree_extra_constructors",
			"DecisionTree_extra_classes", "DTNode_extra_methods",
			"DTNode_extra_fields",
			"DTNode_extra_constructors", "DTNode_extra_classes"};

	@Override
	public void run() {
		for (String str : tests) {
			try {
				Runnable testCase = (Runnable) Class.forName(str)
						.getDeclaredConstructor().newInstance();
				testCase.run();
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				e.printStackTrace();
				throw new AssertionError(
						"An unexpected error occurred and the test " + str
						+ " could not be run.");
			}
		}

		System.out.println("Test passed.");
	}
}

// Utility classes
// ==========================================================================================

class ReadFile {
	public static String localDir = System.getProperty("user.dir");
	// You might need to change these based on your operating system.
	public static String base = localDir + "/src/data/";
	// You might need to change these based on your operating system.
	public static String basedb = localDir + "/src/data/db/";

	public static DecisionTree getDTFromFile(String filename) {
		DecisionTree dt = DataReader.readSerializedTree(base + filename);
		if (dt == null)
			throw new AssertionError("[ERROR] Could not read DT from file.");
		return dt;
	}

	public static DataReader getCSVDataReader(String filename) {
		DataReader dr = new DataReader();
		try {
			dr.read_data(basedb + filename);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("[ERROR] Could not read csv file.");
		}
		return dr;
	}
}

/*
 * Stores information about methods. Is meant to be compared to instances of
 * java.lang.reflect.Method (which has no public constructor).
 */
@SuppressWarnings("rawtypes")
class TMethod {
	private int modifiers;
	private Class returnType;
	private String name;
	private Class[] params;
	private Class[] exceptions;

	/*
	 * Creates a new TMethod by saving all the given arguments directly to the
	 * corresponding fields
	 */
	public TMethod(int modifiers, Class returnType, String name, Class[] params,
			Class[] exceptions) {
		this.modifiers = modifiers;
		this.returnType = returnType;
		this.name = name;
		this.params = params;
		this.exceptions = exceptions;
	}

	/*
	 * A TMethod is equal to a TMethod or a Method if and only if all its fields
	 * match
	 *
	 * This operation is not commutative for TMethods and Methods
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Method) {
			Method m = (Method) o;
			return this.modifiers == m.getModifiers()
					&& this.returnType.equals(m.getReturnType())
					&& this.name.equals(m.getName())
					&& Arrays.equals(this.params, m.getParameterTypes())
					&& Arrays.equals(this.exceptions, m.getExceptionTypes());
		} else if (o instanceof TMethod) {
			TMethod t = (TMethod) o;
			return this.modifiers == t.modifiers
					&& this.returnType.equals(t.returnType)
					&& this.name.equals(t.name)
					&& Arrays.equals(this.params, t.params)
					&& Arrays.equals(this.exceptions, t.exceptions);
		} else
			return false;
	}

	/*
	 * Checks if method is equal (using TMethod.equals(method)) to any of the
	 * elements in tMethods
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean elementOf(Method method, TMethod[] tMethods) {
		for (TMethod t : tMethods) {
			if (t.equals(method))
				return true;
		}
		return false;
	}
}

/*
 * Stores information about Fields. Is meant to be compared to instances of
 * java.lang.reflect.Field (which has no public constructor).
 */
@SuppressWarnings("rawtypes")
class TField {
	private int modifiers;
	private Class type;
	private String name;

	/*
	 * Creates a new TField by saving all the given arguments directly to the
	 * corresponding fields
	 */
	public TField(int modifiers, Class type, String name) {
		this.modifiers = modifiers;
		this.type = type;
		this.name = name;
	}

	/*
	 * A TField is equal to a TField or a Field if and only if all its fields
	 * match
	 *
	 * This operation is not commutative for TFields and Fields
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Field) {
			Field f = (Field) o;
			return this.modifiers == f.getModifiers()
					&& this.type.equals(f.getType())
					&& this.name.equals(f.getName());
		} else if (o instanceof TField) {
			TField t = (TField) o;
			return this.modifiers == t.modifiers && this.type.equals(t.type)
					&& this.name.equals(t.name);
		} else
			return false;
	}

	/*
	 * Checks if field is equal (using TField.equals(field)) to any of the
	 * elements in tFields
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean elementOf(Field field, TField[] tFields) {
		for (TField t : tFields) {
			if (t.equals(field))
				return true;
		}
		return false;
	}
}

/*
 * Stores information about Constructors. Is meant to be compared to instances
 * of java.lang.reflect.Constructor (which has no public constructor*).
 *
 * * "Ironic. He could constructor others, but not himself."
 */
@SuppressWarnings("rawtypes")
class TConstructor {
	private int modifiers;
	private String name;
	private Class[] params;
	private Class[] exceptions;

	/*
	 * Creates a new TMethod by saving all the given arguments directly to the
	 * corresponding fields
	 */
	public TConstructor(int modifiers, String name, Class[] params,
			Class[] exceptions) {
		this.modifiers = modifiers;
		this.name = name;
		this.params = params;
		this.exceptions = exceptions;
	}

	/*
	 * A TConstructor is equal to a TConstructor or a Constructor if and only if
	 * all its fields match
	 *
	 * This operation is not commutative for TConstructors and Constructors
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Constructor) {
			Constructor c = (Constructor) o;
			return this.modifiers == c.getModifiers()
					&& this.name.equals(c.getName())
					&& Arrays.equals(this.params, c.getParameterTypes())
					&& Arrays.equals(this.exceptions, c.getExceptionTypes());
		} else if (o instanceof TConstructor) {
			TConstructor t = (TConstructor) o;
			return this.modifiers == t.modifiers && this.name.equals(t.name)
					&& Arrays.equals(this.params, t.params)
					&& Arrays.equals(this.exceptions, t.exceptions);
		} else
			return false;
	}

	/*
	 * Checks if constructor is equal (using TConstructor.equals(constructor))
	 * to any of the elements in tConstructors
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean elementOf(Constructor constructor,
			TConstructor[] tConstructors) {
		for (TConstructor t : tConstructors) {
			if (t.equals(constructor))
				return true;
		}
		return false;
	}
}

// Main class
// ================================================================================

public class Tester {
	private static Scanner sc = new Scanner(System.in);
	// To skip running some tests, just comment them out below.
	static String[] tests = {
			"Illegal_helper_code",
			"DecisionTree_classify1",
			"DecisionTree_classify2",
			"DecisionTree_classify3",
			"DecisionTree_classify4",
			"Equals_HighDiffFiles",
			"Equals_HighSameFiles",
			"Equals_MinDiffFiles",
			"Equals_MinSameFiles",
			"Equals_PartialDiffFiles",
			"Equals_PartialSameFiles",
			"FillDTNode_High1",
			"FillDTNode_High2",
			"FillDTNode_High3",
			"FillDTNode_Min1",
			"FillDTNode_Min2",
			"FillDTNode_Min3",
			"FillDTNode_Min4",
			"FillDTNode_Partial1",
			"FillDTNode_Partial2",
			"FillDTNode_Partial3",
			"Classify_3Attributes1",
			"Classify_5Attributes1",
			"Equals_String",
			"Equals_Null",
			"FillDTNode_3Attributes1",
			"FillDTNode_3Attributes64",
			"FillDTNode_5Attributes1",
			"FillDTNode_5Attributes64",
			"FillDTNode_NonDecreasingEntropy1",
	};

	public static void main(String[] args) {
		int[] thresh = new int[]{1,64};
           // createTestData(3, thresh);
           // createTestData(5, thresh);
            int numPassed = 0;
		ArrayList<String> failedTests = new ArrayList<String>(tests.length);
		for (String className : tests) {
			System.out.printf("%n======= %s =======%n", className);
			System.out.flush();
			try {
				Runnable testCase = (Runnable) Class.forName(className)
						.getDeclaredConstructor().newInstance();
				testCase.run();
				numPassed++;
			} catch (AssertionError e) {
				System.out.println(e);
				failedTests.add(className);
			} catch (StackOverflowError e) {
				StackTraceElement[] elements = e.getStackTrace();
				System.out.println(className + " caused a stack overflow at: ");
				for (int i = 0; i < 5 && i < elements.length; i++) {
					System.out.println(elements[i]);
				}
				if (elements.length >= 5) {
					System.out.println("...and " + (elements.length - 5)
							+ " more elements.");
				}
				failedTests.add(className);
			} catch (Throwable t) {
				t.printStackTrace();
				failedTests.add(className);
			}
		}
		System.out.printf("%n%n%d of %d tests passed.%n", numPassed,
				tests.length);
		if (failedTests.size() > 0) {
			System.out.println("Failed test(s):");
			for (String className : failedTests) {
				int dotIndex = className.indexOf('.');
				System.out.println("  " + className.substring(dotIndex + 1));
			}
		}
		if (numPassed == tests.length) {
			System.out.println("All clear! Great work :)");
		}
	}

	public static void pause() {
		System.out.println("Press ENTER to continue");
		sc.nextLine();
	}

	public static void makeRandomDataset(int numValues, int numAttributes,
			String filename) {
		Random rand = new Random();

		try (PrintWriter pw = new PrintWriter(new File(filename))) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numValues; i++) {
				for (int j = 0; j < numAttributes; j++) {
					sb.append(10 * rand.nextDouble() + ",");
				}
				if (rand.nextBoolean())
					sb.append("0\n");
				else
					sb.append("1\n");
			}

			pw.write(sb.toString());
			// System.out.println("Successfully wrote " + numValues + "
			// datapoints with " + numAttributes
			// + " attributes to " + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTestData(int numAttributes, int[] thresholds) {
		String csvFilename = "data_" + numAttributes + "_attributes.csv";

		// Generate dataset
		makeRandomDataset(200, numAttributes, ReadFile.basedb + csvFilename);

		// Create and serialize tree(s)
		DataReader dr = ReadFile.getCSVDataReader(csvFilename);
		dr.splitTrainTestData(1);
		for (int threshold : thresholds) {
			DecisionTree dt = new DecisionTree(dr.trainData, threshold);
			DataReader.writeSerializedTree(dt,
					ReadFile.base + "data_" + numAttributes
					+ "_attributes/thresh" + threshold + ".ser");
			new DecisionTreeVisualizer(dt,
					"New tree (threshold " + threshold + ")");
		}
	}
}
