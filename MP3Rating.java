import java.security.Signature;

/**
 * 
 */

/**
 * @author Rajvansh Sandhu
 * Date: 2022-12-16
 * Description: this program  calculates the overall rating of a song
 *
 */
public class MP3Rating {

	/**
	 * 
	 */
	public MP3Rating() {
		// TODO Auto-generated constructor stub
	}
	
	public static String displaySignature() {
		String signatureString="";
		
		for(int i=0; i<55; i++) {
			signatureString = signatureString + "-";
		}
	
		signatureString = signatureString + "\n\tANOTHER WONDERFUL APPLICATION\n                By: Rajvansh Sandhu\n";
		
		for(int i=0; i<55; i++) {
			signatureString = signatureString + "-";
		}
		
		return signatureString;

	}
	public static double computeMP3Rating(int song, int encoding) {
		double rating = 0;
		rating = (song+encoding)/2;
		return rating;
		
	}
	public static int checkInteger(int userinput, int minimun, int maximum) {
		
		while(!(userinput < maximum && userinput > minimun)) {
			userinput = IO.readInt("Please enter a number within the range of " + minimun + " and " + maximum);
		}
		return userinput;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int ratingOfSong=0, ratingOfEncoding=0, overallRating=0;

		IO.display(displaySignature());
		
		IO.display("this program will ask for the name of the song and  teh rating of the encoding\nBased of this "
				+ "the program will calulate the overall rating");
		
		ratingOfSong = IO.readInt("What is the rating of the song?");
		checkInteger(ratingOfEncoding, 0, 10);
		
		ratingOfEncoding = IO.readInt("what is the rating of the encoding");
		checkInteger(ratingOfEncoding, 0, 10);
		IO.display("the overall rating of teh song is " + computeMP3Rating(ratingOfSong, ratingOfEncoding));
		

	}

}
