public class TransactionsService {

	UsersArrayList usersList;

	public TransactionsService() {
		usersList = new UsersArrayList();
	}

	public void addUser(final String name, final int balance) {
		usersList.addUser(name, balance);
	}

	public int getUsersBalance(final int userId) {
		return this.usersList.getUserById(userId).getBalance();
	}


	public void performTransaction(final int userIdFirst, final int userIdSecond, final int amount) {

		if (userIdFirst == userIdSecond) {
			throw new IllegalTransactionException("Transaction between users with the same ID (one ID for one user) is prohibited!");
		}

		User first = this.usersList.getUserById(userIdFirst);

		User second = this.usersList.getUserById(userIdSecond);

		if (amount < 0) {
			throw new IllegalTransactionException("Transaction amount should not be negative");
		}

		if (amount > second.getBalance()) {
			throw new IllegalTransactionException("Attempt to make a transfer of the amount exceeding user’s residual balance.\n" +
					"User " + second.getName() + " has " + second.getBalance() + ", transaction amount " + amount);
		}

		Transaction transaction = new Transaction(first, second, TransactionCategory.DEBIT, amount);

		first.getTransactionsList().addTransaction(transaction);

		second.getTransactionsList().addTransaction(new Transaction(transaction));

		first.setBalance(amount);

		second.setBalance(-amount);
	}


	public Transaction[] getTransactionsArrayForUserById(final int id) {
		return usersList.getUserById(id).getTransactionsList().transactionsListToArrayTransformer();
	}

	public void removeTransactionFromUserByIds(final int userId, final String transactionId) {
		usersList.getUserById(userId).getTransactionsList().removeTransactionById(transactionId);
	}

	public Transaction[] unpairedTransactions() {

		TransactionsList transactionsList = new TransactionsList();

		TransactionNode tmp;

		for (int i = 0; i < usersList.getNumberOfUsers(); i++) {
			tmp = usersList.getUserByIndex(i).getTransactionsList().first;
			while (tmp != null) {
				if (tmp.getTransaction().getPair() == null) {
					transactionsList.addTransaction(tmp.getTransaction());
				}
				tmp = tmp.next;
			}
		}

		return transactionsList.transactionsListToArrayTransformer();
	}

}
