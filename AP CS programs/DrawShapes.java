//DrawShapes

import apcslib.*;

public class DrawShapes{
public void DrawSquare (DrawingTool myPencil)
{
		myPencil.up();
		myPencil.setDirection(0);
		myPencil.turnLeft(90);
		myPencil.forward(50);
		myPencil.down();
		myPencil.turnRight(90);
		myPencil.forward(50);
		myPencil.turnRight(90);
		myPencil.forward(100);
		myPencil.turnRight(90);
		myPencil.forward(100);
		myPencil.turnRight(90);
		myPencil.forward(100);
		myPencil.turnRight(90);
		myPencil.forward(50);
}

public void DrawRectangle (DrawingTool myPencil)
{
		myPencil.up();
		myPencil.setDirection(90);
		myPencil.turnLeft(90);
		myPencil.forward(25);
		myPencil.down();
		myPencil.turnRight(90);
		myPencil.forward(25);
		myPencil.turnRight(90);
		myPencil.forward(25);
		myPencil.turnRight(90);
		myPencil.forward(50);
		myPencil.turnRight(90);
		myPencil.forward(25);
		myPencil.turnRight(90);
		myPencil.forward(25);
}

public void DrawRoof (DrawingTool myPencil)
{
	myPencil.up();
	myPencil.setDirection(90);
	myPencil.down();
	myPencil.turnRight(135);
	myPencil.forward(75);
	myPencil.turnRight(135);
	myPencil.up();
	myPencil.forward(106);
	myPencil.down();
	myPencil.turnRight(135);
	myPencil.forward(75);
}

public void DrawTriangle (DrawingTool myPencil)
{
	myPencil.up();
	myPencil.setDirection(90);
	myPencil.down();
	myPencil.turnRight(135);
	myPencil.forward(75);
	myPencil.turnRight(135);
	myPencil.forward(106);
	myPencil.turnRight(135);
	myPencil.forward(75);
}
}
