import apcslib.*;

public class DrawShapesTester
{
	public static void main(String[] args)
	{
		DrawingTool myPencil;
		SketchPad myPaper;
		myPaper = new SketchPad(900, 900);
		myPencil = new DrawingTool(myPaper);
		DrawShapes shape = new DrawShapes();
		
		shape.DrawSquare(myPencil);
		shape.DrawRoof(myPencil);
		shape.DrawTriangle(myPencil);
		shape.DrawRectangle(myPencil);
	}
}
