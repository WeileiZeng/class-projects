import java.util.*;
public class CheckMail
{
	private int myDim1;
	private int myDim2;
	private int myDim3;
	private int myWeight;
	private int mySize;
	
	public CheckMail()
	{
		int dim1 = 0;
		int dim2 = 0;
		int dim3 = 0;
		int weight = 0;
	}
	
	public CheckMail(int dim1, int dim2, int dim3, int weight)
	{
		myDim1 = dim1;
		myDim2 = dim2;
		myDim3 = dim3;
		myWeight = weight;
	}
		
	public void FindLength(int dim1, int dim2, int dim3)
	{
		if (dim2>dim1)
		{
			int temp2 = dim1;
			dim1 = dim2;
			dim2 = temp2;
		}
		if (dim3>dim1)
		{
			int temp2 = dim1;
			dim1 = dim3;
			dim3 = temp2;
		}
	}
	
	public int FindSize(int dim1, int dim2, int dim3)
	{
		FindLength(dim1, dim2, dim3);
		mySize = 2*(dim2 + dim3) + dim1;
		return mySize;
	}
		
	public void Checker(CheckMail temp)
	{

		mySize = FindSize(temp.myDim1, temp.myDim2, temp.myDim3);
		if (mySize > 100)
		{
			if (temp.myWeight > 70) System.out.println("PACKAGE IS TOO LARGE AND TOO HEAVY\n");
			else System.out.println("PACKAGE IS TOO LARGE\n");
		}
		else if (temp.myWeight > 70) System.out.println("PACKAGE IS TOO HEAVY\n");
		else System.out.println("PACKAGE IS ACCEPTABLE\n");
	}
	
	public String toString()
	{
		return ("Dimensions: " + myDim1 + ", " + myDim2 + ", " + myDim3 + " Weight: " + myWeight);
	}
		
}	
