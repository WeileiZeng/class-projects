import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopViewTest extends JApplet implements KeyListener, FocusListener, MouseListener   {

	GamePiece mypiece, mypiece2;
	private DrawingArea canvas;

	public TopViewTest ( )   {
		mypiece = new GamePiece ( 350, 225, 700, 450, 20, 15, Color.blue ); 
		mypiece2 = new GamePiece ( 350, 225, 700, 450, 20, 15, Color.red ); 
	}

	public void init ( )   {
		canvas = new DrawingArea();
		setContentPane(canvas);
		canvas.setBackground(Color.white);
		canvas.addFocusListener(this);
		canvas.addKeyListener(this);
		canvas.addMouseListener(this);
	}

	class DrawingArea extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			mypiece.draw ( g );
			mypiece2.draw(g);
		}
	}

	public void focusGained(FocusEvent evt) {
		canvas.repaint();
	}
   
	public void focusLost(FocusEvent evt) {
		canvas.repaint();
	}

	public void mousePressed(MouseEvent evt) {
		canvas.requestFocus();
	}   
   
   	public void mouseEntered(MouseEvent evt) { }
	public void mouseExited(MouseEvent evt) { }
	public void mouseReleased(MouseEvent evt) { }
	public void mouseClicked(MouseEvent evt) { }

	public void keyTyped ( KeyEvent e )    {}

	public void keyPressed ( KeyEvent e)    {
		int value = e.getKeyCode();
		if ( value == KeyEvent.VK_D )    {
  			mypiece.changedegree ( 6 );
			canvas.repaint ();
		}
		else if ( value == KeyEvent.VK_A )    {
			mypiece.changedegree ( -6 );
			canvas.repaint ();
		}
		else if ( value == KeyEvent.VK_W )    {
			mypiece.move();
			canvas.repaint();
		}
		
		else if (value == KeyEvent.VK_UP && value == KeyEvent.VK_RIGHT) {
			  			mypiece.changedegree ( 6 );
			  				mypiece.move();
			canvas.repaint();}

		else if ( value == KeyEvent.VK_SPACE )    {
			mypiece.changemagnitude ( 2 );
			canvas.repaint ();
		}
		else if ( value == KeyEvent.VK_DOWN )    {
			mypiece.changemagnitude ( -2 );
			canvas.repaint();
		}
	}
	
	public void keyPressed2 (KeyEvent f) {
		int value2 = f.getKeyCode();
		if ( value2 == KeyEvent.VK_RIGHT )    {
  			mypiece2.changedegree ( 6 );
			canvas.repaint ();
		}
		else if ( value2 == KeyEvent.VK_LEFT )    {
			mypiece2.changedegree ( -6 );
			canvas.repaint ();
		}
		else if ( value2 == KeyEvent.VK_UP )    {
			mypiece2.move();
			canvas.repaint();
		}
		else if ( value2 == KeyEvent.VK_SPACE )    {
			mypiece2.changemagnitude ( 2 );
			canvas.repaint ();
		}
		else if ( value2 == KeyEvent.VK_DOWN )    {
			mypiece2.changemagnitude ( -2 );
			canvas.repaint();
		}
	}

	public void keyReleased ( KeyEvent e )   {}
		public void keyReleased2 ( KeyEvent f )   {}

}
			
class GamePiece    {
	private int xpos, ypos, width, height, degree, motionmag;
	private Color piece;

	public GamePiece ( int x, int y, int w, int h, int d, int m, Color p )   {
		xpos = x;
		ypos = y;
		width = w;
		height = h;
		degree = d;
		motionmag = m;
		piece = p;
	}

	public void draw ( Graphics g )  {
		int [] x = new int [5];
		int [] y = new int [5];
		double dx = Math.PI / 4;
		double piecesize = width / 20.0;
		x[0] = (int) ( xpos + piecesize * Math.cos ( degree * Math.PI / 180 + 3 * dx ));
		x[1] = (int) ( xpos + piecesize * Math.cos ( degree * Math.PI / 180 + dx ));
		x[2] = (int) ( xpos + 2 * piecesize * Math.cos ( degree * Math.PI / 180 ));
		x[3] = (int) ( xpos + piecesize * Math.cos ( degree * Math.PI / 180 - dx ));
		x[4] = (int) ( xpos + piecesize * Math.cos ( degree * Math.PI / 180 - 3 * dx ));
		y[0] = (int) ( ypos + piecesize * Math.sin ( degree * Math.PI / 180 + 3 * dx ));
		y[1] = (int) ( ypos + piecesize * Math.sin ( degree * Math.PI / 180 + dx ));
		y[2] = (int) ( ypos + 2 * piecesize * Math.sin ( degree * Math.PI / 180 ));
		y[3] = (int) ( ypos + piecesize * Math.sin ( degree * Math.PI / 180 - dx ));
		y[4] = (int) ( ypos + piecesize * Math.sin ( degree * Math.PI / 180 - 3 * dx ));
		g.setColor ( piece );
		g.fillPolygon ( x, y, 5 );
	}

	public void move ()   {
		xpos = (int) ( xpos + motionmag * Math.cos( degree * Math.PI / 180 ));
		ypos = (int) ( ypos + motionmag * Math.sin( degree * Math.PI / 180 ));
		if ( xpos > width - 20 )
			xpos = width - 20;
		if ( xpos < 20 )
			xpos = 20;
		if ( ypos > height - 20 )
			ypos = height - 20;
		if ( ypos < 20 )
			ypos = 20;
	}

	public void changemagnitude ( int addto )   {
		motionmag += addto;
		if ( motionmag > 40 )
			motionmag = 40;
		if ( motionmag < 6 )
			motionmag = 6;	
	}

	public void changedegree ( int addto )  {
		degree += addto;
		if  ( degree >= 360 )
			degree -= 360;
		else if ( degree <= 0 )
			degree += 360;
	}
}		
