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

	public String generateMessage(final int count) {
		return (count == 0)
			? ""
			: count + this.getDescription() + " ";
	}

	public String getDescription() {
		return description;
	}
}
