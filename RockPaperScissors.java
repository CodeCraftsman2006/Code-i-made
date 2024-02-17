import java.util.Scanner;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-15
 * Description:
 * You can play rock paper scissors with the computer
 * 
 *
 */
public class RockPaperScissors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Declaring and initializing 
		String userHand = "-";
		int  compHand;
		String repeat;

		// setting up to read the variable
		Scanner input = new Scanner(System.in);

		// to loop back to the start of the program if the user want to repeat the code or start again if there is a error
		while(true) {

			// RNG to decided if the user entered rock paper or scissors
			compHand = (int) (Math.random() * 3 + 1);

			//prompting user for rock paper or scissor 
			System.out.println("Welcome to the is Rock, Papaer, Scissors Game\n========================================"
					+ "\nEnter \"R\" for Rock, \"P\" for Paper, \"S\" for Scissors:\n");

			//giving the the users input to userHand
			userHand =  input.nextLine();

			//Deciding who wins
			if(compHand == 1 && userHand.toUpperCase().equals("R") ||
					compHand == 2 && userHand.toUpperCase().equals("P") ||
					compHand == 3 && userHand.toUpperCase().equals("S")) {

				// if compHand and userHand is the same then it is a draw
				System.out.println("It is a draw");

			} else if (compHand == 1 && userHand.toUpperCase().equals("S")||
					compHand == 2 && userHand.toUpperCase().equals("R")||
					compHand == 3 && userHand.toUpperCase().equals("P")) {

				//if compHand wins program prints you lose
				System.out.println("The computer wins");

			} else if (compHand == 1 && userHand.toUpperCase().equals("P") ||
					compHand == 2 && userHand.toUpperCase().equals("S")||
					compHand == 3 && userHand.toUpperCase().equals("R")) {

				//if the the user wins program prints you won
				System.out.println("You win");

				//error if the user does not enter one of the options
			}else {
				System.out.println("Please enter a valid input");
				continue;
			}

			System.out.println("Do you want to repeat?");
			repeat = input.nextLine();

			if (repeat.toUpperCase().equals("NO")) {
				System.out.println("Thank your for using my program");
				break;
			}

		}
	}
}
