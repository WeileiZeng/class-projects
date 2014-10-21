public class NamedPointDemo   {
	public static void main ( String [] args )   {
		System.out.println ( "HEY!" );
	}
}

class Point   {

	private int myX; 	// coordinates
	private int myY;

	public Point()   {
		myX = 0;
		myY = 0;
	}

	public Point(int a, int b)   {
		myX = a;
		myY = b;
	}

	// ... other methods not shown
}

class NamedPoint extends Point   {

	private String myName;

	public NamedPoint()   {
		myName = "";
	}

//	public NamedPoint(int d1, int d2, String name)   {
//		myX = d1;
//		myY = d2;
//		myName = name;
//	}

	public NamedPoint(int d1, int d2, String name)   {
		super(d1, d2);
		myName = name;
	}

	// ... other methods not shown
}
