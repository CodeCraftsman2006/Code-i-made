import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-03
 * Description: takes second and converts it to hours
 *
 */
public class timeConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaring variables 
		double seconds = 0 ;
		double hours = 0;
		double mintues = 0;
		double disSeconds= 0;
		String choice;
		
		//Scanner Input = new Scanner(System.in); 
		Scanner Input = new Scanner(System.in);
		Scanner StrInput = new Scanner(System.in);
		//decimal format
		DecimalFormat zeroDigit = new DecimalFormat("#0");
		
		while(true) {
			//prompt the user for seconds
			System.out.println("Enter Seconds");
			seconds = (int) Input.nextDouble();
			
			//Calculating the hours
			if (seconds >=3600) {
				hours = seconds/3600;
				mintues = seconds%3600/60;
				disSeconds = seconds%3600%60;
			}
			else if(seconds >=60) {
				mintues = seconds/60;
				disSeconds = seconds%60;
			}
			else {
				disSeconds = seconds;
			}
			System.out.println(zeroDigit.format(hours) + " Houres, " + zeroDigit.format(mintues) + " Mintues, " +
			zeroDigit.format(disSeconds) + " Seconds");
			
			//asking the user if they want to end the program
			System.out.println("Do you want to reapeat the program? \nenter no to end the program");
			choice = StrInput.nextLine();
			
			//if they enter no the program ends
			if(choice.toUpperCase().equals("NO")) {
				System.out.println("Thank you for using my prorgam");
				break;
			}
		}
		
	}

}
