import java.util.PrimitiveIterator.OfDouble;

import javax.annotation.processing.RoundEnvironment;
import javax.crypto.BadPaddingException;
import javax.naming.AuthenticationException;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-12-31
 * Description: this program calculates a students mark in a course
 *
 */
public class AverageCalulatorStep1 {

	/**
	 * 
	 */
	public AverageCalulatorStep1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//declaring array
		double labMarks[];
	
		labMarks=new double[4];
		
		//adding students Lab marks to array
		labMarks[0]= 88;
		labMarks[1] = 84;
		labMarks[2] = 91; 
		labMarks[3] =98;
		
		//declaring a summtive array
		double summtiveMarks[];
		summtiveMarks = new double[4];
		
		//add summtive marks
		summtiveMarks[0]= 88;
		summtiveMarks[1]= 91;
		summtiveMarks[2] = 84;
		summtiveMarks[3]= 78;
		
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
		+ "As a resulte of observations and conversation how much of a bost do you want to give your student?"));
		
		JOptionPane.showMessageDialog(null, "The final mark for your student is " + Math.round(finalMark+bonus));
		
		
		
				

	}

}
