import apcslib.*;

public class DrawEric{
	private DrawingTool myPencil;
	private SketchPad myPaper;
	
	public DrawEric(){
		myPaper = new SketchPad(300, 300);
		myPencil = new DrawingTool(myPaper);
	}
	
	public void draw(){
		for (int x=0; x<18; x++){	
		myPencil.forward(20);
		myPencil.turnLeft(20);
		}
		
		myPencil.turnLeft(90);
		myPencil.up();
		myPencil.forward(30);
		myPencil.turnRight(90);
		myPencil.forward(15);
		myPencil.turnLeft(90);
		
		myPencil.down();
		myPencil.forward(6);
		myPencil.turnRight(90);
		myPencil.forward(3);
		myPencil.turnRight(90);
		myPencil.forward(6);
		myPencil.turnRight(90);
		myPencil.forward(3);
		myPencil.turnRight(90);
		myPencil.forward(6);
		myPencil.up();
		myPencil.forward(35);
		myPencil.down();
		myPencil.forward(6);
		myPencil.turnRight(90);
		myPencil.forward(3);
		myPencil.turnRight(90);
		myPencil.forward(6);
		myPencil.turnRight(90);
		myPencil.forward(3);
	}
	
	public static void main (String[] args){
		DrawEric sq = new DrawEric();
		sq.draw();
	}
}
