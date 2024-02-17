import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.Period;
import java.awt.Font;

import javax.management.monitor.MonitorSettingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author 713168
 *
 */
public class FutureInvestmentGUI extends JFrame implements ActionListener{
	// Declare variables for labels and buttons
	// and variables to be used throughout the class
	JLabel messageJLabel, messageJLabel2,messageJLabel3, messageJLabel4, valueJLabel, valueJLabel2,valueJLabel3,
	valueJLabel4, valueJLabel5, dollerJLabel, errorJLabel;
	JTextField TextField, TextField2, TextField3;
	JButton calulateJButton, btnclarButton,previousYearButton, futureYearsButton; 
	DecimalFormat twoDigitDecimalFormat = new DecimalFormat("#0.00");
	Font font;// Importing font

	/**
	 * constructor method
	 */
	public FutureInvestmentGUI() {// Set the frame's name
		super("Future Investment GUI");

		//crates label
		messageJLabel = new JLabel("Starting amount");
		messageJLabel2 = new JLabel("Interst rate");
		messageJLabel3 = new JLabel("Years");
		messageJLabel4 = new JLabel("Value Of Investmennt");
		valueJLabel = new JLabel();
		valueJLabel2 = new JLabel();
		valueJLabel3 = new JLabel();
		valueJLabel4 = new JLabel();
		valueJLabel5 = new JLabel();
		errorJLabel = new JLabel();


		//create text felid
		TextField = new JTextField();
		TextField2 = new JTextField();
		TextField3 = new JTextField();

		//crates Jbuttons
		calulateJButton = new JButton("Calulate Investment");
		btnclarButton = new JButton("clear");
		previousYearButton = new JButton("Next Years");
		futureYearsButton= new JButton("Pervious Years");

		// set the size and layout
		// null layout allows us to place items using setBounds below
		setLayout(null);

		//place all items wherever we want USING X AND Y CO-ORDINATES, WIDTH AND HEIGHT
		messageJLabel.setBounds(10,10,100,15);
		messageJLabel2.setBounds(10,50,100,15);
		messageJLabel3.setBounds(10,90,100,15);
		messageJLabel4.setBounds(440,10,150, 15);
		valueJLabel.setBounds(400,30,300,15);
		valueJLabel2.setBounds(400,70,300,15);
		valueJLabel3.setBounds(400,110, 300, 15);
		valueJLabel4.setBounds(400,150,300,15);
		valueJLabel5.setBounds(400,190,300,15);
		errorJLabel.setBounds(10,10,700,350);


		// add the labels, textboxes and buttons to the frame
		add(messageJLabel);
		add(messageJLabel2);
		add(messageJLabel3);
		add(messageJLabel4);
		add(valueJLabel);
		add(valueJLabel2);
		add(valueJLabel3);
		add(valueJLabel4);
		add(valueJLabel5);
		add(errorJLabel);


		//setting bonds and adding the text fields
		TextField.setBounds(110, 10, 200, 25);
		add(TextField);

		TextField2.setBounds(110, 50, 200, 25);
		add(TextField2);

		TextField3.setBounds(110, 90, 200, 25);
		add(TextField3);

		calulateJButton.setBounds(10,120,150,25);
		add(calulateJButton);

		btnclarButton.setBounds(177, 120, 80, 25);
		add(btnclarButton);

		previousYearButton.setBounds(360, 220,120,25);

		futureYearsButton.setBounds(500, 220,120,25);

		add(futureYearsButton);
		add(previousYearButton);

		//new image icon
		dollerJLabel = new JLabel(new ImageIcon("giphy.gif"));
		dollerJLabel.setBounds(10,150, 200,200);
		add(dollerJLabel);


		// make the buttons listen to clicks on this app
		calulateJButton.addActionListener(this);
		btnclarButton.addActionListener(this);
		previousYearButton.addActionListener(this);
		futureYearsButton.addActionListener(this);

		//setting the size and making it visible
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//making it so it exits on close
	}
	/*
	 * action listening method - listens to events
	 */
	public void actionPerformed(ActionEvent evt) {
		//setting font
		font = new Font("times new roman", Font.ITALIC, 50);
		errorJLabel.setFont(font);
		
		
		//start my window 
		//checking if the calculate button if clicked
		if (evt.getSource() == calulateJButton) {
			errorJLabel.setText("");
			//declaring and initializing the number of years since the investment, the startingAmount, the future value
			// and the interest rate to 0
			double startingAmount = 0, interestRate = 0, years =0;

			//try and catch for errors
			try {
				//type casting 3 text fields to doubles
				startingAmount =Double.parseDouble(TextField.getText());
				interestRate = Double.parseDouble(TextField2.getText());
				years = Double.parseDouble(TextField3.getText());


				//Checking if the input is valid if so calculating
				if(FutureInvestmentBasic.checkInput(startingAmount)==true&&
						FutureInvestmentBasic.checkInput(interestRate)==true&&
						FutureInvestmentBasic.checkInput(years)==true) {


					valueJLabel.setText(("Year: " + years + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years))));

					valueJLabel2.setText(("Year: " + (years+1) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+1))));

					valueJLabel3.setText(("Year: " + (years+2) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+2))));

					valueJLabel4.setText(("Year: " + (years+3) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+3))));

					valueJLabel5.setText(("Year: " + (years+4) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+4))));


					//otherwise displaying a user friendly error message
				}else {
					
					//displaying new font
					errorJLabel.setText("Error Please enter valid input");
				}
			} catch (Exception e) {
				//setting font
				font = new Font("times new roman", Font.ITALIC, 50);
				errorJLabel.setFont(font);
				
				//displaying new font
				errorJLabel.setText("Error Please enter valid input");
			}

		}

		//checking if the button clear is pressed
		else if(evt.getSource() == btnclarButton) {
			//clearing all the text fields and message fields
			errorJLabel.setText("");
			TextField.setText("");
			TextField2.setText("");
			TextField3.setText("");
			valueJLabel.setText("");
			valueJLabel2.setText("");
			valueJLabel3.setText("");
			valueJLabel4.setText("");
			valueJLabel5.setText("");
			
			//checking if future year button is pressed
		} else if(evt.getSource() == futureYearsButton) {
			errorJLabel.setText("");
			//declaring and initializing the number of years since the investment, the startingAmount, the future value
			// and the interest rate to 0
			double startingAmount, interestRate, years;

			//try and catch for errors
			try {
				//type casting 3 text fields
				startingAmount =Double.parseDouble(TextField.getText());
				interestRate = Double.parseDouble(TextField2.getText());
				years = Double.parseDouble(TextField3.getText());


				//Checking if the input is valid if so calculating
				years = years -5;//going 5 years in the past
				TextField3.setText("" +years);


				//Checking if the input is valid if so calculating
				if(FutureInvestmentBasic.checkInput(startingAmount)==true&&
						FutureInvestmentBasic.checkInput(interestRate)==true&&
						FutureInvestmentBasic.checkInput(years)==true) {


					valueJLabel.setText(("Year: " + years + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years))));

					valueJLabel2.setText(("Year: " + (years+1) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+1))));

					valueJLabel3.setText(("Year: " + (years+2) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+2))));

					valueJLabel4.setText(("Year: " + (years+3) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+3))));

					valueJLabel5.setText(("Year: " + (years+4) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+4))));
					
					//else displaying user friendly error message
				}else {
					//setting font
					font = new Font("times new roman", Font.ITALIC, 50);
					errorJLabel.setFont(font);
					
					//displaying new font
					errorJLabel.setText("Error Please enter valid input");
				}
			} catch (Exception e) {

				//setting font
				font = new Font("times new roman", Font.ITALIC, 50);
				errorJLabel.setFont(font);
				
				//displaying new font
				errorJLabel.setText("Error Please enter valid input");
			}
		}
		
		//checking if previous year button is pressed
		else if(evt.getSource() == previousYearButton) {
			errorJLabel.setText("");
			//declaring and initializing the number of years since the investment, the startingAmount, the future value
			// and the interest rate to 0
			double startingAmount = 0, interestRate = 0, years =0;

			//try and catch for errors
			//try and catch for errors
			try {
				//type casting 3 text fields
				startingAmount =Double.parseDouble(TextField.getText());
				interestRate = Double.parseDouble(TextField2.getText());
				years = Double.parseDouble(TextField3.getText());

				//going 5 years ahead and setting the text field to the new number of years
				years = years + 5;
				TextField3.setText("" +years);

				//Checking if the input is valid if so calculating
				if(FutureInvestmentBasic.checkInput(startingAmount)==true&&
						FutureInvestmentBasic.checkInput(interestRate)==true&&
						FutureInvestmentBasic.checkInput(years)==true) {


					valueJLabel.setText(("Year: " + years + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years))));

					valueJLabel2.setText(("Year: " + (years+1) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+1))));

					valueJLabel3.setText(("Year: " + (years+2) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+2))));

					valueJLabel4.setText(("Year: " + (years+3) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+3))));

					valueJLabel5.setText(("Year: " + (years+4) + "   Value: $" + 
							twoDigitDecimalFormat.format(FutureInvestmentBasic.calculateInvestment(startingAmount,interestRate,years+4))));



					//else displaying user friendly error message
				}else {
					//setting font
					font = new Font("times new roman", Font.ITALIC, 50);
					errorJLabel.setFont(font);

					//displaying new font
					errorJLabel.setText("Error Please enter valid input");					}
			} catch (Exception e) {
				//setting font
				font = new Font("times new roman", Font.ITALIC, 50);
				errorJLabel.setFont(font);

				//displaying new font
				errorJLabel.setText("Error Please enter valid input");
			}
		}

	}
	public static void main(String[] args) {
		// displaying rules
		IO.display("---------------------------\nAnother Wonderful Program By:\nRajvanshSandhu\n---------------------------");
		IO.display("This program takes the the starting value,\n interset rate and years as any postive number."
				+ " \nThen, it displays the future value. You can use the pervious years \nand future years button to go back and forth"
				+ " every 5 years");
		//calling the future investment
		new FutureInvestmentGUI();
	}

}