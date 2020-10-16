public class TransactionsList implements TransactionsListInterface {

	TransactionNode first;

	TransactionNode last;

	int transactionsNodesCount;

	public TransactionsList() {
		this.first = null;
		this.last = null;
		transactionsNodesCount = 0;
	}

	@Override
	public void addTransaction(Transaction transaction) {

		TransactionNode newNode = new TransactionNode(transaction);

		if (this.first == null) {
			this.first = newNode;
		}
		else {
			this.last.next = newNode;
		}

		this.last = newNode;

		this.transactionsNodesCount++;
	}

	@Override
	public void removeTransactionById(final String transactionId) {

		TransactionNode tmp = this.first;

		TransactionNode tmpPrev;

		Transaction pairToNull;

		while (tmp.next != null) {

			if (tmp.getTransaction().getIdentifier().equals(transactionId)) {
				if (tmp == this.first) {
					tmp = tmp.next;
					pairToNull = this.first.getTransaction().getPair();
					if (pairToNull != null) {
						pairToNull.setPair(null);
					}
					this.first = tmp;
					this.transactionsNodesCount--;
				}
				else {
					pairToNull = tmp.getTransaction().getPair();
					if (pairToNull != null) {
						pairToNull.setPair(null);
					}
					tmpPrev = tmp.next;
					this.transactionsNodesCount--;
					return;
				}
			}

			tmpPrev = tmp;
			tmp = tmp.next;
		}

		if (tmp != null && tmp.getTransaction().getIdentifier().equals(transactionId)) {
			pairToNull = tmp.getTransaction().getPair();
			if (pairToNull != null) {
				pairToNull.setPair(null);
				tmpPrev = tmp.next;
				this.transactionsNodesCount--;
				return;
			}

		}

		throw new TransactionNotFoundException("Transaction with ID " + "\"" + transactionId + "\"" + " has not found!");
	}

	@Override
	public Transaction[] transactionsListToArrayTransformer() {

		Transaction[] result = new Transaction[this.transactionsNodesCount];

		TransactionNode tmp = this.first;

		int iterator = 0;

		while (tmp != null) {
			result[iterator++] = tmp.getTransaction();
			tmp = tmp.next;
		}

		return result;
	}

}
