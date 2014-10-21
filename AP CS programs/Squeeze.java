// Venkata Poreddy
// 1/14/10
// Period 3
// "Squeezes" a text file; i.e. removes spaces at beginning of each
// line and replaces with number of spaces that were removed.

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Squeeze {
	public static String getInputFileName() {
		Scanner readInput = new Scanner(System.in);
		System.out.println("Enter input file name");
		String fileName = readInput.nextLine();
		return fileName;
	}
	
	public static String getOutputFileName() {
		Scanner readInput = new Scanner(System.in);
		System.out.println("Enter output file name");
		String fileName = readInput.nextLine();
		return fileName;
	}
	
	public static int[] readText(String fileName) {
		int[] numberOfSpaces = new int[100];
		String line;
		int spacesInLine = 0; int indexOfSpaces = 0;
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				line = in.nextLine();
				for (int loop = 0; loop < line.length(); loop++) {
					if (line.charAt(loop) == 32) {
						spacesInLine++;
					}
					else break;
				}
				numberOfSpaces[indexOfSpaces] = spacesInLine;
				indexOfSpaces++;
				spacesInLine = 0;
			}
		}
		catch(IOException i) {
			System.out.println("Error: " + i.getMessage());
		}
		return numberOfSpaces;
	}
	
	public static void writeText (String fileName, String fileName2, int[] numberOfSpaces) {
		int indexOfSpaces = 0;
		String line;
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			FileWriter out = new FileWriter(fileName2);
			while (in.hasNext()) {
				line = in.nextLine();
				line = line.trim();
				line = numberOfSpaces[indexOfSpaces] + " " + line + "\n";
				out.write (line, 0, line.length());
				indexOfSpaces++;
			}
			out.close();
		}
		catch (IOException i) {
			System.out.println("Error: " + i.getMessage());
		}
	}
	
	public static void main(String[] args) {
		String fileName = "a.txt";
		int[] numberOfSpaces = readText(fileName);
		String fileName2 = "b.txt";
		writeText(fileName, fileName2, numberOfSpaces);
	}
}
