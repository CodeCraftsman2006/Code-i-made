/**
 * 
 */

/**
 * @author Rajavnsh Sandhu
 * Date: 2022-10-29
 * Description: ask the user for username and password. 
 * If correct password and user Name is entered the program displays correct, 
 * otherwise password and userName is incorrect.
 *
 */
public class LogMeIn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring variables
		String username = "Raj";// userName set
		String password = "ILOVEU";// password set
		String usernameEnter = "sa";// userName user enters
		String passwordEnter = "sdh";// password
		int tries = 0;

		while(tries < 5 && (!usernameEnter.equals(username) || !passwordEnter.equals(password))) {
			//asking user for usernName and password
			usernameEnter = IO.readString("What is your username");
			passwordEnter = IO.readString("What is your password");

			//check if they entered the correct userName and password 
			if(usernameEnter.equalsIgnoreCase(username) && passwordEnter.equalsIgnoreCase(password)) {
				IO.display("Correct username and password");
			}
			// if it is not correct telling the user their input is wrong
			else {
				IO.display("Incorrect username or password");
				tries ++;
			}

		}
		IO.display("Incorrect password. Please contact your Network Administrator");

	}

}
