package ie.gmit.dip;

import java.io.*;
import java.net.*;
import java.util.*;

public class UrlReader {
	List<String> text = new ArrayList<String>();
	List<String> ignoreWords = new ArrayList<String>();
	File IGNORE_FILE = new File("ignorewords.txt");
	
	public void Parser(URL URL_FILE) throws Exception {
		
		Scanner input = new Scanner(new InputStreamReader(URL_FILE.openStream()));
		Scanner ignore = new Scanner(IGNORE_FILE);
		input.useDelimiter("[^A-Za-z']+");
		int i = 0;
		String word;
		
		/**  
		 * Parses URL contents and adds it to each ArrayList
		 *  Running Time: O(2n)
		 */

		while(ignore.hasNextLine()) {
			ignoreWords.add(ignore.next());
		}
		while(input.hasNext()) {
			text.add(input.next());
		}
		
		/**
		 *  Finds words in text list that must be removed, because they are included in the ignoreWords list.
		 *  Running Time: O(n^2)
		 */
		 
		while(i < text.size()) {
			word = text.get(i).toLowerCase();
			if(ignoreWords.contains(word)) {
				text.remove(i);
			}
				i++;
		}
		
		FrequencyTable ft = new FrequencyTable();
		ft.frequencyTable(text);
		
		input.close();
		ignore.close();
	}
}