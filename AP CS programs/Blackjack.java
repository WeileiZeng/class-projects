import java.util.*;

public class Blackjack {
	public static void main(String[] args) {
		play();
	}
	
	public static void play () {
		ArrayList <Card> deck = shuffle();
		ArrayList <Card> myHand = deal(deck);
		ArrayList <Card> aiHand = deal(deck);
		boolean gameInProgress = true;
		boolean oneStay = false;
		boolean twoStay = false;
		boolean won = false;
		boolean hit = false;
		int money = 500;
		int bet = 0;
		Scanner readInput = new Scanner(System.in);
		Scanner readBet = new Scanner(System.in);
		while (money > 0) {
			System.out.println("You have " + money + " dollars");
			System.out.println("How much do you bet on this game?");
			bet = readBet.nextInt();
			while (bet > money) {
				System.out.println("You can't bet more than " + money + "! Bet again!");
				bet = readBet.nextInt();
			}
			hit = false;
		while (gameInProgress) {
			if(!hit) { System.out.print("You have "); seeHand(myHand); }
			hit = false;
			System.out.println("Enter H to hit, anything else to stay");
			String decision = readInput.nextLine();
			if (decision.equals("h") || decision.equals("H")) {
				hitMe(myHand, deck);
				System.out.print("You have "); seeHand(myHand);
				hit = true;
			}
			else {
				oneStay = true;
			}
			botPlay(aiHand, deck, twoStay);
			if (totalValue(aiHand) >= 15)
				twoStay = true;
			if (oneStay && twoStay) {
				gameInProgress = false;
				if (totalValue(myHand) > totalValue (aiHand))
					won = true;
			}
			if (totalValue(myHand) == 21) {
				gameInProgress = false;
				won = true;
			}
			else if (totalValue(myHand) > 21) {
				gameInProgress = false;
				won = false;
			}
			else if (totalValue(aiHand) == 21) {
				gameInProgress = false;
				won = false;
			}
			else if (totalValue(aiHand) > 21) {
				gameInProgress = false;
				won = true;
			}
		}
		if (won) { System.out.print("You won $" + bet + "! Your opponent had "); seeHand(aiHand); money+=bet; bet=0;}
		else { System.out.print("You lose $" + bet + "! Your opponent had "); seeHand(aiHand); money-=bet; bet=0; }
		deck = shuffle();
		myHand = deal(deck);
		aiHand = deal(deck);
		gameInProgress = true;
		won = false;
		twoStay = false;
		oneStay = false;
	}
	System.out.println("You are out of funds! Better luck next time!");
	}
	
			
	public static void botPlay (ArrayList<Card> aiHand, ArrayList <Card> deck, boolean twoStay) {
		if (totalValue(aiHand) < 15) {
			hitMe(aiHand, deck);
			System.out.println("Your opponent was dealt a card");
		}
		else {
			System.out.println("Your opponent stays");
			twoStay = true;
		}
	}
		 
			
			
		
	
	public static ArrayList <Card> deal (ArrayList<Card> deck) {
		ArrayList<Card> hand = new ArrayList<Card>();
		int deckLoc = (int) (deck.size() * Math.random());
		hand.add(deck.get(deckLoc));
		deck.remove(deckLoc);
		deckLoc = (int) (deck.size() * Math.random());
		hand.add(deck.get(deckLoc));
		deck.remove(deckLoc);
		return hand;
	}
	
	public static ArrayList<Card> shuffle () {
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int count = 1; count <= 13; count++) {
			for (int count2 = 1; count2 <=4; count2++) {
				deck.add(new Card(count));
			}
		}
		return deck;
	}
	
	public static void seeHand(ArrayList <Card> hand) {
		//System.out.print ("You have ");
		for (int count=0; count<hand.size(); count++) {
			if (count==hand.size()-1) {
				System.out.print("and a " + hand.get(count).getName() + ", ");
				break;
			}
			System.out.print("a " + hand.get(count).getName() + ", ");
		}
		System.out.println("with a total value of " + totalValue(hand) + ".");
	}
	
	public static void hitMe (ArrayList<Card> hand, ArrayList<Card> deck) {
		int deckLoc = (int) (deck.size() * Math.random());
		//System.out.println("You drew a " + deck.get(deckLoc).getName());
		hand.add(deck.get(deckLoc));
		deck.remove(deckLoc);
	}
	
	public static int totalValue (ArrayList<Card> hand) {
		int totalValue = 0;
		for (int count=0; count<hand.size(); count++) {
			totalValue += hand.get(count).getValue();
		}
		return totalValue;
	}
}
