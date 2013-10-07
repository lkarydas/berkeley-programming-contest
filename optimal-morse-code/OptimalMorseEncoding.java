import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OptimalMorseEncoding {

	ArrayList<Letter> sortedLetters;
	int spaceCount;

	int calculateTransmitionTime(String msg) {
		// Calculate the frequency of each letter, count white spaces and sort letters by frequency.
		calculateHistogram(msg);
		int uniqueLetterCount = sortedLetters.size();
		// Sum the cost of each letter.
		int sum = sumLetterCosts(uniqueLetterCount);
		// Calculate the 'between letters' cost.
		int betweenLetters = msg.length() - 2 * spaceCount - 1;
		// Sum everything.
		return sum + betweenLetters * 3 + spaceCount * 7;
	}
	
	private void calculateHistogram(String msg) {
		// This hash table is used to count the frequency of each character in the string.
		HashMap<Character, Integer> frequencyTable = new HashMap<Character, Integer>();
		// Populate the character histogram.
		char tmpChar;
		int tmpFreq;
		spaceCount = 0;
		for (int i = 0; i < msg.length(); i++) {
			tmpChar = msg.charAt(i);
			if (tmpChar == ' ') {
				// Count white spaces separately.
				spaceCount++;
				continue;
			}
			if (frequencyTable.get(tmpChar) == null) {
				frequencyTable.put(tmpChar, 1);
			} else {
				tmpFreq = (frequencyTable.get(tmpChar));
				frequencyTable.put(tmpChar, ++tmpFreq);
			}
		}
		// Now add the letters to an array list.
		sortedLetters = new ArrayList<Letter>();
		Letter tmp;
		for (Character key : frequencyTable.keySet()) {
			tmp = new Letter(key, frequencyTable.get(key));
			sortedLetters.add(tmp);
		}
		// And sort them by frequency.
		Collections.sort(sortedLetters);
	}
	
	int sumLetterCosts(int numbers) {
		int sum = 0;
		int encodingLength = 1;
		int tmp;
		int counter = 0;

		int n1 = 0, n2 = 1, n3 = 0;
		while (counter < numbers) {
			// Find the next Fibonacci number.
			n3 = n1 + n2;
			tmp = n3;
			// Sum...
			while ((tmp > 0) && (counter < numbers)) {
				sum += encodingLength * sortedLetters.get(counter).frequency;
				tmp--;
				counter++;
			}
			encodingLength += 2;
			// Update n1 and n2 in order to calculate the next Fibonacci number.
			n1 = n2;
			n2 = n3;
		}
		return sum;
	}
}