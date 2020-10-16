public interface UsersList {

	void addUser(final String name, final int balance);

	User getUserById(final int id) throws UserNotFoundException;

	User getUserByIndex(final int index) throws UserNotFoundException;

	int getNumberOfUsers();
}
