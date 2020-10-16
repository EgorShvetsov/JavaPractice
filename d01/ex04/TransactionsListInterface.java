public interface TransactionsListInterface {

	public void addTransaction(Transaction transaction);

	public void removeTransactionById(final String transactionId) throws TransactionNotFoundException;

	public Transaction[] transactionsListToArrayTransformer();
}
