import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-03
 * Description: calculates how many hours of sleep you got
 *
 */
public class SleepCalulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring variables
		double sleep = 0;
		int yearBirth = 0;
		int monthBirth = 0;
		int dayBirth = 0;
		double totalSleep = 0;
		String choice;
		
		// setting up to read the number inputs
		Scanner Input = new Scanner(System.in);
		Scanner StrInput = new Scanner(System.in);
		
		//convert it to Calendar instance
		Calendar calendar = Calendar.getInstance();
		
		//setting up 2 decimal point format
		DecimalFormat zeroDigit = new DecimalFormat("#0");
		
		//extracting year, month and day form the import of calendar, then store it in variables year, month and day.
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		//setting up a while loop to loop back here if the user enter a invalid input
		while(true) {
			//setting up a try block to check if the user enters a a string instead of a int
			try {
				//prompting the user to enter how many hours of sleep they got
				System.out.println("How many hours of sleep did you get on avrage?");
				
				//getting how many hours of sleep the user got
				sleep = Input.nextDouble();
				// if the user enters a negative  error message and loops back
				if(sleep <= 0) {
					System.out.println("Please enter a valid input");
					continue;
				}
				//prompting the user for their date of birth
				System.out.println("What year were born in?");
				
				//getting the user for their year of birth
				yearBirth = (int) Input.nextDouble();
				
				// if the user enters a negative  error message and loops back
				if(yearBirth <= 0 || yearBirth > year) {
					System.out.println("Please enter a valid input");
					continue;
				}
				//prompting the user for what month they were born in
				System.out.println("What month were you born in?");
				
				//getting the month they were born in
				monthBirth = (int) Input.nextDouble();
				
				// if the user enters a negative  error message and loops back
				if(monthBirth <= 0 || monthBirth > 12) {
					System.out.println("Please enter a valid input");
					continue;
				}
				//prompting the user for what day they were born in
				System.out.println("What day were you born on?");
				
				//getting the user for what day they were born in
				dayBirth = (int) Input.nextDouble();
				
				// if the user enters a negative  error message and loops back
				if(dayBirth <= 0 || dayBirth > 31) {
					System.out.println("Please enter a valid input");
					continue;
				}
				
				// time the user slept
				double totalDays = 365*(year - yearBirth) + 30*(month - monthBirth) + (day-dayBirth);
				
				//Calculating total sleep
				//asking the user if they want to end the program
				System.out.println("Do you want to reapeat the program? \nenter no to end the program");
				choice = StrInput.nextLine();
				
				//if they enter no the program ends
				if(choice.toUpperCase().equals("NO")) {
					System.out.println("Thank you for using my prorgam");
					break;
				}
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Please enter a number");
			}
		}	
	}

}
