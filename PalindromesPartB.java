/**
 * @author rajvansh Sandhu
 * Date: 2022-10-28
 * Description: This program will take the users input and display an out of the word backwards and checks if it is a Palindrome or not
 *
 */
public class PalindromesPartB {

	public PalindromesPartB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//declaring variables
		String inputString = "";
		String backwordsString ="";

		inputString = IO.readString("Enter a word");

		//for loop to write the phrase backwards 
		for(int i= inputString.length()-1; i>=0; i--) {
			backwordsString = backwordsString + inputString.substring(i,i+1);
		}
		//checking if the phrase id the same backwards
		if(inputString.equals(backwordsString)) {
			//if true displaying it is a palindrome
			IO.display("The input backwords is " + backwordsString + "\nIt is a Palindrome");
			
			//else displaying it is not a palindrome
		}else {
			IO.display("The input backwords is " + backwordsString + "\nIt is not a Palindrome");
		}

	}

}
