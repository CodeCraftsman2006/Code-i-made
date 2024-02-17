import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-12-31
 * Description: This program will take a students mark as an input and display their final report card mark
 *
 */
public class AverageCalulatorStep2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		int numFormative =0, numSummtive=0;
		
		numFormative = Integer.parseInt(JOptionPane.showInputDialog("How many formative did the student do?"));
		numSummtive = Integer.parseInt(JOptionPane.showInputDialog("How many summtives did the student do"));
		
		//declaring array
		double labMarks[];
		labMarks=new double[numFormative];

		//declaring a summtive array
		double summtiveMarks[];
		summtiveMarks = new double[numSummtive];

		//add summtive marks
		//adding students Lab marks to array
		for(int i =0; i< numFormative;i++) {
			labMarks[i]= Integer.parseInt(JOptionPane.showInputDialog("What mark did the student get on the formative " +(i+1)));
		}
		for(int i=0; i<numSummtive; i++) {
			summtiveMarks[i]= Integer.parseInt(JOptionPane.showInputDialog("What mark did the student get in summtive " + (i+1)));
		}

		//Declaring and initialing variables
		double sum=0, labAvrage=0, summtiveAvrage=0, finalMark=0, FEP =0, bonus =0;

		//adding all the elements in the array
		for(int i=0; i<labMarks.length; i++) {
			sum = labMarks[i] + sum;
		}
		labAvrage = sum/4;

		sum =0;
		for(int i =0; i<summtiveMarks.length;i++) {
			sum = summtiveMarks[i]+sum;
		}

		//Calculating the average of the elements
		summtiveAvrage = sum/4;
		FEP= Double.parseDouble(JOptionPane.showInputDialog("What is the percent mark on the Fep for your student"));

		finalMark = 10*(labAvrage/100) + 60*(summtiveAvrage/100) + 30*(FEP/100);

		bonus = Double.parseDouble(JOptionPane.showInputDialog(null, "The mark for the student is " + Math.round(finalMark) 
		+ " As a resulte of observations and conversation how much of a bost do you want to give your student?"));

		JOptionPane.showMessageDialog(null, "The final mark for your student is " + Math.round(finalMark+bonus));


	}

}
