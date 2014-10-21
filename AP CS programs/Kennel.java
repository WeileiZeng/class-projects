import java.util.ArrayList;

public class Kennel
{
	private ArrayList <Pet> petList;		//  all elements are references to Pet objects

	public Kennel ( )
	{
		petList = new ArrayList <Pet> ();
	}
	
	public static void main ( String [] args )
	{
		Kennel keepem = new Kennel();
		
		Dog rex = new Dog ( "Rex" );
		keepem.addPet(rex);
		System.out.println ( "\n\n\n" );
		keepem.allSpeak();

		Dog knuckles = new Dog ( "Knuckles" );
		keepem.addPet(knuckles);
		System.out.println ( "\n\n\n" );
		keepem.allSpeak();

		LoudDog max = new LoudDog ( "Max" );
		keepem.addPet(max);
		System.out.println ( "\n\n\n" );
		keepem.allSpeak();

		Cat philbert = new Cat ( "Philbert" );
		keepem.addPet(philbert);
		System.out.println ( "\n\n\n" );
		keepem.allSpeak();

		keepem.removePet(1);
		System.out.println ( "\n\n\n" );
		keepem.allSpeak();
		System.out.println ( "\n\n\n" );
	}

	public void addPet ( Pet p )
	{
		petList.add(p);
	}

	public void removePet ( int index )
	{
		petList.remove (index);
	}

	// postcondition:  for each  Pet  in the kennel, its name followed by the result of a call to its  speak  method
	//		    has been printed, one line per Pet
	public void allSpeak()
	{
//		for (int i = 0; i < petList.size(); i++)
//		{
//			Pet apet = (Pet)petList.get(i);
//			System.out.println ( apet.getName() + "  " + apet.speak() );
//		}
//		for (Pet p : petList)
//			System.out.println ( p.getName() + "  " + p.speak() );
			
		String petName = " ";
		String petSpeak = " ";
		for (int loop = 0; loop < petList.size(); loop++) {
			petName = (petList.get(loop)).getName();
			petSpeak = (petList.get(loop)).speak();
			System.out.println(petName + " " + petSpeak);
		}
	}

}

class Pet[:)][:(][:)][:(]
{
	private String myName;

	public Pet (String name)
	{  
		myName = name;  
	}

	public String getName()
	{  
		return myName;  
	}

	public String speak()
	{  
		return "AOOGA";  
	}
}

class Dog extends Pet
{
	public Dog (String name)
	{  
		super(name);  
	}

	public String speak ()
	{  
		return "WOOF!";  
	}
}

class Cat extends Pet
{
	public Cat (String name)
	{  
		super(name);  
	}

	public String speak ()
	{  
		return "meow";  
	}
}

class LoudDog extends Dog
{
	public LoudDog (String name)
	{  
		super(name);  
	}

	public String speak ()
	{  
		return super.speak() + " " + super.speak();
	}
}












































|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|O|o|
|O|o|O|o|O|o|O|o|O|




