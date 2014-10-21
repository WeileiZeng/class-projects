public class DogDemo   {
	public static void main ( String [] args )   {
		Dog fido = new Dog();
		fido.act();
	}
}

class Dog   {
	public void act()   {
		System.out.print("run ");
		eat();
	}

	public void eat()   {
		System.out.print("eat ");
	}
}

class UnderDog extends Dog   {
	public void act()   {
		super.act();
		System.out.print("sleep ");
	}

	public void eat()   {
		super.eat();
		System.out.print("bark ");
	}
}
