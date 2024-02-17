import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;

import javax.security.auth.x500.X500Principal;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * DAteL 2022-12-16
 * Description: This program draws cars with methods
 *
 */
public class DrawsCarsWithMethod extends JFrame {

	/**
	 * 
	 */
	public DrawsCarsWithMethod() {
		super("knave my fav race car");

		// crating window
		setSize(400,400);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 400);
		int x= 50;
		int y= 50;

		// Draw a red car
		Color c = Color.RED;
		drawCar(g, x, y, c, "cool kid");

		// Draw a yellow car
		x = x +200; // Change x value
		c = Color.YELLOW;
		drawCar(g, x, y, c, "number one student");

		// Draw a blue car
		y =y+ 200; // Changes y value by 200
		c = Color.CYAN;
		drawCar(g, x, y, c, "MR. CAMPOS! favorite student");


		// Draw a green car
		x = x- 200; // Changes x value by 200
		c = Color.GREEN;
		drawCar(g, x, y, c, "Raju byy");



	}
	public static void drawCar(Graphics g, int x, int y, Color c) {
		// Draw a blue car
		g.setColor(c);
		g.fillRect(x, y, 100, 30); // Body
		g.setColor(Color.BLUE);
		g.fillRect(x + 25, y - 20, 50, 20); // Window
		g.setColor(Color.BLACK); // Wheels
		g.fillOval(x + 10, y + 25, 25, 25); // Rear wheel
		g.fillOval(x + 65, y + 25, 25, 25); // Rear wheel
	}
	public static void drawCar(Graphics g, int x, int y, Color c, String name) {
		drawCar(g, x, y, c);
		g.drawString(name, x + 30, y + 20);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DrawsCarsWithMethod();

	}

}
