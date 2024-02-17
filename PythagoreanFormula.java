import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-03
 * description: this program will calculate for any side of a right angle triangle once 2 are given
 *
 */
public class PythagoreanFormula {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring variables
		double a = 0;
		double b = 0;
		double c = 0;
		String end = null;
		
		//setting up 2 decimal point format
		DecimalFormat twoDigit = new DecimalFormat("#0.00");
		
		while(true) {
		// asking what side of the triangle they want to solve
		String choice = JOptionPane.showInputDialog(null, "What side of the triangle do you want to solve for? enter a,b or c");
		
		//checking if the user enter a, b or c 
		if (choice.toUpperCase().equals("A")||choice.toUpperCase().equals("B")||choice.toUpperCase().equals("C")) {
			while(true) {	
				// Checking the code in the try statement if the user inputs a string instead of a number
				try {
					// if the user wants to find side a then the program will ask the user
					// for the value of b and c and calculate accordingly
					if (choice.toUpperCase().equals("A")||choice.toUpperCase().equals("B")) {
						b = Double.parseDouble(JOptionPane.showInputDialog("What is the value of a/b?"));
						c = Double.parseDouble(JOptionPane.showInputDialog("What is the value of c?"));
						
						//error message of the user enters a negative number
						if(a <= 0 || b <= 0) {
							JOptionPane.showMessageDialog(null, "please enter a postive number");
							continue;
							}
						
						else {
							//program calculates side b
							a = Math.pow(Math.pow(c, 2) - Math.pow(b, 2),0.5);
							
							//program displays the value of side b
							JOptionPane.showMessageDialog(null, "The value of a/b is " + twoDigit.format(a));
							break;
						}
						}
					// since there are no more options left the user must want to find side c
					else {
						//asking the user for the  value of a and b
						a = Double.parseDouble(JOptionPane.showInputDialog("What is the value of a?"));
						b = Double.parseDouble(JOptionPane.showInputDialog("What is the value of b?"));
						
						//error message of the user enters a negative number
						if(a <= 0 || b <= 0){
							JOptionPane.showMessageDialog(null, "please enter a postive number");
							continue;
							}
						
						else {
						// calculating the value of c
							c = Math.pow(Math.pow(a, 2) + Math.pow(b, 2),0.5);
	
							//displaying the value of c
							JOptionPane.showMessageDialog(null, "The value of c is " + twoDigit.format(c));
							break;
							}
					
					
				}
				}//end of try bracket
				//if the user enters a string instead of a number the the program will display "please enter a positive number" 
				//and loop back
				catch(java.lang.NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please enter a positive number");
					continue;
				}
				}//end of while loop	
		}//end of if statement
		
				
		
		//if the user does not input a,c or c the program will display 
		else {
			JOptionPane.showMessageDialog(null, "Please enter \"a, b or c\"");
			continue;//making the code go back to the  while loop
			}
		
		//asking the user if they want to end the program
		end = JOptionPane.showInputDialog(null, "Do you want to end the program?");
					
		//if they say yes then program stops
		if(end.toUpperCase().equals("YES")){
		JOptionPane.showMessageDialog(null, "Thank you for using my program");
		break;
		}
		
		
		
		
		
		}
		}}
		


