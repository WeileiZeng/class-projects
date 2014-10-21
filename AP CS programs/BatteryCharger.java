public class BatteryCharger
{
	/* rateTable has 24 entries representing the charging costs for hours 0 through 23. */
	private int [] rateTable;

	public BatteryCharger ( int [] a )
	{
		rateTable = new int[24];
		for (int i = 0; i < a.length; i++)
			rateTable[i] = a[i];
	}

	public static void main (String [] args)
	{
		int [] table = {50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60};
		BatteryCharger bc = new BatteryCharger( table );
		bc.printChargeInfo(5,10);
		bc.printChargeInfo(9,19);
		bc.printBestStart(3);
		bc.printBestStart(12);
		bc.printBestStart(20);
	}
	
	public void printChargeInfo ( int s, int c )
	{
		System.out.println ( "\n\n\nThe cost of charging the battery beginning at " + s +
			"\nfor " + c + " hours is " + getChargingCost(s,c) + "\n\n");
	}

	public void printBestStart ( int c )
	{
		System.out.println ( "\n\n\nIf you want to charge the battery for " + c +
			"\nhours, the best time to start is at " + getChargeStartTime(c) + "\n\n");
	}

	/** Determines the total cost to charge the battery starting
	* at the beginning of startHour.
	* @param startHour the hour at which the charge period begins
	* Precondition: 0 . startHour . 23
	* @param chargeTime the number of hours the battery needs to be charged
	* Precondition: chargeTime > 0
	* @return the total cost to charge the battery
	*/
	private int getChargingCost(int startHour, int chargeTime)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	{
		int cost = 0;
		for (int x = 0; x < chargeTime; x++)
		{
			cost += this.rateTable[(startHour + x) % 24];
		}
		return cost;
	}

	/** Determines start time to charge the battery at the lowest
	* cost for the given charge time.
	* @param chargeTime the number of hours the battery needs to be charged
	* Precondition: chargeTime > 0
	* @return an optimal start time, with 0 . returned value . 23
	*/
	public int getChargeStartTime(int chargeTime)
	{
		int startTime = 0;
		for (int i = 1; i < 24; i++)
		{
			if (this.getChargingCost(i, chargeTime) < this.getChargingCost(startTime, chargeTime))
			{
				startTime = i;
			}
		}
		return startTime;
	}
}
