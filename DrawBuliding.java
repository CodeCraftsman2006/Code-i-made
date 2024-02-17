import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 12/6/2022
 * Description:  program will pain 2 building with 2 windows and a blue door. There will also be 3 cars
 *
 */
public class DrawBuliding<campos> extends JFrame{

	/**
	 * 
	 */
	public DrawBuliding() {
		//title of window
		super("Hood");
		setSize(900,600);

		setVisible(true);//displays window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {
		
		int gap = 10;
		String displayString ="";
		
		displayString= IO.readString("What is the phrase you want to display on the buliding?");

		Color c = Color.red;
		
		g.setColor(Color.gray);
		g.fillRect(0, 450, 900, 200);

		for(int i = 0; i<=3; i++) {
			int x = 200 * i;
			drawBuliding(g, 0+x, 0, c, displayString);

			DrawsCarsWithMethod.drawCar(g, 50+x, 450, c);

			g.setColor(Color.GRAY);
			g.fillRect(0, 550, 800, 300);
		}

			//For loop to making runaway
			for (int i = 0; i < 1000; i = i + 20) {


				//making white marks in the road
				g.setColor(Color.white);
				g.fillRect( 0 + gap, 500, 20, 10);
				g.fillRect( 0 + gap, 600, 20, 10);
				
				gap = gap + 35;
			}

		}


/*
 * method draws building
 */
	
	public static void drawBuliding(Graphics g, int x, int y, Color c) {
		//drawing building
		g.setColor(c);
		g.drawRect(50+x, 100+y, 200, 350);

		//drawing windows
		g.drawRect(60+x, 200, 50, 50);
		g.drawRect(175+x, 200, 50, 50);

		//drawing door
		g.setColor(Color.CYAN);
		g.fillRect(100+x, 300+y, 100, 150);

		//drawing another building and making circle and writing "hood" in it
		g.setColor(c);
		g.drawOval(100+x, 135+y, 100, 25);
		g.drawString("HOOD", 130+x, 150+y);
	}
	/*
	 * method to draw building and allow the user to add any phrase they want
	 */
	public static void drawBuliding(Graphics g, int x, int y, Color c, String displayString) {
		//drawing building
		g.setColor(c);
		g.drawRect(50+x, 100+y, 200, 350);

		//drawing windows
		g.drawRect(60+x, 200, 50, 50);
		g.drawRect(175+x, 200, 50, 50);

		//drawing door
		g.setColor(Color.CYAN);
		g.fillRect(100+x, 300+y, 100, 150);

		//drawing another building and making circle and writing "hood" in it
		g.setColor(c);
		g.drawOval(100+x, 135+y, 100, 25);
		g.drawString(displayString, 130+x, 150+y);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DrawBuliding();
	}

}
