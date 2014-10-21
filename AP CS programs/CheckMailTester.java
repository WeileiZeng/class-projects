import java.util.*;
public class CheckMailTester
{
	public static void main(String[] args)
	{
		CheckMail package1 = new CheckMail();
		int dim1;
		int dim2;
		int dim3;
		int weight;
		int choice;
		Scanner scn = new Scanner(System.in);
		int x = 1;
		while(x==1)
		{		
			System.out.println("Enter the dimensions (inches) in any order");
			dim1 = scn.nextInt();
			dim2 = scn.nextInt();
			dim3 = scn.nextInt();
			System.out.println("Enter the weight(pounds)");
			weight = scn.nextInt();
			package1 = new CheckMail(dim1, dim2, dim3, weight);
			System.out.println(package1);
			package1.Checker(package1);
			System.out.println("Check another package? (1/0)");
			choice = scn.nextInt();
			if (choice == 1) {}
			else break;
		}
	}
}
