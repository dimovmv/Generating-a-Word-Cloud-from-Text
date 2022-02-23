package ie.gmit.dip;

public class Runner {
	/**
	 * This is a command line menu - driven Java application for creating a Word Cloud (in PNG format) from text, 
	 * taken from a file or from URL.
	 * The application process text files from File or URL and generates a word cloud, that contain the most common words in the text, 
	 * but does not include word, that are part of ignorewords.txt file.
	 * @author Dimo Dimov
	 * @version 1.0
	 * */
	
	/**
	 * Starts the application
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Menu m = new Menu();
		m.showOptions();

	}
}
//I have used this URL to test the application: https://www.gutenberg.org/files/3207/3207-0.txt