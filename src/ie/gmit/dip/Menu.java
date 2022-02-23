package ie.gmit.dip;

import java.util.*;
import java.io.*;
import java.net.*;

public class Menu {

	private boolean keeprunning = true;
	static String imageName;
	static int maxWords;

	/**
	 * Shows the menu options.
	 * */
	public void showOptions() throws Exception {

		Scanner sc = new Scanner(System.in);

		int choice;
		File TEXT_FILE;
		URL URL_FILE;
		String file, url;
		char fileOrURL;

		FileReader f = new FileReader();
		UrlReader u = new UrlReader();

		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           WordCloud Generator V1.0              *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println("1) Enter a file name or URL");
		System.out.println("2) Enter Maximum Words in The Cloud");
		System.out.println("3) Enter Output File Name");
		System.out.println("4) Quit");
		System.out.println("\n Press 1 and follow the steps \nor press 4 + Enter for exit");

		choice = sc.nextInt();
		while (keeprunning) {
			if (choice == 1) {
				System.out.println("Press F for reading a file or U for reading a URL:");
				fileOrURL = sc.next().toUpperCase().charAt(0);
				if (fileOrURL == 'F') {
					System.out.println("Enter File name:");
					file = sc.next();
					TEXT_FILE = new File(file);
					// Passes fileReader the file name.
					f.Parser(TEXT_FILE);
				} else if (fileOrURL == 'U') {
					System.out.println("Enter URL:");
					url = sc.next();
					URL_FILE = new URL(url);
					// Passes urlReader the URL name.
					u.Parser(URL_FILE);
				} else {
					System.out.println("Invalid choice! Please try again!");
				}
			} else if (choice == 2) {
				System.out.println("Enter Maximum Words in The Cloud:");
				maxWords = sc.nextInt();
			} else if (choice == 3) {
				System.out.println("Enter Output File Name:");
				imageName = sc.next();
				imageName += ".png";
			} else if (choice == 4) {
				keeprunning = false;
				System.out.println("Shutting down...Please wait..");
			} else {
				System.out.println("\nInvalid choice! Please try again!");
				System.out.println("1) Enter a file name or URL");
				System.out.println("2) Enter Maximum Words in The Cloud");
				System.out.println("3) Enter Output File Name");
				System.out.println("4) Quit");
				System.out.println("\n Press 1 and follow the steps \nor press 4 + Enter for exit");
			}
			choice = sc.nextInt();

		}
		sc.close();
	}
}