import java.util.*;
public class Palindrome
{
	public static void main (String[] args)
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a phrase to check if it's a palindrome"); 
		String sentence = scn.nextLine(); //user input
		if(checker(sentence)) System.out.println("Yes, you entered a palindrome.");
		else System.out.println("No, you did not enter a palindrome.");
	}

	public static boolean checker(String sentence)
	{
		sentence = sentence.replaceAll("[^A-Za-z]", ""); // remove punctuation, etc
		sentence = sentence.toLowerCase();
    	int side1 = 0;
    	int side2 = sentence.length()-1;
    	while (side1<side2)
   		{
    		if (sentence.charAt(side1)==sentence.charAt(side2))
    		{
    			side2--;
    			side1++;
			}
			else return false; 
   		}
    	return true;
	}
}
