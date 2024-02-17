/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-10-30
 * Description: Program that take the users input as name then displays how many names were entered
 *
 */
public class NameCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declaring variables
		int counter = 0;
		String name = "";
		String message = "";

		while(!(name.equalsIgnoreCase("Thats All"))) {
			//Prompting and getting name
			name = IO.readString("Enter name");

			if(!(name.equalsIgnoreCase("Thats all"))) {
				//adding the names to the final message
				message = message + name + "\n";

				// adding one to counter
				counter ++;
			}
		}
		//displaying how many names were entered
		IO.display("You entered " + counter + " names");

		//displaying what names were entered
		IO.display("The names you entered are " + message);

	}

}
