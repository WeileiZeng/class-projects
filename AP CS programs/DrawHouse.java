import apcslib.*;

public class DrawHouse{
	private DrawingTool myPencil;
	private SketchPad myPaper;
	
	public DrawHouse(){
		myPaper = new SketchPad(500, 500);
		myPencil = new DrawingTool(myPaper);
	}
	
	public void draw(){
		myPencil.turnLeft(90);
		myPencil.forward(60);
		myPencil.turnLeft(90);
		myPencil.forward(100);
		myPencil.turnLeft(90);
		myPencil.forward(120);
		myPencil.turnLeft(90);
		myPencil.forward(180);
		myPencil.turnLeft(90);
		myPencil.forward(180);
		myPencil.turnLeft(90);
		myPencil.forward(180);
		myPencil.turnLeft(90);
		myPencil.forward(120);
		myPencil.turnLeft(90);
		myPencil.forward(100);
		myPencil.up();
		myPencil.forward(80);
		myPencil.turnRight(90);
		myPencil.forward(60);
		myPencil.down();
		myPencil.turnLeft(135);
		myPencil.forward(127);
		myPencil.turnLeft(90);
		myPencil.forward(127);
		myPencil.up();
		myPencil.turnLeft(45);
		myPencil.forward(40);
		myPencil.turnLeft(90);
		myPencil.forward(40);
		myPencil.down();
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.up();
		myPencil.forward(80);
		myPencil.down();
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		myPencil.turnRight(90);
		myPencil.forward(24);
		
		
	
	}
	
	public static void main (String[] args){
		DrawHouse sq = new DrawHouse();
		sq.draw();
	}
}



