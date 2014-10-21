import java.util.*;
import java.io.*;
public class mergeSortTester
{
	
	public static void main(String[] args)
	{
		mergeSort sort = new mergeSort();
		ArrayList <Integer> sortarray = new ArrayList <Integer> ();
		Scanner in;
		int x=0;
		int y=0;
		try
		{
    		in = new Scanner(new File("Sort.txt"));                 
    		while (in.hasNext())	                                   
    		{
    			x = new Integer(in.nextInt());
     			sortarray.add(x);	
     			//System.out.print(x + " ");	         			          		                                   
			}
		}
		catch(Exception i)
		{
     		System.out.println("Error: " + i.getMessage());
		}

		/*sort.bubbleSort(sortarray);
		System.out.println();
		System.out.println("Number of steps in Bubble sort: " + sort.getStepCount());
		sort.setStepCount(0);
		System.out.println("Error: " + i.getMessage());
		}

		sort.selectionSort(sortarray);
		System.out.println();
		System.out.println("Number of steps in Selection sort: " + sort.getStepCount());
		sort.setStepCount(0);

		sort.insertionSort(sortarray);
		System.out.println();
		System.out.println("Number of steps in Insertion sort: " + sort.getStepCount());
		sort.setStepCount(0);*/
		
		sort.mergeSort3(sortarray, 0, sortarray.size());
		System.out.println();
		//System.out.println("Number of steps in Insertion sort: " + sort.getStepCount());
		//sort.setStepCount(0);

	}
}
