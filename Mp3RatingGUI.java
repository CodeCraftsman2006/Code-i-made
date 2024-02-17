import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * DAte: 12/9/2022
 * Description: creating a Graphical user interface for mp3 rating
 *
 *method list: 
 * public GUI example
 * 
 */
public class Mp3RatingGUI extends JFrame implements ActionListener{
	JLabel messageJLabel, messageJLabel2,messageJLabel3, songNameJLabel, overallratingJLabel, picJLabel;
	JTextField TextField, TextField2, textField3;
	JButton calulateButton, btnclarButton; 

	/**
	 * constructor method
	 */
	public Mp3RatingGUI() {
		super("Mp3 Rating GUI");

		//crates label
		messageJLabel = new JLabel("Enter rating of song: ");
		messageJLabel2 = new JLabel("Enter rating of encoding: ");
		messageJLabel3 = new JLabel("Enter the name of the song: ");
		songNameJLabel = new JLabel("Song Name is:");
		overallratingJLabel = new JLabel("Overall rating is:");
		picJLabel = new JLabel(new ImageIcon("MP3 logo.png"));


		//create text felid
		TextField = new JTextField();
		TextField2 = new JTextField();
		textField3 = new JTextField();

		//crates Jbuttons
		calulateButton = new JButton("Calulate");
		btnclarButton = new JButton("Clear");

		setLayout(null);
		
		//setting bounds and adding the text fields and message
		picJLabel.setBounds(300, 40, 120,120);
		add(picJLabel);
		
		messageJLabel.setBounds(10,10,200,15);
		add(messageJLabel);

		TextField.setBounds(170, 10, 100, 25);
		add(TextField);

		TextField2.setBounds(170, 50, 100, 25);
		add(TextField2);
		
		textField3.setBounds(170, 80, 100, 25);
		add(textField3);

		messageJLabel2.setBounds(10,50,200,15);
		add(messageJLabel2);
		
		messageJLabel3.setBounds(10,85,200,15);
		add(messageJLabel3);

		calulateButton.setBounds(10,110,130,25);
		add(calulateButton);

		btnclarButton.setBounds(155, 110, 80, 25);
		add(btnclarButton);

		calulateButton.addActionListener(this);
		btnclarButton.addActionListener(this);
		
		songNameJLabel.setBounds(10,135,300,25);
		overallratingJLabel.setBounds(10,165,300,25);
		add(songNameJLabel);
		add(overallratingJLabel);
		

		setSize(500,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/*
	 * action listening method - listens to events
	 */
	public void actionPerformed(ActionEvent evt) {
		//start my window 
		if (evt.getSource() == calulateButton) {
			int ratingOfEncoding=0, ratingOfSong=0, overallRating =0;
			ratingOfEncoding = Integer.parseInt(TextField.getText());
			ratingOfSong = Integer.parseInt(TextField2.getText());
			
			overallRating = (int) MP3Rating.computeMP3Rating(ratingOfSong, ratingOfEncoding);

			overallratingJLabel.setText("Overall rating is: " + overallRating);
			songNameJLabel.setText("Song Name is: "+textField3.getText());


		} else if(evt.getSource() == btnclarButton) {
			TextField.setText("");
			TextField2.setText("");
			textField3.setText("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Mp3RatingGUI();
	}

}
