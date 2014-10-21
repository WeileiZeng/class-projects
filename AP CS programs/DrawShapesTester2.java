import apcslib.*;

public class DrawShapesTester2
{
	public static void main(String[] args)
	{
		DrawingTool myPencil;
		SketchPad myPaper;
		myPaper = new SketchPad(600, 600);
		myPencil = new DrawingTool(myPaper);
		DrawShapes2 shape2 = new DrawShapes2();
		shape2.DrawSquare(myPencil, 0, 0, 100);
		shape2.DrawRectangle(myPencil, 12, -25, 25, 50);
		shape2.DrawRoof(myPencil, 0, 103);
		
	}
}
