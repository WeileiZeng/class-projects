// Venkata Poreddy
// Period 3
// Compact.java
import java.util.*;
import java.io.File;
public class Compact2
{
	public static void main(String[] args)
	{
		final int MAX = 100; // max amount of integers in Compact.txt
		Scanner in; //reads integers from Compact.txt
		int CompactArray[] = new int[MAX]; //Array created with size equal to max amount
		int amount = 0; //later used as amount of non-zeros

		System.out.print("Array before compacting: ");
		
		try
		{
    		in = new Scanner(new File("Compact.txt"));
    		while (in.hasNext())
    		{
     			CompactArray[amount] = in.nextInt();
     			System.out.print(CompactArray[amount] + " ");
     			amount++;
			}
		}
		catch(Exception i)
		{
     		System.out.println("Error: " + i.getMessage());
		}
		System.out.println();
		for (int looper2 = 0; looper2 < amount; looper2++)
		{
			if(CompactArray[looper2]==0)
			{
				for(int looper3 = looper2; looper3 < amount; looper3++)
				{
					CompactArray[looper3] = CompactArray[looper3+1];
				}
				CompactArray[amount] = 0;
				amount--;
				looper2--;
			}
		}
		System.out.print("Compacted array: ");
		for(int looperfinal = 0;looperfinal<amount; looperfinal++)
		{
			System.out.print(CompactArray[looperfinal] + " ");
		}
		System.out.println();
}
}

		
		
