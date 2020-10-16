public class User {

	final private int id;

	final private String name;

	private int balance;

	private TransactionsList transactionsList;

	public User(final String name, final int balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		transactionsList = new TransactionsList();
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

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public TransactionsList getTransactionsList() {
		return transactionsList;
	}

	public void setBalance(int balance) {
		this.balance += balance;
	}
}
