package jp.setchi.HitAndBlow;

import java.util.LinkedList;
import java.util.Random;

public class RandomNumericStringGenerator {
	
	public String generate(int digits) {
		if (digits < 0 || 10 < digits) {
			throw new IllegalArgumentException("������0~10�͈̔͂Ŏw�肵�Ă�������: " + digits);
		}
		
		LinkedList<Integer> unusedNumbers = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			unusedNumbers.add(i);
		}
		
		char[] result = new char[digits];
		Random random = new Random();
		
		for (int i = 0; i < digits; i++) {
			int number = unusedNumbers.remove(random.nextInt(unusedNumbers.size()));
			result[i] = (char)('0' + number);
		}
		
		return String.valueOf(result);
	}
}
