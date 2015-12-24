package jp.setchi.HitAndBlow;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtility {
	
	private StringUtility() {}
	
	public static Boolean isDistinctChars(String str) {
		if (str == null) {
			throw new IllegalArgumentException("ˆø”‚ªnull‚Å‚·B");
		}
		
		final Set<Character> existedCharacters = new HashSet<>();
		
		for (char c : str.toCharArray()) {
			if (existedCharacters.contains(c)) {
				return false;
			}
			existedCharacters.add(c);
		}
		
		return true;
	}
	
	public static String generateDistinctRandomNumeric(int digits) {
		final List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		if (digits < 0 || numbers.size() < digits) {
			throw new IllegalArgumentException(
					"Œ…”‚Í0~" + numbers.size() + "‚Ì”ÍˆÍ‚Åw’è‚µ‚Ä‚­‚¾‚³‚¢: " + digits);
		}
		
		Collections.shuffle(numbers);
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int number : numbers.subList(0, digits)) {
			stringBuilder.append(number);
		}
		
		return stringBuilder.toString();
	}
}
