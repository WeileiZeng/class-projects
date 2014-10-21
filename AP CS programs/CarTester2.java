public class CarTester2
{
	public static void main(String[] args)
	{
		//Hill
		Car Hill = new Car();
		Hill.Display();
	
		//Rice
		Car Rice = new Car();
		Rice.setMake("Lexus");
		Rice.setYear(2003);
		Rice.Display();
		
		//Jamal
		Car Jamal = new Car();
		Jamal.setMake("V.W.");
		Jamal.setColor("Orange");
		Jamal.setYear(1983);
		Jamal.setLicense("ANDO");
		Jamal.Display();
		
		//Change Rice
		Rice.setColor("Blue");
		Rice.setLicense("CHAMPS");
		Rice.Display();
		
		//Change Hill
		Hill.setMake("Acura");
		Hill.setColor("Green");
		Hill.Display();
		
	}
}
