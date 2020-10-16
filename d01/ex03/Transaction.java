import java.util.UUID;

public class Transaction {

	private final String identifier;

	private final User recipient;

	private final User sender;

	private final TransactionCategory category;

	private final int transactionAmount;

	public Transaction(User ecipient,
					   User sender,
					   TransactionCategory category,
					   int transactionAmount) {
		this.identifier = UUID.randomUUID().toString();
		this.recipient = ecipient;
		this.sender = sender;
		this.category = category;
		if (category == TransactionCategory.DEBIT && transactionAmount < 0) {
			System.out.println("We are newbies bank, our DEBIT operation can`t be negative. Transaction amount set to 0");
			this.transactionAmount = 0;
		}
		else if (category == TransactionCategory.CREDIT && transactionAmount > 0) {
			System.out.println("We are newbies bank, our CREDIT operation can`t be positive. Transaction amount set to 0");
			this.transactionAmount = 0;
		}
		else {
			this.transactionAmount = transactionAmount;
		}
	}

	public String getIdentifier() {
		return identifier;
	}

	public User getRecipient() {
		return recipient;
	}

	public User getSender() {
		return sender;
	}

	public TransactionCategory getCategory() {
		return category;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}
}
