// Venkata Poreddy
// 2/5/10
// Period 3
// extends the Cow class and adds a name value
public class NamedCow extends Cow {
	private String myName;
	
 	NamedCow(String name) {
 		super();
 		myName = name;
	}
  	
  	public String getName() {
  		return myName;
	}
}
