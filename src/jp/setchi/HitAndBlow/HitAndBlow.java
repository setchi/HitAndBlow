package jp.setchi.HitAndBlow;

public class HitAndBlow {

	private final int hits;
	private final int blows;
	
	public HitAndBlow(String answerA, String answerB) {
		if (answerA == null) {
			throw new IllegalArgumentException("answerAがnullです。");
		}
		
		if (answerB == null) {
			throw new IllegalArgumentException("answerBがnullです。");
		}
		
		if (answerA.length() != answerB.length()) {
			throw new IllegalArgumentException(
					"answerAとanswerBの桁数が違います。answerA: " + answerA + ", answerB: " + answerB);
		}
		
		int countHits = 0;
		int countBlows = 0;
		int digits = answerA.length();
		
		for (int i = 0; i < digits; i++) {
			if (answerA.charAt(i) == answerB.charAt(i)) {
				countHits++;
				continue;
			}
			
			for (int j = 0; j < digits; j++) {
				if (answerA.charAt(i) == answerB.charAt(j)) {
					countBlows++;
				}
			}
		}
		
		hits = countHits;
		blows = countBlows;
	}
	
	public int getHits() { return hits; }
	public int getBlows() { return blows; }
}
