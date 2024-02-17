import java.awt.Choice;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-12-16
 * Description: this program  calculates the change in salary
 *
 */
public class salaryIncerseCalulator {

	/**
	 * ths
	 */
	public salaryIncerseCalulator() {
		// TODO Auto-generated constructor stub
	}

	public static double calculatePercent(double salary, double increaseRate) {
		increaseRate = salary+salary*(increaseRate/100);
		return increaseRate;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double percentIncerse =0;
		double salary =0;
		double salaryIncerse =0;
		String choice = "";

		while(true) {
			salary = IO.readDouble("What is your salary?");
			salaryIncerse = IO.readDouble("what is the persent incerse");
			percentIncerse = calculatePercent(salary, salaryIncerse);
			IO.display("Your new salary is " + percentIncerse);
			
			choice = IO.readString("Do you want to recalulate the salary?\n enter Y/N");
			if(choice.equalsIgnoreCase("n")) {
				break;
			}
		}


	}

}
