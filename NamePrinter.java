import java.util.Scanner;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 *Date:2022-09-25
 *Description: prints my name
 */
public class NamePrinter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		// setting up variable for name
		String name;
		int lenght = 0;
		String dash = "-";

		// setting up to read the variable
		Scanner strInput = new Scanner(System.in); 
		
		// asking the user for their name
		System.out.println("whats your name");
		
		// getting the users name
		name = strInput.nextLine();
		
		//checking the number of letters inputed
		lenght = name.length();
		
		String repeated = "";
		
		for(int i =1; i<=name.length(); i ++) {
			repeated = repeated + "-";
		}
		
		//depending on how many numbers that the name has that many dash will be printed
		//String repeated = new String(new char[lenght]).replace("\0", dash);
		System.out.println("+" + repeated + "+");
		
		//print name
		System.out.println("|" + name + "|");
		
		//depending on how many numbers that many - will be printed
		System.out.println("+" + repeated + "+");

	}

}
