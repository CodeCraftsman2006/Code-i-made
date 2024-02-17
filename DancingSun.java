import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author rajva
 *
 */
public class DancingSun extends JFrame {
	/**
	 * Declaring needed global variables (OUTSIDE ALL OF THE FUNCTIONS)
	 * but inside the class
	 */
	int x = 800, y = 320;   // starting x and y positions of the dot
	int xSpeed = 7, ySpeed = 7; // variables to move the dot in the x and y directions
	int delay = 50; // variable to slow down the dot
	ImageIcon backGnd;  // images for background and a pictures

	public DancingSun() {
		// TODO Auto-generated constructor stu
		//title of window
		super("Dancing Sun");
		setSize(800,480);

		backGnd = new ImageIcon("countrySide.jpg");
		setSize(800,480);

		setVisible(true);//displays window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {

		backGnd.paintIcon(this, g, 0,0);

		while(true) {
			for(int i = 0; i <50; i++) {
				backGnd.paintIcon(this, g, 0,0);
				g.setColor(Color.YELLOW);
				g.fillOval(600 + i, 50+i,  80, 80);
				try {
					Thread.sleep(delay);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
				for(int i = 0; i <50; i++) {
					backGnd.paintIcon(this, g, 0,0);
					g.setColor(Color.YELLOW);
					g.fillOval(650 , 100-i,  80, 80);
					try {
						Thread.sleep(delay);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
				
				for(int i = 0; i <50; i++) {
					backGnd.paintIcon(this, g, 0,0);
					g.setColor(Color.YELLOW);
					g.fillOval(650-i, 50,  80, 80);
					try {
						Thread.sleep(delay);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}

		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			new DancingSun();

		}

	}
