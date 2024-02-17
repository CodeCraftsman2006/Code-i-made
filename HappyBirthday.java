import java.util.Scanner;

/**
 * 
 */

/**
 * @author 713168
 * Date: 2022-09-25
 * description: This program will display the happy birthday lyrics 
 *
 */
public class HappyBirthday {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		
		String name;// setting up variable for name

		// setting up to read input
		Scanner strInput = new Scanner(System.in); 
		
		// asking the user whos bithday is it
		System.out.println("Whos birthday is it?");
		
		// getting an input
		name = strInput.nextLine();
		
		System.out.println("Happy Birthday to You");
		Thread.sleep(3000);//telling the program to wait 1 second
		
		System.out.println("Happy Birthday to You");
		Thread.sleep(3000);//telling the program to wait 1 second
		
		System.out.println("Happy Birthday Dear, " + name);
		Thread.sleep(3000);//telling the program to wait half a second
		
		System.out.println("Happy birhtday to you");
		Thread.sleep(5000);//telling the program to wait 1 second
		
		System.out.println("From good friends and true,");
		Thread.sleep(5000);//telling the program to wait 1 second
		
		System.out.println("From old friends and new,");
		Thread.sleep(5000);//telling the program to wait 1 second
		
		System.out.println("May good luck go with you,\nAnd happiness too");
		
	}

}
