import apcslib.*;

public class DrawBenzene{
	private DrawingTool myPencil;
	private SketchPad myPaper;
	
	public DrawBenzene(){
		myPaper = new SketchPad(500, 500);
		myPencil = new DrawingTool(myPaper);
	}
	public void draw(){
		
		
		myPencil.drawCircle(120);
		myPencil.drawString("Benzene");
		myPencil.up();
		myPencil.move(-170, -30);
		myPencil.down();
		myPencil.turnRight(110);
		myPencil.forward(190);
		myPencil.turnRight(60);
		myPencil.forward(190);
		myPencil.turnRight(60);
		myPencil.forward(190);
		myPencil.turnRight(60);
		myPencil.forward(190);
		myPencil.turnRight(60);
		myPencil.forward(190);
		myPencil.turnRight(60);
		myPencil.forward(190);

	}
	
	public static void main (String[] args){
		DrawBenzene sq = new DrawBenzene();
		sq.draw();
	}
}
