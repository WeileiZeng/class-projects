import java.util.*;
public class PigLatin2
{
	public static void main(String[] args)
	{
		System.out.print("Enter a word to Piglatinate: ");
		Scanner scn = new Scanner(System.in);
		String Sentence = scn.nextLine();
		run(Sentence);
	}
	
	public static void run(String Sentence)
	{
		char FirstLetter;
		int zero = 0;
		int position = 0;
		String start = "";
		String end = "";
		int y = 0;
		int counter = 0;
		boolean vowels = false;
		Sentence = Sentence.toLowerCase();
		for (int a=1; a<=Sentence.length();a++)
		{
			if(Sentence.charAt(a-1)==32)
			{
				 counter++;
			}
		}
		counter++;
		String[] Sentence2 = Sentence.split(" ");
		String[] Sentence3 = Sentence.split(" ");
		for(int x=0; x<counter; x++)
		{
			for(y=0; y<Sentence2[x].length();y++)
			{
				if (Sentence2[x].charAt(y)=='a' || Sentence2[x].charAt(y)=='A' || Sentence2[x].charAt(y)=='e' || Sentence2[x].charAt(y)=='E'|| Sentence2[x].charAt(y)=='i'|| Sentence2[x].charAt(y)=='I'|| Sentence2[x].charAt(y)=='o'|| Sentence2[x].charAt(y)=='O'|| Sentence2[x].charAt(y)=='u'|| Sentence2[x].charAt(y)=='U')
				{
					vowels = true;
				}	
			}
			y=0;
			if (!vowels)
			{
				Sentence3[x] += "ay";
				if (x==0)
				{
					FirstLetter = Sentence3[x].charAt(1);
					FirstLetter-=32;
					Sentence3[x].replace(Sentence3[x].charAt(1), FirstLetter);
				}
			}
			else if (Sentence2[x].charAt(y)=='a' || Sentence2[x].charAt(y)=='A' || Sentence2[x].charAt(y)=='e' || Sentence2[x].charAt(y)=='E'|| Sentence2[x].charAt(y)=='i'|| Sentence2[x].charAt(y)=='I'|| Sentence2[x].charAt(y)=='o'|| Sentence2[x].charAt(y)=='O'|| Sentence2[x].charAt(y)=='u'|| Sentence2[x].charAt(y)=='U')
			{
				Sentence3[x] += "yay";
				if (x==0)
				{
					FirstLetter = Sentence3[x].charAt(1);
					FirstLetter-=32;
					Sentence3[x].replace(Sentence3[x].charAt(1), FirstLetter);
				}
			}
			else
			{			
				for (y=0; y<Sentence2[x].length(); y++)
				{
					position = y;
					if (Sentence2[x].charAt(y)!='a' && Sentence2[x].charAt(y)!='A' && Sentence2[x].charAt(y)!='e' && Sentence2[x].charAt(y)!='E'&& Sentence2[x].charAt(y)!='i'&& Sentence2[x].charAt(y)!='I'&& Sentence2[x].charAt(y)!='o'&& Sentence2[x].charAt(y)!='O'&& Sentence2[x].charAt(y)!='u'&& Sentence2[x].charAt(y)!='U')
					{
						start += Sentence2[x].charAt(y);
					}				
					else
					{
						break; 
					}
				}
				end = Sentence3[x].substring(position);
				Sentence3[x] = end + start + "ay";
				if (x==0)
				{
					FirstLetter = Sentence3[x].charAt(1);
					FirstLetter-=32;
					Sentence3[x].replace(Sentence3[x].charAt(1), FirstLetter);
				}
				start = "";
			}
		}
		for (int imdone=0; imdone <counter; imdone++)
		{
			System.out.print(Sentence3[imdone] + " ");
		}
		System.out.println();
	}
}


