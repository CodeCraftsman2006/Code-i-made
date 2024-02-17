/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022=10-20
 * Description: displays a song using for loops
 *
 */
public class ItsAllAboutThatLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//for loop to repeat song
		System.out.println("Because you know, ");

		//Repeating line 6 times
		for(int i=0; i<=5; i++) {
			System.out.print("I'm all");
			for(int j = 0; j <4; j++) {
				System.out.print(" about that loop, ");
			}
			System.out.println("no trouble");
		}
		System.out.println("Yeah it's pretty clear, I can do all that looping now");

	}

}
