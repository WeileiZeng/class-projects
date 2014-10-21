//Venkata Poreddy
//Period 3  5/16/10
//Tests SinglyLinkedList/ListNode

public class ListDemo {
	public static void main (String [] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		for (int x=1; x<=20; x++)
			myList.addLast(new Integer(x));
			
		myList.printList();
		System.out.println("\nSize = " + myList.size());
		System.out.println("Get first = " + myList.getFirst());
		System.out.println("Get last = " + myList.getLast());
	}
}

