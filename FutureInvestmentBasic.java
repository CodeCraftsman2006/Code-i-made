import java.security.KeyStore.TrustedCertificateEntry;

import javax.naming.AuthenticationException;

/**
 * 
 */

/**
  *@author Rajvansh Sandhu
 * Date: 12/14/2022
 * Description: This program will calculate your investment after taking starting amount. investment rate and years.
 *
 */
public class FutureInvestmentBasic {

	/**
	 * 
	 */
	public FutureInvestmentBasic() {
		// TODO Auto-generated constructor stub
	}
	public static double calculateInvestment(double startingAmount, double interestRate, double years) {

		//declaring and initializing future value to 0
		double futureValue=0;

		//Calculating future value
		futureValue = startingAmount * Math.pow((1 + interestRate/100), years);

		//returning the future value after calculating the future value
		return futureValue;

	}
	public static boolean checkInput(double input) {
		//checking if input is non-negative
		if(input >= 0) {
			return true;//if true then returning true

			// otherwise returning false
		} else {
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring and initializing the number of years since the investment, the startingAmount, the future value
		// and the interest rate to 0
		double years = 0, startingAmount =0, interestRate = 0, futureValue=0;

		//prompting and getting years for the investment from the user
		years = IO.readDouble("How many years have passed after the inverstment?");

		// while loop to check if the input is positive and loops if negative
		while(checkInput(years)==false) {
			//prompting and getting years for the investment from the user
			years = IO.readDouble("Pleasae enter a postive numebr\n"
					+ "How many years have passed after the inverstment?");
		}
		//prompting and getting starting amount
		startingAmount = IO.readDouble("What is the starting amount of the investment?");

		//while loop to check if the input is positive and loops if negative
		while(checkInput(startingAmount)==false) {
			//user friendly error message
			startingAmount = IO.readDouble("Pleasae enter a postive numebr\\n"
					+ "What is the starting amount of the investment?");
		}

		//prompting and getting interestRate
		interestRate = IO.readDouble("What is the interest rate of the investment");
		
		//while loop to check if the input is positive and loops if negative
		while(checkInput(interestRate)==false) {
			//user friendly error message
			interestRate = IO.readDouble("Pleasae enter a postive numebr\\n"
					+ "What is the interest rate of the ivestment?");
		}
		//Calculating suture investment
		futureValue = calculateInvestment(startingAmount,interestRate,years);
		
		//displaying future investment
		IO.display("The future value of the investment is " + Math.round(futureValue));
		
		}

	}
