package ie.gmit.dip;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class FrequencyTable {

	public void frequencyTable(List<String> text) throws Exception {

		HashMap<String, Integer> frequency = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		int i = 0;
		String key = null;

		/**
		 * Adds ArrayList words to the HashMap, increments value if word is already
		 * contained in the map. If not adds the key and sets value to 1. Running Time:
		 * O(n)
		 */
		for (i = 0; i < text.size(); i++) {

			key = text.get(i).toUpperCase();

			if (frequency.containsKey(key)) {
				frequency.put(key, frequency.get(key) + 1);
			} else {
				frequency.put(key, 1);
			}
		}

		/** 
		 * Put values from the hashmap into a LinkedList to be sorted Running Time O(n)
		 */
		List<Integer> values = new LinkedList<Integer>(frequency.values());

		/**  
		 * Sorts the list of values by order of value, lowest element first. Running time O(n^2)
		 */
		Collections.sort(values, new Comparator<Integer>() {
			
			public int compare(Integer int1, Integer int2) {
				return int1.compareTo(int2);
			}
		});

		/**  
		 * Puts values from the LinkedList into a LinkedHashSet, and then into an
		 * ArrayList: Removes duplicate values and keeps order. Running Time O(2n)
		 */
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(values);
		ArrayList<Integer> valuesNoDuplicates = new ArrayList<>(hashSet);

		System.out.println("Enter the maximum number of words you would like to display:");
		Menu.maxWords = sc.nextInt();

		System.out.println("Enter the name of the image:(don't include .png)");
		Menu.imageName = sc.next();
		Menu.imageName += ".png";

		WordCloudGenerator wcg = new WordCloudGenerator();
		wcg.generator(frequency, valuesNoDuplicates);
	}

	/**	 
	 * Returns the key from the HashMap from a given value. Running Time: O(n)
	 */
	public <K, V> K getKey(Map<K, V> map, V value) {
		for (Entry<K, V> entry : map.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}
}