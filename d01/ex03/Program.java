public class Program {

	public static void main(String[] args)
	{
		User u1 = new User("AAA", 1000);
		User u2 = new User("BBB", 2000);

		Transaction tr1 = new Transaction(u1, u2, TransactionCategory.DEBIT, 100);
		Transaction tr2 = new Transaction(u1, u2, TransactionCategory.CREDIT, -1000);
		Transaction tr3 = new Transaction(u2, u1, TransactionCategory.DEBIT, 3);

		String tr2Id = tr2.getIdentifier();


		u1.getTransactionsList().addTransaction(tr1);
		u1.getTransactionsList().addTransaction(tr2);
		u1.getTransactionsList().addTransaction(tr3);

		u2.getTransactionsList().addTransaction(tr1);
		u2.getTransactionsList().addTransaction(tr2);
		u2.getTransactionsList().addTransaction(tr3);

		System.out.println("User " + u1.getName() + " has " + u1.getTransactionsList().transactionsNodesCount + " transactions");
		TransactionNode tmp = u1.getTransactionsList().first;
		while (tmp != null) {
			System.out.println(tmp.getTransaction().getSender().getName() + " - " + tmp.getTransaction().getRecipient().getName()
								+ " " + tmp.getTransaction().getCategory() + " " + tmp.getTransaction().getTransactionAmount());
			tmp = tmp.next;
		}

		System.out.println("User " + u2.getName() + " has " + u2.getTransactionsList().transactionsNodesCount + " transactions");
		tmp = u2.getTransactionsList().first;
		while (tmp != null) {
			System.out.println(tmp.getTransaction().getSender().getName() + " - " + tmp.getTransaction().getRecipient().getName()
					+ " " + tmp.getTransaction().getCategory() + " " + tmp.getTransaction().getTransactionAmount());
			tmp = tmp.next;
		}

		u1.getTransactionsList().removeTransactionById(tr2Id);

		System.out.println("User " + u1.getName() + " has " + u1.getTransactionsList().transactionsNodesCount + " transactions");
		tmp = u1.getTransactionsList().first;
		while (tmp != null) {
			System.out.println(tmp.getTransaction().getSender().getName() + " - " + tmp.getTransaction().getRecipient().getName()
					+ " " + tmp.getTransaction().getCategory() + " " + tmp.getTransaction().getTransactionAmount());
			tmp = tmp.next;
		}

		Transaction[] transactionsArr = u2.getTransactionsList().transactionsListToArrayTransformer();
		for (int i = 0; i < transactionsArr.length; i++) {
			System.out.println(transactionsArr[i].getIdentifier());
		}

		u1.getTransactionsList().removeTransactionById("Some ID");


	}
}
