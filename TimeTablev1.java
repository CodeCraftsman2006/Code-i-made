import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022/10/29
 * Description: displays time table
 *
 */
public class TimeTablev1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring variables 
		int timeTable = 0;//the timetable the user wants to see
		int ans = 0;// the answer after the multiplication happens
		String message = "";// final message to display in a dialog box
		
		
		//asking the user to enter the timetable they want to display
		timeTable = IO.readInt("What  Time Table do you want the see");
		
		//for loop to display the time table
		for(int i = 0; i <=10; i++) {
			ans = timeTable * i;
			message = message + "\n" + timeTable + "x" + i + "=" + ans;

		}
		IO.display(message);

	}

}
