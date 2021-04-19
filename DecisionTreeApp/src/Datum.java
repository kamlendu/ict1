
//This class holds the information of a single datapoint

public class Datum {

	double[] x; //the attributes
	int y;     // the label


	Datum(double[] x,int y) {
		this.x = new double[x.length];
		for (int i = 0 ; i< x.length ; i++){
			this.x[i] = x[i];
		}
		this.y = y;
	}
	
	public String toString() {
		String str= "";
		int l = this.x.length;
		for (int i = 0 ; i < l ; i++)
		{
			str = str+"x"+i+" :"+this.x[i];
		}
		str = str + "y :"+this.y;
		return str;
	}
}

