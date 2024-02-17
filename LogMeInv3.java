import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Scanner;

import javax.lang.model.element.NestingKind;
import javax.swing.ImageIcon;

public class LogMeInv3 {


	/**
	 * * @author Rajavnsh Sandhu
 * Date: 2022-10-29
 * Description: ask the user for username and password. 
 * If correct password and user Name is entered the program displays correct, 
 * otherwise password and userName is incorrect.
	 * 
	 * */
	public static void main(String[] args) {
		//declaring variables
		String username = "";// Variable for the userName set
		String password = "";// password set
		HashMap <String, String> map= new HashMap<>();// creating HashMap
		String usernameEnter;// userName user enters
		String passwordEnter;// password user enters
		int tries = 0;//setting up tries
		String choice;// to create

		choice = IO.readString("Do you want to create a account or do you already have one?\n"
				+ "Enter no to create an account\nAny other input will ask you to enter your username and "
				+ "password", new ImageIcon("QuestionMark.png"));

		//checking if the user wants to crate an account
		if(choice.equalsIgnoreCase("no")) {
			try {
				//Opening file 
				FileWriter passwords = new FileWriter("userPassword.txt",true); 

				//asking the user for their userName and password
				username = IO.readString("Enter new username:", new ImageIcon("QuestionMark.png"));
				password = IO.readString("Enter new password:", new ImageIcon("QuestionMark.png"));

				passwords.write("\n" + username + "," +password);

				//Closing the file
				passwords.close();

			} catch(IOException e) {
				IO.display("error");
			}
		}

			//reading files
			try {
				Scanner userName = new Scanner(new File("userPassword.txt"));//opening and reading file

				while(userName.hasNext()) {
					String [] user= userName.nextLine().split(",");
					map.put(user[0], user[1]);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//do while to come back if user enters wrong password
			do {
				//asking user for usernName and password
				usernameEnter = IO.readString("What is your username", new ImageIcon("QuestionMark.png"));
				passwordEnter = IO.readString("What is your password", new ImageIcon("QuestionMark.png"));

				//using hash maps to check if the file has username and password
				if(map.containsKey(usernameEnter)) {
					if(map.get(usernameEnter).equals(passwordEnter)) {
						IO.display("Correct username and password");

					}
					else {
						IO.display("incorrect username or password");
					}
				}
				else {
					IO.display("Username not found\n does not exist in data base");
					tries ++;// adding 1 to tries every time
				}

			} while(tries < 5 && (!map.containsKey(usernameEnter) || !map.get(usernameEnter).equals(passwordEnter)));

	}
}
