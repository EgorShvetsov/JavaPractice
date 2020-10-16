public class Program {

	public static void main(String[] args)
	{
		User u1 = new User("AAA", 1000);
		User u2 = new User("BBB", 2000);

		System.out.println(u1.getName() + " has ID " + u1.getId() + " and owns " + u1.getBalance());
		System.out.println(u2.getName() + " has ID " + u2.getId() + " and owns " + u2.getBalance());

	}
}