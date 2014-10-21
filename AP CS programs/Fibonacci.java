import java.util.*; 
public class Fibonacci
{
	public static void main (String[] args)
	{
		System.out.println("Fibonacci: ");
		System.out.print("Enter a position to get the Fibonacci value: ");  
		Scanner scn = new Scanner(System.in);
		int position = scn.nextInt();
		System.out.println("Fibbonaci value: " + fib(position));
		
		System.out.println("\nRecursive multiplication: ");
		System.out.print("Enter the first factor: ");
		int factor1 = scn.nextInt();
		System.out.print("Enter the second factor: ");
		int factor2 = scn.nextInt();
		System.out.println(factor1 + " x " + factor2 + " = " + recmult(factor1, factor2));
	}
	
	static int fib (int temp)
	{
		if(temp==0) return 0;
     	else if(temp==1 || temp==2) return 1;
		else return fib(temp-1) + fib(temp-2);
    }
    
    static int recmult (int factor1, int factor2)
    {
    	if(factor1==1) return factor2;
    	if(factor2==1) return factor1;
    	if(factor1==0 || factor2==0) return 0;
    	else return recmult(factor1,factor2-1)+factor1;
	}
}


