package input;

import java.util.List;
import java.util.Scanner;

import config.Property;
import type.Message;

public class InputService {

	private final Scanner scanner;
	private final ParseService parseService;

	public InputService(final ParseService parseService) {
		this.scanner = new Scanner(System.in);
		this.parseService = parseService;
	}

	public List<Integer> nextIntegerList(final String printString, final int size) {
		try {
			System.out.print(printString);
			return parseService.parse(scanner.nextLine(), size);
		} catch (final IllegalArgumentException ex) {
			System.out.println(Message.RETRY_INPUT);
			return nextIntegerList(printString, size);
		}
	}

	public int nextGameStatusTypeFlag(final String printString) {
		try {
			System.out.println(printString);
			return parseService.parse(scanner.nextLine(), Property.TYPE_FLAG_LENGTH).get(0);
		} catch (final IllegalArgumentException ex) {
			System.out.println(Message.RETRY_INPUT);
			return nextGameStatusTypeFlag(printString);
		}
	}
}
