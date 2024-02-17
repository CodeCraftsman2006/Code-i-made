import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 *Date: 9-26-2022
 *Description: This program will print a receipt
 */
public class Receipt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// setting up variable for name and Arraylist
		String company;
		String item;
		double itemPrice, total = 0;
		String choice = null;
		ArrayList <String> itemsArray = new ArrayList<>();  // https://www.youtube.com/watch?v=NbYgm0r7u6o&t=754s
		ArrayList <Double> pricesArray = new ArrayList<>();
		DecimalFormat twoDigit = new DecimalFormat("#0.00");
		
		//prompt user for the company
		System.out.println("What is the name of the company");
		
		// setting up to read the variable
		Scanner StrInput = new Scanner(System.in); 
		Scanner Input = new Scanner(System.in);
		
		//The user inputs the company name
		company = StrInput.nextLine();
		
		while(true) {
			
			// creating a try block to check for an error
			try {
				//prompt the user for items and get item add it to the array list
				System.out.println("What is the name of the item you bought?");
				item = StrInput.nextLine();
				itemsArray.add(item);
				
				//prompt the user for the price of the array list
				System.out.println("What is the price of the item?");
				itemPrice = Input.nextDouble();
				pricesArray.add(itemPrice);
				
				//ask the user if they want to add more items
				System.out.println("Would you like to add more items?\n");
				choice = StrInput.nextLine().toUpperCase();
			
				// IF the user enters a negative number then  the program will display please enter a valid input
				if(itemPrice<0) {
					System.out.println("Please enter a vaid input");
				}
				
				// if the user enters no then break out of the while loop
				else if (choice.equals("NO")) {
				break; 
			}
			}
			
		//creating a catch block and telling it the action that must be taken if a error is found
		catch (java.util.InputMismatchException e){
				//displaying error message
				System.out.println("Please enter a vaild input");
				
				//clearing the array so the user can try again
				pricesArray.clear();
				itemsArray.clear();
				}
			
		}
		// displaying name of company
		System.out.println(company + "\n");
		
		//displaying the date and time
		LocalDate time = LocalDate.now(); // Create a date object
	    System.out.println(time + "\n--------------------------"); // Display the current date
		
		
		// first we set i as 0 then take element 0 from the itemsArray then print it. 
		// we then add 1 to i to get the next element in the itemsArray 
		// it loops until all items are printed
		for (int i = 0; i < itemsArray.size(); i++) {  
            System.out.print(itemsArray.get(i) + ": $"); 
        
        //we set j as i then get the element in the pricesArray
            for (int j = i; j < pricesArray.size(); j++) {  
                System.out.print(pricesArray.get(j) + " \n");
                total = pricesArray.get(j) + total;
                break;
    		}
		}
		
		//displaying the total price
		System.out.println("--------------------------\n"
				+ "Total befoure tax: $" + total);
		
		//Calculating tax
		double tax = total * 0.13;
		
		//displaying tax
		System.out.println("Tax(13%): $" + tax);
		
		//Calculating the tax
		double totalWithTax = total * 1.13;
		
		//displaying the total with tax
		System.out.println("--------------------------\n"
				+ "Total with tax: $" + twoDigit.format(totalWithTax));

}
		
	}
