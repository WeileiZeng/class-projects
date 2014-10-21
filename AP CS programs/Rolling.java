import java.io.*;
import java.util.*;
public class Rolling
{
	public static void main(String[] args)
	{
		int trials = 0;
		int counter=0;
		boolean condition1 = false; boolean condition2 = false;
		while(!condition1 || !condition2)
		{
			counter=Roller();
			if (counter==1)
			{ 
				System.out.println("Took " + counter + " count to get a unique roll");
				condition1 = true;
				trials++;
			} 
			else
			{
				System.out.println("Took " + counter + " counts to get a unique roll");
				condition2 = true;
				trials++;
			}
		}
		System.out.println("\nTook " + trials + " trials to meet both conditions");
	}
	
	public static int Roller()
	{
		Random rand = new Random();
		boolean unique = false;
		int[] diceroll = new int[6];		
		int counter=0;
		while(!unique)
		{
			for(int x=1; x<=3; x++)
			{
				diceroll[x] = rand.nextInt(6)+1;
				System.out.print(diceroll[x] + " ");
			}
			counter++;
			System.out.println();
			if (diceroll[1]!=diceroll[2]&&diceroll[2]!=diceroll[3]&&diceroll[1]!=diceroll[3]) unique = true;
		}
		return counter;
	}
}
