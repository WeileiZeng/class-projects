public class Son extends Father {
	private int m;
	protected int n;
	public int p;
	
	public Son() {
		super();
//		x = y = z = 9;
//		a = b = c = 8;
		m = n = p = 3;
	}
	public static void main(String[] args) {
		GrandFather hen = new GrandFather();
//		hen.x = 9;
		hen.y = 8;
		hen.z = 6;
		
		Father rus = new Father();
//		rus.x = 9;
		rus.y = 8;
		rus.z = 7;
//		rus.a = 6;
		rus.b = 5;
		rus.c = 4;
		
		Son scott = new Son();
		scott.Changex(5);
	}
}

class Father extends GrandFather {
	private int a;
	protected int b;
	public int c;
	
	public Father() {
		a = 8;
		b = 9;
		c = 3;
//		x = 9;
//		y = 8;
//		z = 1;
	}
}

class GrandFather {
	private int x;
	protected int y;
	public int z;
	
	public GrandFather()  {
		x = y = z = 4;
	}
	
	public void Changex (int change) {
		x += change;
	}
}
