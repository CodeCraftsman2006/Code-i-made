import java.util.Scanner;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-03
 * description: the user can enter 2 numbers and the program will display the addition, subtraction, multiplication and division
 * 
 */
public class TwoNumberCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring variables
		double numberOne;
		double numberTwo;
		double add;
		double multi; 
		double sub;
		double division;
		String choice; 
		
		while(true) {
			// setting up to read the number inputs
			Scanner Input = new Scanner(System.in); 
			
			Scanner StrInput = new Scanner(System.in);
			
			//try to check if the user enters a number
			try {
				//prompting user for first number
				System.out.println("What is the first number?");
				//getting the first number
				numberOne = Input.nextDouble();
				
				//prompting user for the second number
				System.out.println("What is the second number");
				//getting the second number
				numberTwo = Input.nextDouble();
			}
			//if the user enters the number the program will display please enter a number
			catch(java.util.InputMismatchException e) {
				System.out.println("Please enter a number");
				continue;
			}
			
			//Calculating
			//adding the numbers
			add = numberOne + numberTwo;
			//subtracting 2 numbers
			sub = numberOne - numberTwo;
			//Multiplying 2 numbers
			multi = numberOne * numberTwo;
			//Dividing 2 numbers
			division = numberOne/numberTwo;
			//printing all the numbers
			System.out.println("The addiction of the two numbers is " + add + "\n" +
			"The subtraction of the two number is " + sub + "\nThe multiplication of the two numbers is " + multi +
			"\nThe division of the two numbers is " + division +"\n");
			
			//asking the user if they want to end the program
			System.out.println("Do you want to reapeat the program? \nenter no to end the program");
			choice = StrInput.nextLine();
			
			//if they enter no the program ends
			if(choice.toUpperCase().equals("NO")) {
				System.out.println("Thank you for using my prorgam");
				break;
			}
			
		}
	}}
