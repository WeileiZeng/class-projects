import java.awt.*;
         import java.applet.*;

         public class HelloWorldApplet2 extends Applet {

            public void init() {
               setBackground(Color.blue);
               setForeground(Color.yellow);
            }
	
            public void paint(Graphics g) {
               g.drawString("Hello World!", 10, 30);
            }

         }
