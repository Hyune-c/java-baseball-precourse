package exception;

public class PlayerCreateException extends IllegalArgumentException {

	private static final String MESSAGE = "유효하지 않은 선수 생성입니다.";

	public PlayerCreateException() {
		super(MESSAGE);
	}
}
