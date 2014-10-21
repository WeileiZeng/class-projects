import java.util.Scanner;
import java.io.*;

public class Car
{
	private String myMake;
	private String myColor;
	private String myLicense;
	private int myYear;
	
	
	public Car()
	{
		myMake = "None";
		myColor = "None";
		myLicense = "None";
		myYear = 0;
	}
	
	public Car(String Make, int Year)
	{
		//System.out.println(Make);
		//System.out.println(Year);
	}
	
	public String getMake()
	{
/*
		TextReader console = new TextReader();
		System.out.print("Enter the make: ");
		myMake = console.readLine();
*/
		return myMake;
	}
	public String getColor()
	{
/*
		TextReader console = new TextReader( );
		System.out.print("Enter the color: ");
		myColor = console.readLine();
*/
		return myColor;
	}
	public String getLicense()
	{
/*
		TextReader console = new TextReader( );
		System.out.print("Enter the license number: ");
		myLicense = console.readLine();
*/
		return myLicense;
	}
	public int getYear()
	{
/*
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year: ");
		myYear = in.nextInt();
*/
		return myYear;
	}

	public void setMake(String Make) {myMake = Make;}
	public void setColor(String Color) {myColor = Color;}
	public void setLicense(String License) {myLicense = License;}
	public void setYear(int Year) {myYear = Year;}
	
	public void Display()
	{
		System.out.println(myMake+" "+myYear+" "+myColor+" "+myLicense);
	}
}
