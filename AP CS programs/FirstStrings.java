///Blue comments =)

public class FirstStrings
{
	public static void main(String[] args)
	{
		String sentence = "The week of Home Coming is fun and full of activities.";
		String PartOfSentence;
		
		///1 & 2. Count number of words/Print substrings
		int counter = 0;
		for (int looper=1; looper<=sentence.length(); looper++)
		{
			if(sentence.charAt(looper-1)==32 || sentence.charAt(looper-1)==46)
			{
				System.out.println(sentence.substring(0, looper));
				 counter++;
			}
		}

		System.out.println("Number of words: " + counter);
			
		///3. Replace "of" with "before"
		System.out.println(sentence.replaceAll("of", "before"));
		///4. Replace "me" with "stile"
		System.out.println(sentence.replaceAll("me", "stile"));


	}
}
