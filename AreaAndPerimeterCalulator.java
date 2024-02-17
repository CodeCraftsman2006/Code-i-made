import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 10/3/2022
 * description: calculates the area and peimeter of a a circle, square, rectangle and triangle
 *
 *add error for negative numbers
 */
public class AreaAndPerimeterCalulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring variables
		double answer;
		double lenght;
		double height;
		double width;
		String choice;
		
		//setting up 2 decimal point format
		DecimalFormat twoDigit = new DecimalFormat("#0.00");
		
		// prompt and get what shape the user wants to calculate for
		choice = JOptionPane.showInputDialog(null, "What shape do you want to do calulations for? enter A for square, "
				+ "enter B for rectangle, enter C for circle, enter D for triangle");
		
		while(true) {
			// if the user enter A
			if(choice.toUpperCase().equals("A")) {
				
				//Setting up while loop to come to top if anything other then a or b is entered
				while(true) {
					//adding a try block to check if the user enters letters instead of a number
					try {
						//asking the user to enter length
						lenght = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the legtht of the square"));
						
						//asking the user if they want the are or perimeter
						choice = JOptionPane.showInputDialog(null, "Do you want to slove for the area or the perimeter? enter A for"
								+ " area or enter B perimeter");
						if(choice.toUpperCase().equals("A")) {
							answer = Math.pow(lenght,2);
							JOptionPane.showMessageDialog(null, "The area of the square is " + twoDigit.format(answer));
							break;
						}
						else if(choice.toUpperCase().equals("B")) {
							answer = 2 * lenght;
							JOptionPane.showMessageDialog(null, "The lenght of the square is " + twoDigit.format(answer));
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter A or B");	
						}
						}
					//displaying "please enters a number" if the user enter a letter
					catch(java.lang.NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number");
					}
					}}
			else if(choice.toUpperCase().equals("B")) {
				while(true) {
					//adding a try block to check if the user enters letters instead of a number
					try {
						//asking the user to enter length
						lenght = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the legtht of the rectangle"));
						
						//asking the user to enter the width
						width = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the width of the rectangle"));
						
						//asking the user if they want the are or perimeter
						choice = JOptionPane.showInputDialog(null, "Do you want to slove for the area or the perimeter? enter A for"
								+ " area or enter B perimeter");
						// setting up a if statement if the user enters A and choice area to be calculated
						if(choice.toUpperCase().equals("A")) {
							answer = lenght * width;
							JOptionPane.showMessageDialog(null, "The area of the rectangle is " + twoDigit.format(answer));
							break;
						}
						//if the user enters b the perimeter should be calculated
						else if (choice.toUpperCase().equals("B")) {
							answer = 2 * lenght + 2 * width; 
							JOptionPane.showMessageDialog(null, "The perimeter of the rectangle is " + twoDigit.format(answer));
							break;
						}
						//otherwise the program shows the error message and loops back to the top
						else {
							JOptionPane.showMessageDialog(null, "Please enter A ro B");
						}
					}
					//displaying "please enters a number" if the user enter a letter
					catch(java.lang.NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number");
					}
				}}
			//if the user enters choice C and chooses a circle
			else if(choice.toUpperCase().equals("C")) {
				while (true) {
					//adding a try block to check if the user enters letters instead of a number
					try {
						//asking the user to enter the radius
						lenght = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the radius of the circle"));
						
						//asking the user if they want to calculate for area or the parameter
						choice =  JOptionPane.showInputDialog(null, "Do you want to slove for the area or the perimeter? enter"
								+ " A for area or enter B perimeter");
						
						//if he wants to calculate for the area
						if(choice.toUpperCase().equals("A")) {
							answer = 3.14*Math.pow(lenght, 2);
							JOptionPane.showMessageDialog(null, "The area of the circle is " + twoDigit.format(answer));
							break;
						}
						//if he is calculating for the perimeter
						else if (choice.toUpperCase().equals("B")) {
							answer = 2 * 3.14 * lenght;
							JOptionPane.showMessageDialog(null, "The perimeter of the circle is " + twoDigit.format(answer));
							break;
						}
						else {
							JOptionPane.showMessageDialog(null, "Please enter A or B");
						}
					}
					//displaying "please enters a number" if the user enter a letter
					catch(java.lang.NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number");
					}
				}}
			else if(choice.toUpperCase().equals("D")) {
				while(true) {
					//adding a try block to check if the user enters letters instead of a number
					try {
						//asking the user to enter the height and width
						width = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the base of the triangle"));				
						
						//asking the user if they want to calculate for area or the parameter
						choice =  JOptionPane.showInputDialog(null, "Do you want to slove for the area or the perimeter? enter A for area"
								+ " or enter B perimeter");
						
						//if the user enters A the program will find the area of the triangle
						if(choice.toUpperCase().equals("A")) {
							
							//prompting and getting the height of the triangle
							height = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the height of the triangle"));
							answer = (height * width)/2;
							JOptionPane.showMessageDialog(null,"The area of the triangle is " + twoDigit.format(answer));
							break;
							}
						//if the user enter b the program will calculate for the perimeter
						else if(choice.toUpperCase().equals("B")) {
							
							//prompting and getting the last 2 sides of the triangle
							lenght = Double.parseDouble(JOptionPane.showInputDialog(null, "What is the the lenght of the tirangle"));
							double side = Double.parseDouble(JOptionPane.showInputDialog(null, "What is "
									+ "the the last saide value of the tirangle"));
							
							//Calculating the parameter
							answer = side + lenght + width;
							JOptionPane.showMessageDialog(null, "The Perimeter is " + twoDigit.format(answer));
							break;
							}
						//error message for the user
						else {
							JOptionPane.showMessageDialog(null, "Please enter A or B");
						}
					}
					//displaying "please enters a number" if the user enter a letter
					catch(java.lang.NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Please enter a number");
					}
					
			}}
			//error message for the user 
			else {
				JOptionPane.showMessageDialog(null, "Please enetr A,B,C or D");
			}
			//asking the user if they want to run the program again
			choice = JOptionPane.showInputDialog(null, "Do you want to run this program again? Enter Y/N");
			
			//If the user enter n the program stops
			if(choice.toUpperCase().equals("N")) {
				break;
			}
		}	
}}
