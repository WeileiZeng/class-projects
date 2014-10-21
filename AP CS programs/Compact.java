// Venkata Poreddy
// Period 3
// Compact.java: puts integers from a text file into an array, and then removes zeros from that array.
import java.util.*;
import java.io.*;
public class Compact
{
	public static void main(String[] args)
	{
		final int MAX = 100; 	                                       //max amount of integers in Compact.txt
		Scanner in; 		                                           //reads integers from Compact.txt
		int CompactArray[] = new int[MAX]; 	                           //Array created with size equal to max amount
		int amount = 0; 		                                       //later used as amount of integers

		System.out.print("Array before compacting: ");
		
		try
		{
    		in = new Scanner(new File("Compact.txt"));                 //reads integers from Compact.txt
    		while (in.hasNext())	                                   //while there are still integers in Compact.txt
    		{
     			CompactArray[amount] = in.nextInt();			       //place integer in array
     			System.out.print(CompactArray[amount] + " ");          //prints out integer
     			amount++;			                                   //increase amount of integers
			}
		}
		catch(Exception i)
		{
     		System.out.println("Error: " + i.getMessage());
		}
		
		System.out.println(); 		                                   //new line before printing compacted array
		for (int looper2 = 0; looper2 < amount; looper2++) 		       //while less than amount of integers
		{
			if(CompactArray[looper2]==0)		                       //if a zero is found
			{
				for(int looper3 = looper2; looper3 < amount; looper3++)//from location where the zero is found to the end of the integers
				{
					CompactArray[looper3] = CompactArray[looper3+1];   //move all integers up a spot
				}
				CompactArray[amount] = 0;			                   //put the zero in the very last spot
				amount--;		                                       //decrement amount of integers (zeros don't count)
				looper2--;		                                       //in case there is another zero right after this one
			}
		}
		System.out.print("Compacted array: ");
		for(int looperfinal = 0;looperfinal<amount; looperfinal++)
		{
			System.out.print(CompactArray[looperfinal] + " ");		   //prints out compacted array
		}
		System.out.println();
	}
}

