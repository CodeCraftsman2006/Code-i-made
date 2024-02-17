/**
 * 
 */

/**
 * @author rajvansh Sandhu
 * Date: 2022-10-28
 * Description: This program will take the users input and display an out of the word backwards
 *
 */
public class PalindromesPartA {

	/**
	 * 
	 */
	public PalindromesPartA() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring variables
		String inputString = "";
		String backwordsString ="";
		
		//prompting and getting the  word
		inputString = IO.readString("Enter a word");
		
		//for loop to write the phrase backwards 
		for(int i= inputString.length()-1; i>=0; i--) {
			backwordsString = backwordsString + inputString.substring(i,i+1);
		}
		//displaying the word backwards
		IO.display("the input backwords is " + backwordsString);

	}

}
