#include <iostream.h>
#include <string.h>

int grid[3][3];
void display();
void declare();
void play();
void checker(int &x);


main()
{
	declare();
	display();
	play();
}

void display()
{
	for(int x=1;x<=3;x++)
	{
		for(int y=1;y<=3;y++)
		{
			if(grid[x][y]==0) cout << " _ ";
			if(grid[x][y]==1) cout << " X ";
			if(grid[x][y]==2) cout << " O ";
		}
		cout << endl;
	}
}

void declare()
{
	for(int x=0;x<3;x++)
	{
		for(int y=0;y<3;y++)
		{
			grid[x][y]=0;
		}
	}
}

void play()
{
	int xvalue;
	int yvalue;
	int y;
	for (int x=1; x<100;x++)
	{
		if (x%2 == 0)
		{
			cout << "Player 2's turn" << endl;
			while (1)
			{
			cout << "enter the row, and then the column: ";
			cin >> xvalue >> yvalue;
			if (grid[xvalue][yvalue] == 0 && xvalue <= 3 && yvalue <= 3 && xvalue >0 && yvalue >0)	{ grid[xvalue][yvalue] = 2; break; }
			else cout << "You can't use that space!" << endl;
			}
			display();
			checker(x);
		}
		else 
		{
			cout << "Player 1's turn" << endl;
			while (1)
			{
			cout << "enter the row, and then the column: ";
			cin >> xvalue >> yvalue;
			if (grid[xvalue][yvalue] == 0 && xvalue <= 3 && yvalue <= 3 && xvalue >0 && yvalue >0)	{ grid[xvalue][yvalue] = 1; break; }
			else cout << "You can't use that space!" << endl;
			}
			display();
			checker(x);
		}
		
		y = x;
	}
	checker(y);
	if (y==100) cout << "Player 1 wins!" << endl;
	else if (y==101) cout << "Player 2 wins!" << endl;
	else cout << "Cat's game!" << endl;
}

void checker(int &x)
{
	if (x%2 == 0)
	{
		if (grid[1][1] == 2 && grid[2][2] == 2 && grid[3][3] == 2) x = 101;
		else if (grid[1][3] == 2 && grid[2][2] == 2 && grid[3][1] == 2) x = 101;
		else if (grid[1][1] == 2 && grid[2][1] == 2 && grid[3][1] == 2) x = 101;
		else if (grid[1][2] == 2 && grid[2][2] == 2 && grid[3][2] == 2) x = 101;
		else if (grid[1][3] == 2 && grid[2][3] == 2 && grid[3][3] == 2) x = 101;
		else if (grid[1][1] == 2 && grid[1][2] == 2 && grid[1][3] == 2) x = 101;
		else if (grid[2][1] == 2 && grid[2][2] == 2 && grid[2][3] == 2) x = 101;
		else if (grid[3][1] == 2 && grid[3][2] == 2 && grid[3][3] == 2) x = 101;
	}
	
	{
		if (grid[1][1] == 1 && grid[2][2] == 1 && grid[3][3] == 1) x = 100;
		else if (grid[1][3] == 1 && grid[2][2] == 1 && grid[3][1] == 1) x = 100;
		else if (grid[1][1] == 1 && grid[2][1] == 1 && grid[3][1] == 1) x = 100;
		else if (grid[1][2] == 1 && grid[2][2] == 1 && grid[3][2] == 1) x = 100;
		else if (grid[1][3] == 1 && grid[2][3] == 1 && grid[3][3] == 1) x = 100;
		else if (grid[1][1] == 1 && grid[1][2] == 1 && grid[1][3] == 1) x = 100;
		else if (grid[2][1] == 1 && grid[2][2] == 1 && grid[2][3] == 1) x = 100;
		else if (grid[3][1] == 1 && grid[3][2] == 1 && grid[3][3] == 1) x = 100;
	}
	if (grid[1][1] != 0 && grid[1][2] !=0 && grid[1][3] !=0 && grid[2][1] !=0 && grid[2][2] !=0 && grid[2][3] !=0 && grid[2][3] !=0 && grid[3][1] !=0 && grid[3][2] !=0 && grid[3][3] !=0) x = 102;
}
		
