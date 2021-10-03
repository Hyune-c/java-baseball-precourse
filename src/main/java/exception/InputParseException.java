package exception;

public class InputParseException extends IllegalArgumentException {

	private static final String MESSAGE = "[ERROR] 다시 입력해주세요.";

	public InputParseException() {
		super(MESSAGE);
	}
}
