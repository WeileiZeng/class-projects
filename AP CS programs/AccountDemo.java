public class AccountDemo 
{
        public static void main(String args[])
	{
                // Create an empty account
		InterestBearingAccount my_account = new InterestBearingAccount();

                // Deposit money
		my_account.deposit(250.00);

                // Print current balance
		System.out.println ("Current balance " +
			my_account.getbalance());

                // Withdraw money
		my_account.withdraw(251.00);

                // Print remaining balance
		System.out.println ("Remaining balance " +
			my_account.getbalance());

                // Allow a month to pass
		my_account.add_monthly_interest();
		System.out.println ("Adding interest to account");

                // Print remaining balance
		System.out.println ("Remaining balance " +
			my_account.getbalance());

	}
}

class Account 
{
        protected double balance;

        // Constructor to initialize balance
        public Account( double amount )
	{
		balance = amount;
	}

        // Overloaded constructor for empty balance
        public Account()
	{
		balance = 0.0;
	}

        public void deposit( double amount )
	{
		balance += amount;
	}

        public double withdraw( double amount )
	{
                // See if amount can be withdrawn
		if (balance >= amount)
		{
			balance -= amount;
                        return amount;
		}
		else
                // Withdrawal not allowed
                        return 0.0;
	}

        public double getbalance()
	{
                return balance;
	}
}  

class InterestBearingAccount extends Account
{
        // Default interest rate of 7.95 percent (const)
        private static double default_interest = 7.95;

        // Current interest rate
        private double interest_rate;

        // Overloaded constructor accepting balance and an interest rate
        public InterestBearingAccount( double amount, double interest)
	{
		balance = amount;
		interest_rate = interest;
	}

        // Overloaded constructor accepting balance with a default interest rate
        public InterestBearingAccount( double amount )
	{
		balance = amount;
		interest_rate = default_interest;
	}

        // Overloaded constructor with empty balance and a default interest rate
        public InterestBearingAccount()
	{
		balance = 0.0;
		interest_rate = default_interest;
	}
	
        public void add_monthly_interest()
	{
                // Add interest to our account
		balance = balance + 		
                        (balance * interest_rate / 100) / 12;
	}

}
