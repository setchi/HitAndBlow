package jp.setchi.HitAndBlow;

import java.util.Scanner;

public class Main {
	
	private static final int NUMBER_OF_DIGITS = 4;
	
	public static void main(String[] args) {
		final String expectedAnswer = StringUtility.generateDistinctRandomNumeric(NUMBER_OF_DIGITS);
		
		try (Scanner scanner = new Scanner(System.in)) {
			
			for (int countPlay = 1; ; countPlay++) {
				
				System.out.println(NUMBER_OF_DIGITS + "桁の数値を入力してください。(" + countPlay + "回目)");
				final String answer = scanner.next();
				
				if (answer.length() != NUMBER_OF_DIGITS) {
					System.out.println("入力が" + NUMBER_OF_DIGITS + "桁ではありません。");
					continue;
				}
				
				if (!answer.matches("\\d+")) {
					System.out.println("入力は数値のみです。");
					continue;
				}
				
				if (!StringUtility.isDistinct(answer)) {
					System.out.println("入力に重複があります。");
					continue;
				}
				
				final HitAndBlow hitAndBlow = new HitAndBlow(answer, expectedAnswer);
				System.out.println("ヒット：" + hitAndBlow.getHits() +  ", ブロウ：" + hitAndBlow.getBlows());
				
				if (answer.equals(expectedAnswer)) {
					System.out.println(countPlay + "回目でクリア！");
					System.out.println("おめでとうございます！");
					break;
				}
			}
		}
	}
}
