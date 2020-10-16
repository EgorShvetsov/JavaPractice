public class UserIdsGenerator {

	private static UserIdsGenerator INSTANCE;

	private int id;

	private UserIdsGenerator() {}

	public static UserIdsGenerator getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserIdsGenerator();
			INSTANCE.id = 0;
		}
		return INSTANCE;
	}

	public static int generateId() {
		return ++INSTANCE.id;
	}
}
