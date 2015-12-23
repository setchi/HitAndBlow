package jp.setchi.HitAndBlow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class StringUtility {
	
	private StringUtility() {}
	
	public static Boolean isDistinct(String str) {
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
		if (digits < 0 || 10 < digits) {
			throw new IllegalArgumentException("Œ…”‚Í0~10‚Ì”ÍˆÍ‚Åw’è‚µ‚Ä‚­‚¾‚³‚¢: " + digits);
		}
		
		final LinkedList<Integer> unusedNumbers = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			unusedNumbers.add(i);
		}
		
		final char[] result = new char[digits];
		final Random random = new Random();
		
		for (int i = 0; i < digits; i++) {
			int number = unusedNumbers.remove(random.nextInt(unusedNumbers.size()));
			result[i] = (char)('0' + number);
		}
		
		return String.valueOf(result);
	}
}
