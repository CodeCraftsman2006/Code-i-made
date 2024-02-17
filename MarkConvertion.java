import java.util.Scanner;

/**
 * 
 */

/**
 * @author 713168
 *
 */
public class MarkConvertion {

	/** Rajvansh Sandhu
	 * Date: 10/11/2022
	 * description: takes mark as the input and converts it to a level grade
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// declaring and initializing variables
		int mark = -5 ; // Variable for when the user enters the a value for mark input can be stored in mark
		String repeat; // Variable for when the user wants to repeat the program

		// setting up to read the variable
		Scanner input = new Scanner(System.in);

		///stating I created this program
		System.out.println("By: Rajvansh Sandhu\n==================");

		while(true) {
			// prompt user for 
			System.out.println("Please enter a number mark");

			//setting up try block
			try {
				// user enter the number grade
				mark = Integer.parseInt(input.nextLine()); 

				//catching the error if the user enters a string instead of a integer 
			} catch(NumberFormatException e) {
				System.out.println("Please enetr a number \nex. 1,2,3");
			}
			
			//checking if mark is between 0 and 100 if not they will be able to enter again otherwise it will check the marks
			if(mark < 0 || mark > 100) {
				System.out.println("Please enter a number between 0 - 100");
				continue;

			} else { 
				
				//checking if the user entered a number between 0 and 50 then displaying level R
				if(mark >= 0 && mark <50){
					System.out.println("Your student has got a level R");	

					//Checking if the user entered a number between 50 and 60 then displaying level 1
				} else if(mark >= 50 && mark < 60) {
					System.out.println("Your student has got a level 1");

					//Checking if the user entered a number between 60 and 70 then displaying level 2	
				} else if(mark >= 60 && mark < 70) {
					System.out.println("Your student has got a level 2");

					//Checking if the user entered a number between 70 and 80 then displaying level 3
				} else if(mark >= 70 && mark < 80) {
					System.out.println("Your student has got a level 3");

					//Otherwise the user must have gotten a mark between 80 and 100 so then the program will display level 4
				}else {
					System.out.println("Your student has got a level 4");
				}
				//asking the user if they want to repeat the program again
				System.out.println("do you want to repeat the program again");
				repeat = input.nextLine();
			}
			//check if the user entered no if they did the program will end
			if(repeat.toUpperCase().equals("NO")) {
				System.out.println("Thank you for using my program");
				break;
			}

		}

	}

}
