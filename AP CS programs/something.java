import java.util.Scanner;


public class something
{

int[] grid = new int[3][3];


public static void main(String[] args)
{
	declare();
	display();
	play();
}

public void display()
{
	for(int x=0;x<3;x++)
	{
		for(int y=0;y<3;y++)
		{
			if(grid[x][y]==0) System.out.print(" _ ");
			if(grid[x][y]==1) System.out.print(" X ");
			if(grid[x][y]==2) System.out.print(" O ");
		}
		System.out.print("\n");
	}
}

public void declare()
{
	for(int x=0;x<3;x++)
	{
		for(int y=0;y<3;y++)
		{
			grid[x][y]=0;
		}
	}
}

public void play()
{
	int choice;
	for (int x=1; x<100;x++)
	{
		if (x%2 == 0) System.out.println("Player 2's turn");
		else System.out.println("Player 1's turn");
		System.out.println("Choose your space (enter a number 1 - 9)");
		
		
	}
}
}
