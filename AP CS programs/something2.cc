#include <iostream.h>
#include <string.h>
using namespace std; 

int board[8][8];

void setup();
void display();
void play();

void moveKing(int initX, int initY);
void moveQueen(int initX, int initY);
void moveBishop(int initX, int initY);
void moveKnight(int initX, int initY);
void moveRook(int initX, int initY);
void movePawn(int initX, int initY);

main()
{
	setup();
	display();
	play();
}

void setup()
{
	for (int x=1; x<=8; x++) { for(int y=1; y<=8; y++) board[x][y]=13; }
	
	board[1][1]=11; board[1][8]=11;
	board[1][2]=10; board[1][7]=10;
	board[1][3]=9; board[1][6]=9;
	board[1][5]=7; board[1][4]=8;
	for(int x=1; x<=8; x++) board[2][x]=12;
	
	board[8][1]=5; board[8][8]=5;
	board[8][2]=4; board[8][7]=4;
	board[8][3]=3; board[8][6]=3;
	board[8][5]=1; board[8][4]=2;
	for(int x=1; x<=8; x++) board[7][x]=6;
}
	
void display()
{
	cout << endl;
	cout << "   ";
	for (int num1=1; num1<=8; num1++) cout << " " << num1 << "  ";
	cout << endl;
	for (int x=1;x<=8;x++)
	{
		cout << x << " ";
		for(int y=1;y<=8;y++)
		{
			if(board[x][y]==13) cout << "[  ]";
			
			if(board[x][y]==1) cout << "[wK]";
			if(board[x][y]==2) cout << "[wQ]";
			if(board[x][y]==3) cout << "[wB]";
			if(board[x][y]==4) cout << "[wN]";
			if(board[x][y]==5) cout << "[wR]";
			if(board[x][y]==6) cout << "[wP]";
			
			if(board[x][y]==7) cout << "[bK]";
			if(board[x][y]==8) cout << "[bQ]";
			if(board[x][y]==9) cout << "[bB]";
			if(board[x][y]==10) cout << "[bN]";
			if(board[x][y]==11) cout << "[bR]";
			if(board[x][y]==12) cout << "[bP]";
		}
		cout << endl;
	}
}

void play()
{
	string Player1;
	string Player2;	
	int choice[2];	
	
	cout << "Player 1's name: ";
	cin >> Player1;
	cout << "Player 2's name: ";
	cin >> Player2;
	
	for (int x=0; x<1000; x++)
	{
		if (x%2==0)
		{
			cout << Player1 << ", select the piece you want to move (grid position)" << endl;
			cin >> choice[1] >> choice[2];
			if (board[choice[1]][choice[2]]==1) moveKing(choice[1], choice[2]);
			else if (board[choice[1]][choice[2]]==2) moveQueen(choice[1], choice[2]);
			else if (board[choice[1]][choice[2]]==3) moveBishop(choice[1], choice[2]);
			else if (board[choice[1]][choice[2]]==4) moveKnight(choice[1], choice[2]);
			else if (board[choice[1]][choice[2]]==5) moveRook(choice[1], choice[2]);
			else if (board[choice[1]][choice[2]]==6) movePawn(choice[1], choice[2]);
			else cout << "Not a valid piece!" << endl;
		}
		
		else
		{
			cout << Player2 << ", select the piece you want to move (grid position)" << endl;
		}
	}
}

void moveKing(int initX, int initY)
{
	int choice[2];
	cout << "Where do you want to move? (grid position)" << endl;
	cin >> choice[1] >> choice[2];
	if (board[choice[1]][choice[2]]==7 || board[choice[1]][choice[2]]==8 || board[choice[1]][choice[2]]==9 || board[choice[1]][choice[2]]==10 || board[choice[1]][choice[2]]==11|| board[choice[1]][choice[2]]==12 || board[choice[1]][choice[2]]==13)
	{
		 if ((choice[1]-initX == 1 || choice[1]-initX == -1 && choice[2]-initY==-1 || choice[2]-initY==1))
		 {
		 	board[choice[1]][choice[2]]=board[initX][initY];
		 	board[initX][initY]=13;
		 }
		 else { cout << "You can't move there!" << endl; moveKing(initX, initY); }
	 }
	 else { cout << "You already have a piece there!" << endl; moveKing(initX, initY); }
	 
		 
}

void moveQueen(int initX, int initY)
{
}

void moveBishop(int initX, int initY)
{
}

void moveKnight(int initX, int initY)
{
}

void moveRook(int initX, int initY)
{
}

void movePawn(int initX, int initY)
{
	int choice[2];
	cout << "Where do you want to move? (grid position)" << endl;
	cin >> choice[1] >> choice[2];
	if(board[initX][initY]==6)
	{
		if (board[choice[1]][choice[2]]==7 || board[choice[1]][choice[2]]==8 || board[choice[1]][choice[2]]==9 || board[choice[1]][choice[2]]==10 || board[choice[1]][choice[2]]==11|| board[choice[1]][choice[2]]==12 || board[choice[1]][choice[2]]==13)
		{
			 if ((choice[2]-initY == 0 && choice[1]-initX==-1 || choice[1]-initX==1))
			 {
			 	board[choice[1]][choice[2]]=board[initX][initY];
			 	board[initX][initY]=13;
			 }
			 else { cout << "You can't move there!" << endl; movePawn(initX, initY); }
		 }
		 else { cout << "You already have a piece there!" << endl; movePawn(initX, initY); }
	}
	display();
	else 
	{
		if (board[choice[1]][choice[2]]==1 || board[choice[1]][choice[2]]==2 || board[choice[1]][choice[2]]==3 || board[choice[1]][choice[2]]==4 || board[choice[1]][choice[2]]==5|| board[choice[1]][choice[2]]==6 || board[choice[1]][choice[2]]==13)
		{
			 if ((choice[2]-initY == 0 && choice[1]-initX==-1 || choice[1]-initX==1))
			 {
			 	board[choice[1]][choice[2]]=board[initX][initY];
			 	board[initX][initY]=13;
			 }
			 else { cout << "You can't move there!" << endl; movePawn(initX, initY); }
		 }
		 else { cout << "You already have a piece there!" << endl; movePawn(initX, initY); }
	}
}


			
