import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 1/18/2023
 * Description: This program take the input from a data file of the number of months and the rainfall then calculates the the total percent
 * of rain.
 *
 */
public class RainfallCalulator {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	/*
	 * method list: total calculates the total of all the elements in the array
	 */
	double total(double array[]) {
		double total =0;
		for(int i= 0; i<array.length; i++) {
			total = total + array[i];
		}
		return total;

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// declaring and initializing variables 
		String choiceString="";
		String fileUserEnter = "";
		
		choiceString = JOptionPane.showInputDialog("Do you want to enter your filename? enter Y/N");
		
		if(choiceString.equalsIgnoreCase("Y")) {
			fileUserEnter = JOptionPane.showInputDialog("What is the filename?");
		} else {
			fileUserEnter = "rainfall.txt";
		}
		
		
		//Reading the file
		FileReader fileR = new FileReader(fileUserEnter);
		BufferedReader input = new BufferedReader(fileR);

		DecimalFormat twodigitDecimalFormat = new DecimalFormat("#0.00");

		// declaring and initializing variables 
		int lenght = 12;
		//declaring and creating months arrays
		String months[] = new String[lenght];

		//declaring a summtive array
		Double precipitation[] = new Double[lenght];

		for(int i=0; i <months.length; i++) {
			///reading the file and putting the month and precipitation in 2 different files
			months[i] = input.readLine();
			precipitation[i] = Double.parseDouble(input.readLine()); 
			// adding 1 to the length to make the array bigger
			lenght = lenght++;
		}
		//Declaring a array for the averages 
		Double averages[] = new Double[lenght];

		double total = 0;
		//Calculating the total
		for(int i=0; i<precipitation.length; i++) {
			total = total + precipitation[i];
		}
		for(int i=0; i < precipitation.length; i++) {
			averages[i] = (precipitation[i]/total)*100;
		}
		//to display the information
		String outputString ="+=====    ==========    =========+\nMonth    precipitation       average\n";
		//Array to sort
		String sorte[]= new String[lenght];

		for(int i= 0; i< averages.length; i++) {
			outputString = outputString  +months[i] + "    " + precipitation[i] + "       " + twodigitDecimalFormat.format(averages[i]) + "% \n";
			sorte[i] = months[i] + "    " + precipitation[i] + "       " + twodigitDecimalFormat.format(averages[i]) + "%";
		}
		//sorting the arrays average perception in descending order
		for (int i=0; i<precipitation.length; i++) {
			for (int j=0; j<precipitation.length-1; j++) {
				// check if the goals are in order
				if (precipitation[j] > precipitation[j+1]) {
					// swap the goals
					String tempPrecipitation;
					tempPrecipitation = sorte[j];
					sorte[j] = sorte[j+1];
					sorte[j+1] = tempPrecipitation;

				}
			}
		}

		// declaring and initializing variables 
		String searchkeyString ="";

		choiceString = JOptionPane.showInputDialog(null, "Do you want to search for 1 month?\nEnterY/N");

		//checking if the user entered yes to search for 1 month
		if (choiceString.equalsIgnoreCase("y")) {
			searchkeyString = JOptionPane.showInputDialog("What is the month you want to search for?");

			//for loop to check each month
			for(int i=0; i<months.length; i++) {
				//if the search key matches with the a month in the array then store the location in the int location
				if(searchkeyString.equalsIgnoreCase(months[i])) { 
					JOptionPane.showMessageDialog(null, "Month: " + months[i]+ "\nprecipitation: " +
							precipitation[i]+ "\naverage: "+ averages[i]);
				}
			}


		} else {
			choiceString = JOptionPane.showInputDialog("Do you want to see the percent of precipitation in decending order?\nEnterY/N");
			if(choiceString.equalsIgnoreCase("y")) {
				for(int i=0; i< sorte.length; i++) {
					outputString = sorte[i];
				}
				JOptionPane.showMessageDialog(null, outputString);
			}

		}

	}
}