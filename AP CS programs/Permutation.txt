///Venkata Poreddy
///Prints list of random permutations of 1 - 10
///asks user input for number of permutations

import java.util.*;

public class PermutationGenerator
{
	public static void main(String[] args)
	{
		Scanner Scn = new Scanner(System.in);
		boolean badinput = false;
		while(!badinput)
		{
			System.out.print("Enter the number of permutations you want to see (positive integer value): ");
			int NumberOfLines = Scn.nextInt(); //user inputs number of permutations
			if(NumberOfLines<1) System.out.println("Enter a positive integer value!"); ///if user inputs negative value
			else ///if input is OK
			{
				Permutations(NumberOfLines);
				badinput = true; ///end loop
			}
		}
	}
	
	public static void Permutations(int NumberOfLines) ///prints permutations
	{
		Random Rand = new Random(); //random number generator
		ArrayList OneToTen = new ArrayList(9); //pre-defined 1-10 array
		int RandLimit = 9; //max limit of the random generator
		int RandPosition = 0; //assigned a random number from 0-9
		
		for(int Line = 1; Line <= NumberOfLines; Line++) ///loop runs equal to number of permutations
		{
			System.out.print("List " + Line + ": ");
			RandLimit = 10; ///reset max limit
			
			for(int FillArray = 1; FillArray <=10; FillArray++) ///re-fills array with numbers 1-10
			{
				OneToTen.add(FillArray); 
			}
			
			for(int Position = 0; Position < 10; Position++)
			{
				RandPosition = Rand.nextInt(RandLimit); ///assigns a random number from 0-9
				System.out.print(OneToTen.get(RandPosition) + " ");
				OneToTen.remove(RandPosition); 
				RandLimit--; ///decrement max limit because there are less spots left in array
			}
			
			System.out.println(); ///new-line at end of each permutation
		}
	}
}
