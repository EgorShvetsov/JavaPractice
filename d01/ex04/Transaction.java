import java.util.UUID;

public class Transaction {

	private final String identifier;

	private final User recipient;

	private final User sender;

	private final TransactionCategory category;

	private final int transactionAmount;

	private Transaction pair;

	public Transaction(User recipient,
					   User sender,
					   TransactionCategory category,
					   int transactionAmount) {
		this.identifier = UUID.randomUUID().toString();
		this.recipient = recipient;
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
		this.pair = null;
	}

	public Transaction(final Transaction currentTransaction) {
		this.identifier = currentTransaction.getIdentifier();
		this.recipient = currentTransaction.getSender();
		this.sender = currentTransaction.getRecipient();
		this.transactionAmount = currentTransaction.getTransactionAmount() * -1;
		if (currentTransaction.getCategory() == TransactionCategory.DEBIT) {
			this.category = TransactionCategory.CREDIT;
		}
		else {
			this.category = TransactionCategory.DEBIT;
		}
		this.pair = currentTransaction;
		currentTransaction.setPair(this);
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

	public Transaction getPair() {
		return pair;
	}

	public void setPair(Transaction pair) {
		this.pair = pair;
	}
}
