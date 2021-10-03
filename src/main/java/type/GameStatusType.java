package type;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum GameStatusType {

	RESTART(1, true),
	END(2, false),
	;

	private final int flag;
	private final boolean restart;

	GameStatusType(final int flag, final boolean restart) {
		this.flag = flag;
		this.restart = restart;
	}

	private static final Map<GameStatusType, Integer> map = new EnumMap<>(GameStatusType.class);

	static {
		Arrays.stream(GameStatusType.values())
			.forEach(e -> map.put(e, e.flag));
	}

	public static GameStatusType findByFlag(final int flag) {
		return map.entrySet().stream()
			.filter(val -> val.getValue().equals(flag))
			.map(Map.Entry::getKey)
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public boolean isRestart() {
		return restart;
	}
}
