//Venkata Poreddy per. 3 5/27/10
//list of ListNodes, can insert text files in order, remove entries, search for entries, etc.
import java.util.*;
import java.io.*;

public class SinglyLinkedList 
{
	private ListNode first;
	private ListNode last;
	
	public SinglyLinkedList() {
		first = null;
		last = null;
	}
		
	public Object getFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		else {
			return first.getValue();
		}
	}

	public void addFirst(Object value) {
		first = new ListNode(value, first);
	}
	
	public Object getLast () {
		if (last == null) {
			throw new NoSuchElementException();
		}
		else 
			return last.getValue();
	}
	
	public int size () {
		int size = 0;
		ListNode temp = first;
		while (temp != null)  {
			if (!temp.getValue().equals(new Item(0,0)))size++;
			temp = temp.getNext(); 
		}
		return size;
	}
	
	public void addLast(Object value) {
 	 	if (first == null) {
 	 		first = new ListNode(value, first);
 	 		last = first;
 	 		return;
		}
		ListNode temp = new ListNode(value, null);
  		last.setNext(temp);
		last = temp;
	}

	public void printList() {
		ListNode temp = first;
		while (temp != null)  {
			if (!temp.getValue().equals(new Item(0,0)))System.out.println(temp.getValue());
			temp = temp.getNext();
		}
	}

	public void loadData () {
		try {
			Item temp = new Item (0,0);
			Item newItem = new Item (0,0);
			int compareTemp = 99999;
			File file = new File("file50.txt");
			Scanner in = new Scanner(file);
			while (compareTemp > 0) {
				file = new File("file50.txt");
				in = new Scanner(file);
				temp = new Item (0,0);
				newItem = new Item (0,0);
				while (in.hasNext()) {
					newItem = new Item (in.nextInt(), in.nextInt());
					if (newItem.getId() > temp.getId() && newItem.getId() < compareTemp) {
						temp = newItem;
					}
				}
				addFirst(temp);
				compareTemp = temp.getId();
			}
		}
		catch(IOException i) {
			System.out.println("Error: " + i.getMessage());
		}
		first = first.getNext();		
	}
		
	public void testFind () {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the ID of the item to be found: ");
		int choice = console.nextInt();
		Item findItem = new Item (choice, 0);
		ListNode temp = first;
		while (temp != null) {
			if (temp.getValue().equals(findItem)&& choice != 0) {
				System.out.println(temp.getValue());
				return;
			}
			temp = temp.getNext();
		}
		System.out.println("ID not found");
	}
			
	public void testDelete () {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the ID of the item to be deleted: ");
		int choice = console.nextInt();
		Item findItem = new Item (choice, 0);
		ListNode temp = first;
		while (temp != null) {
			if (temp.getValue().equals(findItem) && choice != 0) {
				System.out.println(temp.getValue() + " was deleted");
				temp.setValue(new Item(0,0));
				return;
			}
			temp = temp.getNext();
		}
		System.out.println("ID not found");
	}

	
	public void clear () {
		ListNode temp = first;
		while (temp != null) {
			temp.setValue(new Item(0,0));
			temp = temp.getNext();
		}
	}
	
	public void printBackwards() {
		ListNode temp = first;
		ListNode temp2 = last;
		while (temp.getNext() != null)  {
			temp = temp.getNext();
			if (temp.getNext() == temp2) {
				if (!temp.getValue().equals(new Item(0,0))) 
					System.out.println(temp.getValue());
				temp2 = temp;
				temp = first;
			}
		}
		if(!first.getValue().equals(new Item(0,0)))
			System.out.println(first.getValue());
	}	
	
} 
