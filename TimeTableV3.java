/**
 * 
 */

/**
  * @author Rajvansh Sandhu
 * Date: 2022/10/29
 * Description: displays time table
 *
 */
public class TimeTableV3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring variables
		int timeTable = 0;//the timetable the user wants to see
		int ans = 0;// the answer after the multiplication happens
		String message = "";// final message to display in a dialog box
		int maxNum = 0;// until what number the user wants to go till
		
		//asking the user to enter the timetable they want to display
		timeTable = IO.readInt("What  Time Table do you want the see? ");
		maxNum = IO.readInt("What number should the table stop at? ");


		//for loop to display the time table
		for(int i = 0; i <=maxNum; i++) {
			for(int k=0; k < i; k++) {
			ans = ans + timeTable;
		}
			message = message + "\n" + timeTable + "x" + i + "=" + ans;//formatting the final message
			ans = 0;//resting value of ans
		}
		IO.display(message);


	}

}
