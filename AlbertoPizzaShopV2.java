import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 *Date: 2022-20-02
 *description: calculates the cost of a pizza at Albertos Pizza Shop
 */
public class AlbertoPizzaShopV2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//declaring variable
		double totalWithoutTax = 0;
		double diameterOfPizza;  
		String repeat; // 
		ArrayList <Double> diameterArray = new ArrayList<>();// https://www.youtube.com/watch?v=NbYgm0r7u6o&t=754s

		//setting up 2 decimal point format
		DecimalFormat twoDigit = new DecimalFormat("#0.00");

		while(true) {
			//creating a while loop so it loops back if there is a error
			while(true) {

				//creating a try block to check for errors
				try {

					//prompt and get the diameter of the pizza
					diameterOfPizza = Double.parseDouble(JOptionPane.showInputDialog( "What is the diameter of the pizza?"));

					//if statement if the user enters a negative number or 0
					if (diameterOfPizza <= 0) {
						JOptionPane.showMessageDialog(null, "Please enter postive numebr");	
					}
					//adding the users input to the array list
					diameterArray.add(diameterOfPizza);

					//asking the user if they want to buy more pizza
					repeat = JOptionPane.showInputDialog(null, "Would you like to buy more pizza's?");

					//if the user enters no to the prompt the code will break out of the loop
					if (repeat.toUpperCase().equals("NO")) {
						break;
					}
				}

				//creating a catch block to tell the program what to do if the user were to enter a string instead of a int
				catch (java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a number. Example(1,2,3,4.1,3.5");
				}
			}


			//displaying the order
			for (int i = 0; i < diameterArray.size(); i++) { 
				//Calculating the total price of the pizza
				totalWithoutTax = 0.05 * Math.pow(Math.pow(diameterArray.get(i),5),0.5) + totalWithoutTax + 1.75;

				//Calculating price for each pizza to display
				double pizzaPrice = 0.05 * Math.sqrt(Math.pow(diameterArray.get(i),5)) + 1.75;

				JOptionPane.showMessageDialog(null,"You ordered a pizza with the diameter of " + diameterArray.get(i) +
						" it costs " + twoDigit.format(pizzaPrice));

			}
			double tax = totalWithoutTax * 0.13;
			//displaying the total without tax
			JOptionPane.showMessageDialog(null, "Your total to make the pizza's is $" + twoDigit.format(totalWithoutTax)+
					"\nTax is $" + twoDigit.format(tax) +"\n Total with tax is " + twoDigit.format(totalWithoutTax + tax));

			//asking the user if they want to restart the program
			repeat = JOptionPane.showInputDialog(null, "Do you want to restart the program? enter no to stop the program,"
					+ "any other input will restart the program");

			// if they say no the program will stop
			if (repeat.toUpperCase().equals("NO")) {
				JOptionPane.showMessageDialog(null, "Thank you for using my prorgram");
				break;
			}
		}
	}}
