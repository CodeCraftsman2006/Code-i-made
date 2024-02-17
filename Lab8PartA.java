import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.naming.AuthenticationException;
import javax.print.attribute.standard.MediaName;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author 713168
 *
 */
public class Lab8PartA {

	


	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Font font = new Font("times new roman", Font.ITALIC, 20);

		//declaring array
		double labMarks[];
		labMarks=new double[4];

		//declaring a summtive array
		double summtiveMarks[];
		summtiveMarks = new double[4];


		FileReader fileR = new FileReader("Marks.txt");
		BufferedReader input = new BufferedReader(fileR);


		for(int i =0 ; i <labMarks.length; i++) {
			labMarks[i] = Double.parseDouble(input.readLine());

		}
		for(int i=0; i < labMarks.length; i++) {
			summtiveMarks[i] = Double.parseDouble(input.readLine());

		}

		fileR.close();

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
		summtiveAvrage = sum/4;

		FEP= Double.parseDouble(JOptionPane.showInputDialog(AverageCalulatorStep3.textArea("What is the percent mark on the Fep for your student", font)));


		//Calculating the average of the elements
		finalMark = 10*(labAvrage/100) + 60*(summtiveAvrage/100) + 30*(FEP/100);

		bonus = Double.parseDouble(JOptionPane.showInputDialog(null, AverageCalulatorStep3.textArea("The mark for the student is " + Math.round(finalMark) 
		+ " As a resulte of observations and conversation how much of a bost do you want to give your student?", font)));

		JOptionPane.showMessageDialog(null, AverageCalulatorStep3.textArea("The final mark for your student is " + Math.round(finalMark+bonus), font));

		String output ="";

		//writing to the file
		FileWriter fileW = new FileWriter("SortedOutput.txt");
		PrintWriter outputPrintWriter= new PrintWriter(fileW);
		for( int i =0; i< labMarks.length; i ++) {
			outputPrintWriter.println("Formative: " + labMarks[i]+ "Summtive: " + summtiveMarks[i]);
			output= output + "Formative: " + labMarks[i]+ "\tSummtive: " + summtiveMarks[i]+ "\n"; 
		}
		//Declaring median 
		double median =0;

		//Declaring median array
		double ClassMedian[] = new double[22];

		FileReader fileAFileReader= new FileReader("Class MediaName.txt");
		BufferedReader inputBufferedReader = new BufferedReader(fileAFileReader);
		for(int i = 0; i< ClassMedian.length; i++) {
			ClassMedian[i]= Double.parseDouble(inputBufferedReader.readLine());
		}
		for (int i=0; i<ClassMedian.length; i++) {
			for (int j=0; j<ClassMedian.length-1; j++) {
				// check if the goals are in order
				if (ClassMedian[j] > ClassMedian[j+1]) {
					// swap the goals0
					double tempGoals;
					tempGoals = ClassMedian[j];
					ClassMedian[j] = ClassMedian[j+1];
					ClassMedian[j+1] = tempGoals;
				}
			}
		}
		median = ClassMedian[(ClassMedian.length-1)/2];


		JOptionPane.showMessageDialog(null, output + "The Final mark is " + finalMark + "\nThe final median is " + median);

		outputPrintWriter.println("The Final mark is " + finalMark + " the final median is " + median);

		fileW.close();


	}

}
