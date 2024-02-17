import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rajvansh Sanndhu
 * Date: 10/6/20222
 * Description: user can buy pizza slice for $2.00 each and 50 cents for a pop. If the
 * customer orders three pizza slices or more the price for each slice will be $1.00.
 *
 */
public class CamposDeal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// declaring variables
		int slices = 0; 
		double pop = 0; 

		//setting up 2 decimal point format
		DecimalFormat twoDigit = new DecimalFormat("#0.00");

		//display rules
		JOptionPane.showMessageDialog(null, "User can buy pizza slice for $2.00 each and 50 cents for a pop.\n If the"
				+ " customer orders three pizza slices or more the price for each slice will be $1.00.");

		//get RNG
		int compRNG = (int) (Math.random() * 10 + 1);

		//adding a discount code
		if(compRNG == 3) {
			JOptionPane.showMessageDialog(null, "It is your lucky day you get the discount code: CAMPOS\n" + 
					"With this you can get anything from the store for free!!");
		} else {
			//setting up the while loop
			while(true) {
				try {
					//Prompt and get how many slices did 
					slices = Integer.parseInt(JOptionPane.showInputDialog(null, "How many slices did you buy?"));

					//prompt and get how many pops the user ordered
					pop = Integer.parseInt(JOptionPane.showInputDialog(null, "How many pop cans did you buy?"));

					if (pop < 0 || slices < 0) {
						JOptionPane.showMessageDialog(null, "Pleae enter a valid input");
					}
					else {
						break;
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a valid input");
				}
			}

			//Calculating price
			if(slices >= 3) {
				slices = slices * 2;
				pop = pop * 0.5;
				
			} else { 
				pop = pop * 0.5;
			}
			JOptionPane.showMessageDialog(null, "The cost of pizza slices is $" + slices  + "\nThe cost of pop is $" + pop 
					+ "\nThe total is $" + twoDigit.format(pop + slices) 
					+ "\nYour total with tax is $" 
					+ twoDigit.format(1.13*(pop + slices)));
		}
		JOptionPane.showMessageDialog(null, "Everything form the store is free for you");

	}

}
