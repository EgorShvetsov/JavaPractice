import java.util.UUID;

public class User {

	final private int identifier;

	final private String name;

	private int balance;

	public User(final int identifier, final String name, final int balance) {
		this.identifier = identifier;
		this.name = name;
		if (balance < 0) {
			System.out.println("We are not collectors. Inviting new users with negative balance is not our business model.\n" +
					"Lets imagine, that our new client has no debts. So...\n" +
					"User`s start balance set to 0");
			this.balance = 0;
		}
		else {
			this.balance = balance;
		}

	}

	public int getIdentifier() {
		return identifier;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
}
