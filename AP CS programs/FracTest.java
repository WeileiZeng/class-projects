//\\=//\\=//\\=<(._.)>=//\\=//\\=//\\
import java.util.*;
public class FracTest
{
	public static void main(String[] args)
	{
		//get fraction 1
		System.out.println("Fraction 1");
		System.out.print("Enter the numerator: ");
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		System.out.print("Enter the denominator: ");
		int denom = scn.nextInt();
		Fraction Frac1 = new Fraction(num, denom);
		
		//get fraction 2
		System.out.println("Fraction 2");
		System.out.print("Enter the numerator: ");
		num = scn.nextInt();
		System.out.print("Enter the denominator: ");
		denom = scn.nextInt();
		Fraction Frac2 = new Fraction(num, denom);
		
		//answer
		Fraction Ans = new Fraction(0, 1);

		//add
		Ans=Ans.Add(Frac1, Frac2);
		System.out.println(Frac1 + " + " + Frac2 + " = " + Ans);
		
		//subtract
		Ans=Ans.Subtract(Frac1, Frac2);
		System.out.println(Frac1 + " - " + Frac2 + " = " + Ans);
		
		//multiply
		Ans = Frac1.Mult2(Frac2);
		System.out.println(Frac1 + " * " + Frac2 + " = " + Ans);
		
		//divide
		Ans=Ans.Divide(Frac1, Frac2);
		System.out.println(Frac1 + " / " + Frac2 + " = " + Ans);

	}
}
