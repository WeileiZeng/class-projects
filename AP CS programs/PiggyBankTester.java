public class PiggyBankTester
{
	public static void main (String[] args)
	{
		PiggyBank Lyric = new PiggyBank(13, 7, 5, 17);
		PiggyBank Priya = new PiggyBank();
		System.out.println(Lyric.total());
		System.out.println(Priya.total());
		
		Priya.addCoins(17, 13, 9, 5);
		Lyric.addCoins(2, 3, 5, 3);
		
		System.out.println(Priya.total());
		System.out.println(Lyric.total());
		
		if (Lyric.getDimes(Lyric) > Priya.getDimes(Priya)) System.out.println("Lyric has more dimes");
		else System.out.println("Priya has more dimes");
		
		System.out.print("Lyric has: " + Lyric);
	}
}
