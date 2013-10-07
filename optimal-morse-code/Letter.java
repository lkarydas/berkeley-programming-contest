/**
 * A simple class that stores a character and a frequency.
 * @author Lazaros Karydas
 *
 */
public class Letter implements Comparable<Letter>{

	public char letter;
	public int frequency;
	
	Letter(char letter, int frequency) {
		this.letter = letter;
		this.frequency = frequency;
	}
	
	@Override
	public int compareTo(Letter other) {
		return other.frequency - this.frequency;
	}
	
	@Override
	public String toString() {
		return "<" + letter + ", " + frequency + ">";
	}
}