import java.awt.Color;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.io.Closeable;

import javax.management.openmbean.OpenDataException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.ColorUIResource;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-30
 * Description: This program will show a person drive up to a building.
 * Then, get out of the car go into the building the get back in the car and drive away.
 *
 */
public class PullUpInDaCrib extends JFrame{
	/**
	 * Declaring needed global variables (OUTSIDE ALL OF THE FUNCTIONS)
	 * but inside the class
	 */
	int x = 800, y = 320;   // starting x and y positions of the dot
	int xSpeed = 7, ySpeed = 7; // variables to move the dot in the x and y directions
	int delay = 50; // variable to slow down the dot
	ImageIcon hoodGuy, car, backGnd, campos;  // images for background and a pictures

	/**
	 * The window constructor
	 */
	public PullUpInDaCrib() {
		//title of window
		super("Hood");
		setSize(1500,900);

		backGnd = new ImageIcon("town.jpg");
		setSize(800,600);

		hoodGuy = new ImageIcon("giphy.gif");	

		car = new ImageIcon("Car. (1).png");
		campos = new ImageIcon("horsecookies.jpg");


		setVisible(true);//displays window
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void paint(Graphics g) {


		//drawing building
		g.setColor(Color.CYAN);
		g.drawRect(50, 100, 200, 350);

		//drawing door
		g.setColor(Color.CYAN);
		g.drawRect(100, 300, 100, 150);

		//drawing another building and making circle and writing "hood" in it
		g.setColor(Color.RED);
		g.drawRect(500, 100, 200, 350);
		g.drawOval(100, 135, 100, 25);
		g.drawString("HOOD", 130, 150);

		//drawing line
		g.setColor(Color.WHITE);
		g.drawLine(0, 450, 450, 450);
		
		//drawing mr.campos
		campos.paintIcon(this, g, 500, 50);
		
		// for loop to move car left
		for (int i = 0; i < 100; i++){

			//set background to black
			g.setColor(Color.BLACK);
			g.fillRect(0, 450, 800, 1000);

			x = x - xSpeed;   // change the y position of the first rocket

			car.paintIcon(this, g, x, y);     // draws the car at position x and y

			try{
				Thread.sleep(delay);     //delay the computer for 5 milliseconds
			}
			catch (Exception error){
			}

			System.out.println(x + " " + y);


		}//move person from car
		for(int i =0; i <25; i++) {
			car.paintIcon(this, g, 100, y);// painting car
			hoodGuy.paintIcon(this, g, (x+250), y);// person come out of car
			x= x - xSpeed;//moving the person left

			//delaying the program by half the second
			try {
				Thread.sleep(50);
			} catch (Exception e) {

			}

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 1500, 450);

			//drawing another building and making circle and writing "hood" in it
			g.setColor(Color.RED);
			g.drawRect(500, 100, 200, 350);
			g.drawOval(100, 135, 100, 25);
			g.drawString("HOOD", 130, 150);

			//drawing line
			g.setColor(Color.WHITE);
			g.drawLine(0, 450, 450, 450);

			//drawing door
			g.setColor(Color.CYAN);
			g.drawRect(100, 300, 100, 150);

			//drawing building
			g.setColor(Color.CYAN);
			g.drawRect(50, 100, 200, 350);


			System.out.println(x);
		}
		//open door
		for(int i =0; i<20; i++) {
			g.setColor(Color.BLACK);
			g.fillRect(150 - 3*i, 300, 50, 150);
			hoodGuy.paintIcon(this, g, (x+250), y);


			try {
				Thread.sleep(delay);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		//close door
		for(int i =0; i <50; i++) {
			car.paintIcon(this, g, 100, y);// painting car
			hoodGuy.paintIcon(this, g, (x+250), y);// person come out of car
			x= x - 3;//moving the person left
			
			//painting background white
			g.setColor(Color.WHITE);
			g.fillRect(100, 300, 400, 150);
			
			//drawing another building and making circle and writing "hood" in it
			g.setColor(Color.RED);
			g.drawRect(500, 100, 200, 350);
			
			//set background to black
			g.setColor(Color.BLACK);
			g.fillRect(0, 450, 800, 1000);
			
	
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		

		
		while(true) {
			car.paintIcon(this, g, 100, y);// painting car
		}
		

	}
	// overriding the windowClosing() method   


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new PullUpInDaCrib();

	}

}
