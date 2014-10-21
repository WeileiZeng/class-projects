public class CarTester
{
	public static void main(String[] args)
	{
		Car Car1 = new Car();
		Car Car2 = new Car();
		
		Car1.Display();
		Car1.getMake();
		Car1.getColor();
		Car1.getLicense();
		Car1.getYear();
		Car2.getMake();
		Car2.getColor();
		Car2.getLicense();
		Car2.getYear();
		
		Car1.setMake("Honda");
		Car1.setColor("White");
		Car1.setLicense("3XUK973");
		Car1.setYear(1999);
		Car2.setMake("Toyota");
		Car2.setColor("Blue");
		Car2.setLicense("4NRH468");
		Car2.setYear(1998);
		Car1.Display();
		Car2.Display();
		
	}
}
