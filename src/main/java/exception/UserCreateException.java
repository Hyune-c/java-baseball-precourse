package exception;

public class UserCreateException extends IllegalArgumentException {

	private static final String MESSAGE = "유효하지 않은 User 생성입니다.";

	public UserCreateException() {
		super(MESSAGE);
	}
}
