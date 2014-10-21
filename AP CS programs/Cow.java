// Venkata Poreddy
// 2/5/10
// Period 3
// Cow animal implementing the animal interface
public class Cow implements Animal{
  private String myType;
  private String mySound;

  Cow(){
    myType = "cow";
    mySound = "moo";
  }

  public String getSound(){
    return mySound;
  }

  public String getType(){
    return myType;
  }
}
