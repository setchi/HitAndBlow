package jp.setchi.HitAndBlow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	private static final int NUMBER_OF_DIGITS = 4;
	
	public static void main(String[] args) {
		String expectedAnswer = new RandomNumericStringGenerator()
				.generate(NUMBER_OF_DIGITS);
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			for (int countPlay = 1; ; countPlay++) {
				
				System.out.println(NUMBER_OF_DIGITS + "桁の数値を入力してください。(" + countPlay + "回目)");
				String answer = scanner.next();
				
				if (answer.length() != NUMBER_OF_DIGITS) {
					System.out.println("入力が" + NUMBER_OF_DIGITS + "桁ではありません。");
					continue;
				}
				
				if (!answer.matches("\\d+")) {
					System.out.println("入力は数値のみです。");
					continue;
				}
				
				if (isDuplicated(answer)) {
					System.out.println("入力に重複があります。");
					continue;
				}
				
				HitAndBlow hitAndBlow = new HitAndBlow(answer, expectedAnswer);
				System.out.println("ヒット：" + hitAndBlow.getHits() +  ", ブロウ：" + hitAndBlow.getBlows());
				
				if (answer.equals(expectedAnswer)) {
					System.out.println(countPlay + "回目でクリア！");
					System.out.println("おめでとうございます！");
					break;
				}
			}
		}
	}
	
	private static Boolean isDuplicated(String answer) {
		Set<Character> existedCharacters = new HashSet<>();
		
		for (char c : answer.toCharArray()) {
			if (existedCharacters.contains(c)) {
				return true;
			}
			
			existedCharacters.add(c);
		}

		return false;
	}
}
