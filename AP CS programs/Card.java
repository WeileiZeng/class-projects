import java.util.*;
public class Card {
	private int myValue = 0;
	private String myName = "";
	
	public Card (int value) {
		myValue = value;
		setValue(value);
	}
	
		
	public void setValue (int value){
		if (value >= 2 && value <= 10) {
			myName += value;
		}
		
		else if (value == 1) 
			myName = "ace";
		else if (value == 11) {
			myName = "jack";
			myValue = 10;
		}
		else if (value == 12) {
			myName = "queen";
			myValue = 10;
		}
		else if (value == 13) {
			myName = "king";
			myValue = 10;
		}
	}
	
	public int getValue () {
		return myValue;
	}
	public String getName () {
		return myName;
	}
	

}
		
