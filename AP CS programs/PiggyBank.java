public class PiggyBank
{
	private int myPennies;
	private int myNickels;
	private int myDimes;
	private int myQuarters;
	
	public PiggyBank()
	{
		int Pennies;
		int Nickels;
		int Dimes;
		int Quarters;
	}
	
	public PiggyBank(int Pennies, int Nickels, int Dimes, int Quarters)
	{
		myPennies = Pennies;
		myNickels = Nickels;
		myDimes = Dimes;
		myQuarters = Quarters;
	}
	
	public int getPennies(PiggyBank temp)
	{
		return temp.myPennies;
	}
	
	public int getNickels(PiggyBank temp)
	{
		return temp.myNickels;
	}
	
	public int getDimes(PiggyBank temp)
	{
		return temp.myDimes;
	}
	
	public int getQuarters(PiggyBank temp)
	{
		return temp.myQuarters;
	}
	
	public void addCoins (int Pennies, int Nickels, int Dimes, int Quarters)
	{
		myPennies += Pennies;
		myNickels += Nickels;
		myDimes += Dimes;
		myQuarters += Quarters;
	}
	
	public double total ()
	{
		double total = 0;
		total += myPennies*.01;
		total += myNickels*.05;
		total += myDimes*.1;
		total += myQuarters*.25;
		return total;
	}
	
	public String toString()
	{
		return (myPennies + " pennies, " + myNickels + " nickels, " + myDimes + " dimes, and " + myQuarters + " quarters.\n");
	}
}
