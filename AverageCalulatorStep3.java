import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author rajva
 *
 */
public class AverageCalulatorStep3 {
	
	public static JTextArea textArea(String messageString, Font font) {
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setFont(font);
		outputTextArea.setForeground(Color.RED);
		outputTextArea.setText(messageString);
		return outputTextArea;
	}
	public static JTextArea textArea(String messageString) {
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setText(messageString);
		return outputTextArea;
	}

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
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
		
		FEP= Double.parseDouble(JOptionPane.showInputDialog(textArea("What is the percent mark on the Fep for your student", font)));
		
		
		//Calculating the average of the elements
		finalMark = 10*(labAvrage/100) + 60*(summtiveAvrage/100) + 30*(FEP/100);
		
		bonus = Double.parseDouble(JOptionPane.showInputDialog(null, textArea("The mark for the student is " + Math.round(finalMark) 
		+ " As a resulte of observations and conversation how much of a bost do you want to give your student?", font)));
		
		JOptionPane.showMessageDialog(null, textArea("The final mark for your student is " + Math.round(finalMark+bonus), font));
		
		String output ="";
		
		//writing to the file
		FileWriter fileW = new FileWriter("MarksFormatted.txt");
		PrintWriter outputPrintWriter= new PrintWriter(fileW);
		for( int i =0; i< labMarks.length; i ++) {
			outputPrintWriter.println("Formative: " + labMarks[i]+ "Summtive: " + summtiveMarks[i]);
			output= output + "Formative: " + labMarks[i]+ "\tSummtive: " + summtiveMarks[i]+ "\n"; 
		}
		JOptionPane.showMessageDialog(null, output + "The Final mark is " + finalMark);
		
		outputPrintWriter.println("The Final mark is " + finalMark);
		
		fileW.close();

	}

}
