public class TransactionNode {

	private Transaction transaction;
	TransactionNode next;

	public TransactionNode(final Transaction transaction) {
		this.transaction = transaction;
		next = null;
	}

	public Transaction getTransaction() {
		return transaction;
	}
}
