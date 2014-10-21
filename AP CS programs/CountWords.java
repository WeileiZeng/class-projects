//Venkata Poreddy
// Period 3
// Sorts the words in a text file, counts number of words and unique
// words, returns top 30 most common words, and allows the user to
// search for a specific word within the text file.

import java.util.*;
import java.io.*;

public class CountWords {
	
	
	
	public static ArrayList<String> readText(String fileName) {
		ArrayList<String> wordList = new ArrayList<String> ();
		try {
			File file = new File(fileName);
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				wordList.add(in.next());
			}
		}
		catch(IOException i) {
		System.out.println("Error: " + i.getMessage());
		}
		Collections.sort(wordList);
		char currentChar;
		String currentWord = new String();
		for (int loop = 0; loop < wordList.size(); loop++) {
			currentWord = wordList.get(loop);
			currentWord = currentWord.toLowerCase();
			for (int loop2 = 0; loop2 < currentWord.length(); loop2++) {
				currentChar = currentWord.charAt(loop2);
				if (currentChar < 97 || currentChar > 122) {
					if (currentChar != 39 && currentChar != 45) 
						currentWord = currentWord.substring(0, loop2) + currentWord.substring(loop2 + 1, currentWord.length());
				}
			}
			wordList.set(loop, currentWord);
		}
		for (int loop4=0; loop4<wordList.size(); loop4++) {
			if (wordList.get(loop4).charAt(0) >=48 && wordList.get(loop4).charAt(0) <=57) {
				wordList.remove(loop4);
				loop4--;
			}
		}
		return wordList;
	}
	
	public static int uniqueWords (ArrayList<String> wordList) {
		boolean unique = true;
		ArrayList <String> uniqueList = new ArrayList<String>();
		for (int loop = 0; loop < wordList.size(); loop++) {
			for (int loop2 = 0; loop2 < uniqueList.size(); loop2++) {
				if (wordList.get(loop).compareTo(uniqueList.get(loop2)) == 0) {
					unique = false;
					break;
				}
			}
			if (unique) 
				uniqueList.add(wordList.get(loop));
			unique = true;
		}
		return uniqueList.size();
	}
	public static int totalWords (ArrayList<String> wordList) {
		return wordList.size();
	}
	
	public static void top30 (ArrayList<String> wordList) {
		ArrayList<String> topWords = new ArrayList<String> ();
		String currentWord = new String();
		int currentLen = 0, maxLen = 0;
		for (int loop2 = 1; loop2 <= 30; loop2++) {
			for (int loop = 1; loop <= wordList.size()-1; loop++) {
				if (wordList.get(loop).compareTo(wordList.get(loop-1)) == 0 && !topWords.contains(wordList.get(loop))) {
					currentLen++;
					if (currentLen > maxLen) {
						currentWord = wordList.get(loop);
						maxLen = currentLen;
					}
				}
				else currentLen = 0;					
			}
			System.out.println(loop2 + ". '" + currentWord + "' has " + maxLen + " entries");
			topWords.add(currentWord);
			maxLen = 0;
		}
		System.out.println();
	}
	
	public static int search (ArrayList<String> wordList, String searchElement) {
		int low = 0;
        int high = wordList.size() - 1;
        int mid;
        while( low <= high ) {
            mid = ( low + high ) / 2;
            if( wordList.get(mid).compareTo(searchElement) < 0 )
                low = mid + 1;
            else if( wordList.get(mid).compareTo(searchElement) > 0 )
                high = mid - 1;
            else
                return mid;
        }
		return -1;
	}
	
	public static void main (String[] args) {
		String fileName = "modest.txt";
		ArrayList<String> wordList = readText(fileName);
		top30 (wordList);
		System.out.println("Number of unique words: " + uniqueWords (wordList));
		System.out.println("Total number of words: " + totalWords (wordList));
		String searchElement = " ";
		Scanner scn = new Scanner(System.in);
		while (searchElement != "q") {
			System.out.print("\nEnter a word to search for (enter 'q' to quit): ");
			searchElement = scn.next();
			if (searchElement.compareTo("q") == 0)
				break;
			else 
				System.out.println(searchElement + " was found at index " + search(wordList, searchElement));
		}
	}
}
			
	
