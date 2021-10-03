package type;

public enum PitchingResultType {

	STRIKE("스트라이크"),
	BALL("볼"),
	OUT("아웃"),
	;

	private final String description;

	PitchingResultType(final String description) {
		this.description = description;
	}

	public String message(final int count) {
		if (count == 0) {
			return "";
		}

		return count + this.description + " ";
	}
}
