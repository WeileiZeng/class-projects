//DrawShapes

import apcslib.*;

public class DrawShapes2{
public void DrawSquare (DrawingTool myPencil, int x, int y, int s)
{
		myPencil.up();
		myPencil.move(x,y);
		myPencil.setDirection(0);
		myPencil.turnLeft(90);
		myPencil.forward(s/2);
		myPencil.down();
		myPencil.turnRight(90);
		myPencil.forward(s/2);
		myPencil.turnRight(90);
		myPencil.forward(s);
		myPencil.turnRight(90);
		myPencil.forward(s);
		myPencil.turnRight(90);
		myPencil.forward(s);
		myPencil.turnRight(90);
		myPencil.forward(s/2);
}

public void DrawRectangle (DrawingTool myPencil, int x, int y, int w, int h)
{
		myPencil.up();
		myPencil.move(x,y);
		myPencil.setDirection(90);
		myPencil.turnLeft(90);
		myPencil.forward(h/2);
		myPencil.down();
		myPencil.turnRight(90);
		myPencil.forward(w);
		myPencil.turnRight(90);
		myPencil.forward(h/2);
		myPencil.turnRight(90);
		myPencil.forward(h);
		myPencil.turnRight(90);
		myPencil.forward(w);
		myPencil.turnRight(90);
		myPencil.forward(h/2);
}

public void DrawRoof (DrawingTool myPencil, int x, int y)
{
	myPencil.up();
	myPencil.move(x,y);
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

public void DrawTriangle (DrawingTool myPencil, int x, int y)
{
	myPencil.up();
	myPencil.move(x,y);
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
