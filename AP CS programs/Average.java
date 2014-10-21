import java.io.*;
import java.util.*;
public class Average
{
	public static void main (String[] args)
	{
		Scanner in;
		FileWriter out;
		Random rand = new Random();
		int num = rand.nextInt(100);
		int num2 = 0;
		String output = " ";
		double total = 0;
		int num3 = 0;
		try
		{	
			in = new Scanner(new File("numbers.txt"));
			out = new FileWriter("numbers.txt");
			for (int x=0;x<num;x++)
			{
				num2 = rand.nextInt(100);
				output = " " + num2 + "\n";
				out.write(output, 0, output.length());
			}
			out.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}

		try
		{
			in = new Scanner(new File("numbers.txt"));
			for(int x=0;x<num;x++)
			{
				num3 = in.nextInt();
				System.out.println(num3);
				total += num3;
			}
		}
		catch(Exception i)
		{
			System.out.println("Error " + i.getMessage());
		}
		System.out.println("Average: " + total/num);
	}
}


