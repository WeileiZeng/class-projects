import apcslib.*;

public class DrawCircle{
	private DrawingTool myPencil;
	private SketchPad myPaper;
	
	public DrawCircle(){
		myPaper = new SketchPad(600, 600);
		myPencil = new DrawingTool(myPaper);
	}
	public void draw(){
	
		myPencil.drawCircle(50);
        myPencil.drawString("Small");
        myPencil.up();
        myPencil.move(0,120);
        myPencil.down();
        myPencil.drawCircle(70);
        myPencil.drawString("Big");
        myPencil.up();
        myPencil.move(0,60);
        myPencil.down();
        myPencil.drawCircle(60);
        myPencil.drawString("Middle");
        myPencil.up();
        myPencil.move(-100,120);
        myPencil.down();
        myPencil.drawCircle(30);
        myPencil.drawString("Left");
        myPencil.up();
        myPencil.move(0,230);
        myPencil.down();
        myPencil.drawCircle(40);
        myPencil.drawString("Above");
        myPencil.up();
        myPencil.move(120, 120);
        myPencil.down();
        myPencil.drawCircle(50);
        myPencil.drawString("Right");
	}
	
	public static void main (String[] args){
		DrawCircle sq = new DrawCircle();
		sq.draw();
	}
}

