import javax.naming.AuthenticationException;
import javax.print.DocFlavor.INPUT_STREAM;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Data: 2022-11-26
 * Description: 
 *
 */
public class StringFun {

	public static void main(String[] args) {

		//declaring variables
		String inputString = "I am too cool for this stuff, Mr.Campos";
		String replaceOWithIString ="";
		int startIndex=0;
		int cIndex=0;
		int secondtIndex=0;
		int fcounter =0;
		String fIndex = "";
		int tCounter=0;

		//go through the user input and look at each letter
		for(int i =0; i < inputString.length(); i++ ) {

			//get each letter and find ascii code
			char letter = inputString.toLowerCase().charAt(i);
			int ascii = (int) letter;

			//checking is the letter is f
			if(ascii ==102) {
				fcounter++;
				fIndex = fIndex+ " "+ i;
			}

			//checking if the letter is c
			if(ascii ==99 && cIndex ==0) {
				cIndex = i+2;
			}
			//checking if the letter is t and it second one in the phrase
			if(ascii==116) {
				tCounter++;
				
				if(tCounter==2) {
					secondtIndex = i+1;
				}
			}
		}

		//for loop to replace all the letter o's with i's
		for(int i =0; i < inputString.length(); i++ ) {

			//get each letter and find ascii code
			char letter = inputString.toLowerCase().charAt(i);
			int ascii = (int) letter;

			if(ascii==111) {
				replaceOWithIString = replaceOWithIString + inputString.substring(startIndex, i) +"i";
				startIndex = i+1;
			}
		}

		//showing 1 quarter of the string
		IO.display("A quarter of the phrase is "+ inputString.substring(0, inputString.length()/4)+"\n"
				+ "The last 2 characters of the phrase are " + inputString.substring(inputString.length()-2)+"\n"
				+ "The last 7 characters of the phrase are " + inputString.substring(0,7) + "\n"
				+ "The phrase lower case is " + inputString.toLowerCase() + "\n"
				+ "The first C in the phrase is at character " + (cIndex-1) + "\n"
				+ "The second t in the phrase is at " + secondtIndex+ "\n"
				+ "The phrase after you replace o's with i is " + replaceOWithIString + "s\n"
				+ "The letter f appears " + fcounter + " times in the phrase\n"
				+ "The location of f is at " + fIndex);




	}

}
