//\\=//\\=//\\=<(._.)>=//\\=//\\=//\\
public class Fraction
{
	
	private int myNumerator;
	private int myDenominator;

	public Fraction()
	{
		int Numerator = 0;
		int Denominator = 1;
	}
	
	public Fraction(int Numerator, int Denominator)
	{
		myNumerator = Numerator;
		myDenominator = Denominator;
	}
	
	public void Setter(Fraction temp)
	{
		temp.myNumerator = myNumerator;
		temp.myDenominator = myDenominator;
	}
	
	public int GCF(Fraction temp)
	{
		int rem = 0;
		int N = temp.myNumerator;
		int D = temp.myDenominator;
		while (N % D != 0)
		{
			rem = N%D;
			N = D;
			D = rem;
		}
		return D;
	}
	
	public Fraction Reduce(Fraction temp)
	{
		int greatestcommon = GCF(temp);
		int N2; int D2;
		N2 = temp.myNumerator/greatestcommon;
		D2 = temp.myDenominator/greatestcommon;
		Fraction Ans = new Fraction(N2, D2);
		return Ans;
	}
		
	public int LCD(Fraction Frac1, Fraction Frac2)
	{
		int y = Frac1.myDenominator * Frac2.myDenominator;
		for (int a=1; a<y; a++)
		{
			for(int b=1; b<y; b++)
			{
				if (y/a == y/b && (y/a)%Frac1.myDenominator==0 && (y/a)%Frac2.myDenominator==0)
				{
					y = y/a;
				}
			}
		}	
		return y;	
	}
	
	public int Add()
	{
		int x = 0;
		return x;
	}
	
	public void Mult (Fraction temp, Fraction temp2)
	{
		myNumerator = temp.myNumerator * temp2.myNumerator;
		myDenominator = temp.myDenominator * temp2.myDenominator;
	}
	
	public Fraction Mult2 (Fraction temp)
	{
		int Num = myNumerator * temp.myNumerator;
		int Den = myDenominator * temp.myDenominator;
		Fraction A = new Fraction (Num,Den);
		A = Reduce(A);
		return A;
	}
	
	public String toString()
	{
		return (myNumerator + "/" + myDenominator);
	}
	
	public Fraction Add (Fraction temp1, Fraction temp2)
	{
		int N = temp1.myNumerator*temp2.myDenominator + temp2.myNumerator*temp1.myDenominator;
		int D = temp1.myDenominator*temp2.myDenominator;
		Fraction Ans = new Fraction(N, D);
		Ans = Reduce(Ans);
		return Ans;
	}
	
	public Fraction Subtract (Fraction temp1, Fraction temp2)
	{
		int N = temp1.myNumerator*temp2.myDenominator - temp2.myNumerator*temp1.myDenominator;
		int D = temp1.myDenominator*temp2.myDenominator;
		Fraction Ans = new Fraction(N, D);
		Ans = Reduce(Ans);
		return Ans;
	}
	
	public Fraction Divide (Fraction temp, Fraction temp2)
	{
		int N = temp.myNumerator * temp2.myDenominator;
		int D = temp.myDenominator * temp2.myNumerator;
		Fraction Ans = new Fraction(N, D);
		Ans = Reduce(Ans);
		return Ans;
	}
	
}
