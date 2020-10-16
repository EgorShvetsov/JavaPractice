public class UsersArrayList implements UsersList {

	private User[] usersList;

	private int numberOfUsers;

	public UsersArrayList() {
		this.usersList = new User[10];
		this.numberOfUsers = 0;
	}

	@Override
	public void addUser(final String name, final int balance) {

		User user = new User(name, balance);

		if (numberOfUsers == usersList.length) {
			increaseUserListByHalf();
		}

		usersList[numberOfUsers] = user;

		numberOfUsers++;
	}

	@Override
	public User getUserById(final int id)  {
		for (int i = 0; i < numberOfUsers; i++) {
			if (usersList[i].getId() == id) {
				return usersList[i];
			}
		}
		throw new UserNotFoundException("User with ID " + id + " does not exists!");
	}

	@Override
	public User getUserByIndex(final int index) {
		if (index >= numberOfUsers || usersList[index] == null) {
			throw new UserNotFoundException("User with index " + index + " does not exists!");
		}
		return usersList[index];
	}

	private void increaseUserListByHalf() {

		int newLength = (int)(usersList.length * 1.5);

		User[] newUserList = new User[newLength];

		for (int i = 0; i < usersList.length; i++) {
			newUserList[i] = usersList[i];
		}

		usersList = newUserList;
	}

	@Override
	public int getNumberOfUsers() {
		return numberOfUsers;
	}
}
