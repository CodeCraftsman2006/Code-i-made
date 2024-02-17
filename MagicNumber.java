import java.awt.DisplayMode;
import java.text.DecimalFormat;

import javax.lang.model.element.NestingKind;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu 
 * Date: 2022-11-26
 * description: This program will ask for a number then square root the number, display the number to the power of 5,
 * display the number rounded, then will display the number rounded to 2 decimal places, then will ask the user to enter a angle 
 * then will display the sine cosine and tangent of the angle entered.
 *
 */
public class MagicNumber {

	public static void main(String[] args) {

		//declaring variable
		double realNumber, output, angle, angleRad;



		DecimalFormat twoDigit= new DecimalFormat ("#0.00");

		//prompting and getting the number the user entered
		realNumber = IO.readDouble("Enter any real number");

		//setting the output as the square root of the number the user entered
		output = Math.sqrt(realNumber);

		//displaying the output
		IO.display("The square root of the\nnumber you entered is " + output);

		//the users input to the power of 5
		output = Math.pow(realNumber, 5);

		//display the number to the power of 5
		IO.display("The number your entered to the power of 5 is "+ output);

		//round the number
		output =  Math.round(realNumber);

		//display rounded number
		IO.display("The number you entered rounded is "+ output);

		//display the number with 2 decimal places
		IO.display("The number you entered with 2 digits is " + twoDigit.format(realNumber));


		//asking the user if they want to enter the angle in degree's or radiant.
		String choiceString = IO.readString("Do you want to enter the angle in degree's or radians?\nEnter \"a\" "
				+ "for radients, any other input will ask for degrees");
		
		if(choiceString.equalsIgnoreCase("a")) {
			//prompting and getting angle in degrees
			angle = IO.readDouble("Enter the angle you want to slove for in radians");
			angleRad= angle;//converting angle to radiant
		}
		else {
			//prompting and getting angle in degrees
			angle = IO.readDouble("Enter the angle you want to slove for in degrees");
			angleRad= Math.toRadians(angle);//converting angle to radiant
		}
		//formatting output
		IO.display("The sine of " + angle + " is " + Math.sin(angleRad) + "\n"
				+ "The cos of " + angle + " is " + Math.cos(angleRad) + "\n"
				+ "The tan of " + angle + " is " + Math.tan(angleRad));









	}

}
