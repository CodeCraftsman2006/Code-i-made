import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.ClosedChannelException;
import java.nio.file.FileAlreadyExistsException;
import java.text.DecimalFormat;
import java.util.Iterator;

import javax.lang.model.element.NestingKind;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.transaction.xa.XAException;
import javax.xml.validation.Validator;

/**
 * 
 */

/**
 * @author  @author Rajvansh Sandhu
 * Date: 1/18/2023
 * Description: This program take the input from a data file of the number of months and the rainfall then calculates the the total percent
 * of rain.
 *
 */
public class RainfallCalulatorEnhancement {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * 
	 */
	/*
	 * method list: 
	 * -total: calculates the total of all the elements in the array and returns the total
	 * -askUser: is used when you want to ask the user a yes or no question and it will return y/n
	 * -calulate:is the method that reruns a array with the percent percent index calculated
	 */
	//to add all the index in the array
	public static double total(double array[]) {
		double total =0;//declaring total as 0 and a for loop to go through and store the sum in total
		for(int i= 0; i<array.length; i++) {
			total = total + array[i];
		}
		//returning total
		return total;

	}


	public static String askUser(String messageString) {
		String choiceString = "";
		//declaring a empty string

		//while loop to come back if the user enter a invalid input
		while (true) {
			//try and catch if the user enters a number instead of y/n
			try {
				//displaying message and taking a y/n input
				choiceString = JOptionPane.showInputDialog(null, messageString);

				//if y or n is enter then it will return otherwise the user is in a infinite loop
				if( choiceString.equalsIgnoreCase("n")|| choiceString.equalsIgnoreCase("y")) {
					return choiceString;
				} else {
					//user friendly error message
					JOptionPane.showMessageDialog(null, "Please enter Y/N");
				}

				//if the user enters a string then displaying a error message telling the user to enter y/n
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Please enter Y/N");
			}

		}


	}

	public static double[] calulate(double array[]) {
		//declaring variable and using the total method to calculate the sum of the elements in the array
		double total = total(array);
		//declaring and creating new array with the calculations
		double newArray[] = new double[array.length];

		//Calculating the new average
		for(int i=0; i < array.length; i++) {
			newArray[i] = (array[i]/total)*100;
		}
		//Returning the array with the new average
		return newArray;

	}
	public static void sort(String months[], double precipitation[]) {
		//sorting the arrays average months in alphabetically order
		for (int i=0; i<months.length; i++) {

			//numbers range from 97 to 122. 97 is a
			for (int j=0; j<months.length-1; j++) {
				// check if the months are in order
				//putting the month to lower case then check if in alphabetically order
				//for loop to compare all the letters in the word
				if (((int)months[j].toLowerCase().charAt(0))> ((int)months[j+1].toLowerCase().charAt(0))) {
					//swap the month
					String monthString;
					monthString = months[j];
					months[j] = months[j+1];
					months[j+1] = monthString;
					// swap the precipitation
					double tempPrecipitation;
					tempPrecipitation = precipitation[j];
					precipitation[j] = precipitation[j+1];
					precipitation[j+1] = tempPrecipitation;


					//checking if the months are equal to each other
				} else if((((int)months[j].toLowerCase().charAt(0))== ((int)months[j+1].toLowerCase().charAt(0)))) {

					//I found this after did it using ASCII  so i added it as a backup if the top does not work
					//this function compares two strings lexicographically, ignoring lower case and upper case differences. 
					//The comparison is based on the Encode value 
					//of each character in the string converted to lower case. 
					//The method returns 0 if the string is equal to the other string
					//https://www.w3schools.com/java/ref_string_comparetoignorecase.asp
					if (months[j].compareToIgnoreCase(months[j+1])>0) {
						//swap the month
						String monthString;
						monthString = months[j];
						months[j] = months[j+1];
						months[j+1] = monthString;
						// swap the precipitation
						double tempPrecipitation;
						tempPrecipitation = precipitation[j];
						precipitation[j] = precipitation[j+1];
						precipitation[j+1] = tempPrecipitation;
						break;


					}

				} 
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		//setting up decimal format
		DecimalFormat twodigitDecimalFormat = new DecimalFormat("#0.00");

		// declaring and initializing variables 
		String choiceString="";
		String fileUserEnter = "";
		//to display the information
		String outputString ="\nMonth:\tPrecipitation:\taverage:\n";
		int lenght = 0;
		boolean Monthfound;
		String searchkeyString ="";
		int location = 0;

		//declaring arrays
		String months[];
		double[] precipitation;
		double averages[];

		//declaring jTextArea to display new information
		JTextArea outputTextArea = new JTextArea();
		Font font = new Font("times new roman", Font.BOLD, 20);
		outputTextArea.setFont(font);
		outputTextArea.setTabSize(15);
		outputTextArea.setForeground(Color.GREEN);
		outputTextArea.setBackground(Color.black);

		//declaring the BufferedReader and filer
		BufferedReader input = null;
		FileReader fileR;
		
		//while loop to ask the user to input the information again
		while(true) {
			
			//prompting and getting the file name
			choiceString = JOptionPane.showInputDialog("Do you want to enter your filename? enter Y/N");
			
			//checking if the user entered y
			if(choiceString.equalsIgnoreCase("Y")) {
				fileUserEnter = JOptionPane.showInputDialog("What is the filename?");
				
				//otherwise making it the default file rainfall.txt
			} else {
				fileUserEnter = "rainfall.txt";
			}


			//try and catch for file not found
			try {
				//Reading the file
				fileR = new FileReader(fileUserEnter);
				input = new BufferedReader(fileR);

				//catch for the file not found error
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "File not found");
				continue;//going back and asking the user the name of the file
			}
			//reading the number of indexes in the array
			lenght = Integer.parseInt(input.readLine());

			//declaring and creating months arrays and precipitation array
			months = new String[lenght];
			precipitation = new double[lenght];

			//try block if their is an error in the file
			try {
				for(int i=0; i <months.length; i++) {
					///reading the file and putting the month and precipitation in 2 different arrays
					months[i] = input.readLine();
					precipitation[i] = Double.parseDouble(input.readLine()); 
				}
				//catch block if their is a error in the file
			}catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error in file");
				continue;//asking the user to enter a different file because the file is corrupted 
			}

			//Declaring a array for the averages 
			averages = new double[lenght];

			//Calculating the average  precipitation
			averages = calulate(precipitation);

			break;//breaking out of the while loop
		}
		
		//Calling the  method c]askUser to get the y or n ask to if they want to search for a month
		choiceString = askUser("Do you want to search for 1 month?\nEnterY/N");

		//checking if the user entered yes to search for 1 month
		if (choiceString.equalsIgnoreCase("y")) {
			
			//While loop to ask the user the question again if the input is wrong
			while(true) {
				//try and catch for if the user enters a number instead of a String
				try {
					searchkeyString = JOptionPane.showInputDialog("What is the month you want to search for?");
				} catch( Exception e) {
					JOptionPane.showMessageDialog(null, "Please enetr a valid String input");
					continue;//going back to the while loop to ask the user the question again
				}

				//for loop to check each month
				for(int i=0; i<months.length; i++) {
					//if the search key matches with the a month in the array then store the location in the int location
					if(searchkeyString.equalsIgnoreCase(months[i])) { 
						JOptionPane.showMessageDialog(null, "Month: " + months[i]+ "\nprecipitation: " + precipitation[i]+ 
								"\naverage: "+ 
								twodigitDecimalFormat.format(averages[i]));
						location=i;
						Monthfound=true;//checking if the month is found then making monthFound=True
						
						break;//breaking out of the for loop cause month is found(making code efficient)
					} 
					//if moth is not found making month found =false
					Monthfound =false;
				}
				//going back to the top of the code and asking the suer to re-enter the month
				if(Monthfound=false) {
					JOptionPane.showInternalMessageDialog(null, "Month not found re-enter month");
					continue;

				}
				
				//calling the askUser method to ask Do you want to change the precipitation of this month?
				choiceString = askUser("Do you want to change the precipitation of this month?");
				// if the user entered yes then the programs takes the new perception
				if(choiceString.equalsIgnoreCase("y")) {
					precipitation[location] = Double.parseDouble(JOptionPane.showInputDialog("What is the new precipitation of " + months[location]));

					//Calculating the average with the new precipitation
					averages = calulate(precipitation);
					
					//asking if the want to change the precipitation for more months
					choiceString = askUser("Do you want to want to change the precipitation for another month\nEnter y/n");
					// checking if the user entered y
					if(choiceString.equalsIgnoreCase("y")) {
						continue;//going back to the top of the while loop
					}

					
					//otherwise asking the user if they want to save the new data if they say yes then saving the new data
					else {

						choiceString = askUser("Do you want to save the new data\nEnetr y/n");

						//checking if the user entered y
						if(choiceString.equalsIgnoreCase("y")) {
							String file;
							//asking the user what they want to call their file
							file= JOptionPane.showInputDialog("What do you want to call your file");

							//creating a file under the name the user called it
							FileWriter fileW = new FileWriter(file);
							PrintWriter outputPrintWriter= new PrintWriter(fileW);

							//adding the number of element to the top of the new file
							outputPrintWriter.println(lenght);

							//adding the data to the file
							for( int i =0; i< months.length; i ++) {
								outputPrintWriter.println(months[i]);
								outputPrintWriter.println(precipitation[i]);
							}

							//closing the file
							fileW.close();

							//creating a file under the name the user called it
							FileWriter fileV = new FileWriter(file+"Formatted");
							PrintWriter outputPrintWriter1= new PrintWriter(fileV);

							//adding the number of element to the top of the new file
							outputPrintWriter1.println("Number of elements in the array " + lenght);

							//adding the data to the file
							for( int i =0; i< months.length; i ++) {
								outputPrintWriter1.println("Months:" + months[i] + "Precipitation:" + precipitation[i]);
							}

							//closing the file
							fileV.close();

						}
						//breaking out of the loop
						break;
					}
				} else {
					break;
				}


			}
		}

		//Calculating the high percent and low percent and the month of each then storing then into 2 different files
		//creating a file under the name the user called it
		FileWriter fileZ = new FileWriter("High precent");
		PrintWriter outputPrintWriter1= new PrintWriter(fileZ);

		//creating a file under the name the user called it
		FileWriter fileC = new FileWriter("Low precent");
		PrintWriter outputPrintWriter= new PrintWriter(fileC);

		//adding the data to the file
		for( int i =0; i< months.length; i ++) {
			if(averages[i]> 9) {
				outputPrintWriter1.println(months[i] + "\n" + precipitation[i]);
			} else {
				outputPrintWriter.println(months[i]+ "\n" +precipitation[i]);
			}
		}

		//closing the file
		fileZ.close();
		fileC.close();

		//prompting anding y/n after asking if they want to see the precipitation in descending order
		choiceString = JOptionPane.showInputDialog("Do you want to see the percent of precipitation in decending order?\nEnterY/N");

		//if they enter y then sorting the array in descending order
		if(choiceString.equalsIgnoreCase("y")) {


			//sorting the arrays average perception in descending order
			for (int i=0; i<precipitation.length; i++) {
				for (int j=0; j<precipitation.length-1; j++) {
					// check if the perception are in order
					if (precipitation[j] > precipitation[j+1]) {
						// swap the perception
						double tempPrecipitation;
						tempPrecipitation = precipitation[j];
						precipitation[j] = precipitation[j+1];
						precipitation[j+1] = tempPrecipitation;
						//swap the month
						String monthString;
						monthString = months[j];
						months[j] = months[j+1];
						months[j+1] = monthString;


					}
				}
			}
			
			//Calculating the new precipitation
			averages= calulate(precipitation);
			//Adding new information the outputString to display at once
			for(int i=0; i< months.length; i++) {
				outputString = outputString + months[i] + "\t" + precipitation[i] + "\t" + twodigitDecimalFormat.format(averages[i]) + "%\n";
			}
			outputTextArea.setText(outputString);
			JOptionPane.showMessageDialog(null, outputTextArea);

		}
		choiceString = askUser("Do want to sort the program alphabetically?");
		if(choiceString.equalsIgnoreCase("y")){
			//calling the sort method to sort the months alphabetically
			sort(months, precipitation);

			averages= calulate(precipitation);//re-calculating the percent
			
			//adding the new information to the output String
			for(int i=0; i< months.length; i++) {
				outputString = outputString +months[i] + "\t" + precipitation[i] + "\t" + twodigitDecimalFormat.format(averages[i]) + "% \n";
			}
			//setting the test in text area
			outputTextArea.setText(outputString);
			
			//displaying the text area
			JOptionPane.showMessageDialog(null, outputTextArea);


		}

		else {
			//adding the new information to the output String
			for(int i= 0; i< averages.length; i++) {
				outputString = outputString  +months[i] + "\t" + precipitation[i] + "\t" + twodigitDecimalFormat.format(averages[i]) + "% \n";
			}

			//setting the test in text area
			outputTextArea.setText(outputString);
			
			//displaying the text area
			JOptionPane.showMessageDialog(null, outputTextArea);
		}

	}
}