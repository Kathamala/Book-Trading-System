package Repository;

import java.util.ArrayList;

import Entity.User;

public class UserRepository {
	
	private static ArrayList<User> users;

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		UserRepository.users = users;
	}
}
