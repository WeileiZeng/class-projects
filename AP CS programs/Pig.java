// Venkata Poreddy
// 2/5/10
// Period 3
// Pig animal implementing the animal interface
public class Pig implements Animal{
  private String myType;
  private String mySound;

  Pig(){
    myType = "pig";
    mySound = "oink";
  }

  public String getSound(){
    return mySound;
  }

  public String getType(){
    return myType;
  }
}


