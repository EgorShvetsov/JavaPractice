public class Program {

	public static void main(String[] args) {

		User u1 = new User(1, "AAA", 1000);
		User u2 = new User(2, "BBB", 2000);

		System.out.println(u1.getName() + " has ID " + u1.getIdentifier() + " and owns " + u1.getBalance());
		System.out.println(u2.getName() + " has ID " + u2.getIdentifier() + " and owns " + u2.getBalance());


		Transaction transaction = new Transaction(u1, u2, TransactionCategory.DEBIT, 500);

		System.out.println("Transaction between " + transaction.getRecipient().getName() + " and "
							+ transaction.getSender().getName() + ".\n"
							+ "ID: " + transaction.getIdentifier() + "\n"
							+ "Type: " + transaction.getCategory()  + "\n"
							+ "Value: " + transaction.getTransactionAmount());
	}
}

enum TransactionCategory {
	DEBIT, CREDIT;
}
