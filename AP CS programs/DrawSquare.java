import apcslib.*;

public class DrawSquare{
	private DrawingTool myPencil;
	private SketchPad myPaper;
	
	public DrawSquare(){
		myPaper = new SketchPad(500, 500);
		myPencil = new DrawingTool(myPaper);
	}
	
	public void draw(){
		myPencil.up();
		myPencil.turnLeft(90);
		myPencil.forward(160);
		myPencil.down();
		myPencil.turnRight(90);
		myPencil.forward(160);
		myPencil.turnRight(90);
		myPencil.forward(320);
		myPencil.turnRight(90);
		myPencil.forward(320);
		myPencil.turnRight(90);
		myPencil.forward(320);
		myPencil.turnRight(90);
		myPencil.forward(160);
	
	}
	
	public static void main (String[] args){
		DrawSquare sq = new DrawSquare();
		sq.draw();
	}
}



