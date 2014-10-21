/* 
Perform Binary Search on Java ArrayList Example
This java example shows how to search an element of Java ArrayList 
using binarySearch method of Collections class. binarySearch method uses
binary search algorithm to search an element.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchArrayList
{
	public static void main(String[] args) 
	{
		//create an ArrayList object
		ArrayList <String>arrayList = new ArrayList<String>();

		try 
		{
			File file = new File("birmingham.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String word = scanner.next();
				arrayList.add(word);
         		}
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		/*To Search an element of Java ArrayList using binary search algorithm use,
		static int binarySearch(List list, Object element) method of Collections class.
		This method returns the index of the value to be searched, if found in the
		ArrayList.

		Otherwise it returns (- (X) - 1) where X is the index where the the search value would be inserted.
		i.e. index of first element that is grater than the search value
		or ArrayList.size(), if all elements of an ArrayList are less 
		than the search value.

		Please note that the ArrayList MUST BE SORTED before it can be searched
		using binarySearch method.*/

		//First sort an ArrayList using sort method of Collections class
		Collections.sort(arrayList);

		System.out.println("\n\n\nSorted ArrayList contains : " + arrayList + "\n");

		//search an element using binarySearch method of Collections class
		String element = "birmingham";
		int index = Collections.binarySearch(arrayList,element);
		System.out.println(element + " found at : " + index + "\n\n\n");
	}
}

//Back to APCS Main Page


