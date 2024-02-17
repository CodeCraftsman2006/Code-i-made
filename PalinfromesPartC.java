/**
 * 
 */

/**
 * @author rajvansh Sandhu
 * Date: 2022-10-28
 * Description: This program will take the users input and display an out of the word or phrase backwards and displays if its a palindrome or not
 *
 */
public class PalinfromesPartC {

	public static void main(String[] args) {
		//declaring variables
		String inputString = "";
		String noSpaceInputString ="";
		String backwordsString ="";
		int startIndex=0;
		int characterRemoved =0;

		//prompting and getting the phrases
		inputString = IO.readString("Enter a word or phrase");

		//go through the user input and look at each letter
		for(int i =0; i < inputString.length(); i++ ) {

			//get each letter and find ascii code
			char letter = inputString.toLowerCase().charAt(i);
			int ascii = (int) letter;//converting letter to ASCII number

			//checking if the ASCII is a special charter
			//if(ascii>=32 && ascii <=47 || ascii>=58 && ascii <= 64 || ascii>= 91 && ascii <= 96 || ascii>= 123 && ascii <=126) 
			if(!(ascii >=97 && ascii <= 122 || ascii >=65 && ascii <= 90)){
				//if the program finds a special charter it will remove it
				noSpaceInputString = noSpaceInputString + inputString.substring(startIndex, i);
				startIndex = i+1;//the program will know where to start again
				characterRemoved++;//adding 1 to character removed every time the program removes a character
			}  
		}
		//checking of the the length of the of the input is greater then the length of the no space input
		if(inputString.length()> noSpaceInputString.length()) {
			//if true then adding the remaining charters to the noSpaceString
			noSpaceInputString = noSpaceInputString +inputString.substring(noSpaceInputString.length()+characterRemoved);
		}

		//for loop to write the phrase backwards 
		for(int i= noSpaceInputString.length()-1; i>=0; i--) {
			backwordsString = backwordsString + noSpaceInputString.substring(i,i+1);
		}
		//checking if the phrase id the same backwards
		if(noSpaceInputString.equalsIgnoreCase(backwordsString)) {
			//if true displaying it is a palindrome
			IO.display("The input backwords is " + backwordsString + "\nIt is a Palindrome");

			//else displaying it is not a palindrome
		}else {
			IO.display("The input backwords is " + backwordsString + "\nIt is not a Palindrome");
		}


	}

}
