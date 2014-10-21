// Venkata Poreddy
// 2/5/10
// Period 3
// Confused chick animal that says both cheep and cluck
public class Chick implements Animal{
  private String myType;
  private String mySound;
  private String mySound2;

  Chick(){
    myType = "chick";
    mySound = "cheep";
    mySound2 = "cluck";
  }

  public String getSound(){
  	if (Math.random() >= .5)
    	return mySound;
    else return mySound2;
  }

  public String getType(){
    return myType;
  }
}

