import java.util.Scanner;
import java.io.*;

public class BinarySearchTreeTest {
	
	public static void main ( String [] args )
	{
		BinarySearchTree newTree = new BinarySearchTree();
		try {
			File file = new File("file50.txt");
			Scanner in = new Scanner(file);

				while (in.hasNext()) {
					Item newItem = new Item (in.nextInt(), in.nextInt());
					newTree.insert(newItem);
				}

			}
		
		catch(IOException i) {
			System.out.println("Error: " + i.getMessage());
		}
		String choice;
		Scanner console = new Scanner(System.in);
		System.out.println("Automatically loaded from text file");
		do
		{
			System.out.println("Binary search tree algorithm menu");
			System.out.println("(1) Print ordered tree");
			System.out.println("(2) Search tree");
			System.out.println("(3) Delete from tree");
			System.out.println("(4) Count nodes in tree");
			System.out.println("(Q) Quit\n");
			System.out.print("Choice ---> ");
			choice = console.nextLine() + " ";
			System.out.println();

			if ('1' <= choice.charAt(0) && choice.charAt(0) <= '4')
			{
				switch (choice.charAt(0))
				{
					case '1' :	
						newTree.printInOrder();		
						break;
					case '2' :
						Scanner console2 = new Scanner(System.in);
						System.out.print("Enter the ID of the item to be found: ");
						int choice2 = console2.nextInt();
						Item findItem = new Item (choice2, 0);
						System.out.println(newTree.find(findItem));
						break;
					case '3' :
						Scanner console3 = new Scanner(System.in);
						System.out.print("Enter the ID of the item to be deleted: ");
						int choice3 = console3.nextInt();
						Item deleteItem = new Item (choice3, 0);
						newTree.delete(deleteItem);
						System.out.println("deleted");
						break;
					case '4' :
						System.out.println("There are " + newTree.countNodes() + " nodes in the tree");
						break;
				}
			}
		}
		while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
	}
	
}
