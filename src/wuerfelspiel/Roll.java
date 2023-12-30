package wuerfelspiel;

import java.util.ArrayList;
import java.util.List;

public class Roll {
	List<Integer> numbers;
	
	public Roll() {
		numbers  = new ArrayList<Integer>();
	}

	public Roll(String s) {
		this();
		for (int i = 0; i < s.length(); i++) {
			numbers.add(Integer.valueOf(s.substring(i, i + 1)));
		}
	}
	
	public void append(int i) {
		numbers.add(i);
	}

	public String toString() {
		String s = "";
		for (int i : numbers) {
			s += i;
		}
		return s;
	}

	public int countSide(int i) {
		int howMany = 0;
		for (int number : numbers) {
			if (number == i) {
				howMany++;
			}
		}
		return howMany;
	}

	public int getValue() {
		int value = 0;
		for (int i = 1 ; i <= 6; i++) {
			int howMany = this.countSide(i);
			int factor = (i == 1) ? 10 : i;
			if (howMany == 6) {
				value += factor * 1000;
				howMany = 0;
			}
			if (howMany >= 3) {
				value += factor * 100;
				howMany = howMany - 3;
			}
			if (i == 1 || i == 5) {
				value += factor * 10 * howMany;
			}
		}
		return value;
	}
}
