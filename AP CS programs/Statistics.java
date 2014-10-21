// Venkata Poreddy
// 1/19/10
// Period 3
// Calculates average, standard deviation, and mode of a list of 
// numbers from a text file

import java.util.*;
import java.io.*;

public class  Statistics {
	
	public static String getFileName () {
		Scanner readInput = new Scanner(System.in);
		System.out.print("Enter input file name: ");
		String fileName = readInput.nextLine();
		return fileName;
	}
	
	public static ArrayList<Integer> readText (String fileName) {
		ArrayList<Integer> numbers = new ArrayList<Integer> ();
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				numbers.add(in.nextInt());
			}
		}
		catch(IOException i) {
		System.out.println("Error: " + i.getMessage());
		}
		Collections.sort(numbers;
		return numbers;
	}
	
	public static double findAverage (ArrayList<Integer> numbers) {
		double average = 0;
		for (int loop = 0; loop < numbers.size(); loop++)
			average += numbers.get(loop);
		average = average/numbers.size();
		return average;
	}
	
	public static double findDeviation (ArrayList<Integer> numbers, double average) {
		double deviation = 0;
		for (int loop = 0; loop < numbers.size(); loop++)
			deviation += (average - numbers.get(loop))*(average - numbers.get(loop));
		deviation = Math.sqrt(deviation / (numbers.size()-1));
		return deviation;
	}
	
	public static int findMode (ArrayList<Integer> numbers) {
		int mode = 0;
		int currentLen = 0;
		int maxLen = 0;
  		for (int outer = 1; outer < numbers.size(); outer++){
    		int position = outer;
    		int key = numbers.get(position);
   			while (position > 0 && numbers.get(position - 1) > key){
      			numbers.set(position, numbers.get(position - 1));
      			position--;
    		}
    		numbers.set(position, key);
  		}
		for (int loop = 0; loop < numbers.size()-1; loop++) {
			if (numbers.get(loop) == numbers.get(loop+1)) {
				currentLen++;
				if (currentLen > maxLen) {
					mode = numbers.get(loop);
					maxLen = currentLen;
				}
			}
			else {
				currentLen = 0;
			}
		}
		if (mode==0)
			return numbers.get(0);
		return mode;
	}
	
	public static void main (String[] args) {
		String fileName = "numbers.txt";
		ArrayList<Integer> numbers = readText(fileName);
		double average = findAverage(numbers);
		System.out.printf("%1s %.2f %10s", "Average: ", average, "\n");
		double deviation = findDeviation(numbers, findAverage(numbers));
		System.out.printf("%1s %.2f %10s", "Standard deviation: ", deviation, "\n");
		int mode = findMode(numbers);
		System.out.println("Mode: " + mode);
	}
}
