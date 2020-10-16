public class Program {

	public static void main(String[] args) {

		UsersArrayList usersList = new UsersArrayList();

		usersList.addUser("AAA", 1000);
		usersList.addUser("BBB", 2000);


		System.out.println("User " + usersList.getUserByIndex(0).getName() + " has id " + usersList.getUserById(1).getId());
		System.out.println("User " + usersList.getUserByIndex(1).getName() + " has id " + usersList.getUserById(2).getId());


		System.out.println("Number of users in userList is " + usersList.getNumberOfUsers());

		System.out.println("User " + usersList.getUserByIndex(3).getName() + " has id " + usersList.getUserById(3).getId());

	}
}
