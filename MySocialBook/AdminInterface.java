// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class AdminInterface {

	// Adds non existing user
	// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
	public static ArrayList<User> addUser(ArrayList<User> userList, String userName, String name, String password, Date dateofBirth, String schoolGraduate) throws IOException, ParseException {
		// checks if user exists in list
		for (User singleUser : userList) {
			if (singleUser.getUserName().equals(userName)) {
				System.out.println("This user already exists.");
				return null;
			}
			// adds user
			User newUser = new User(userName, name, password, dateofBirth, schoolGraduate);
			userList.add(newUser);
		}
		// returns user list
		return userList;
	}

	// Removes existing user
	// REMOVEUSER<TAB>userID
	public static ArrayList<User> removeUser (ArrayList <User> userList, Integer userID) {
		// checks if user exists
		for (User singleUser : userList) {
			if (singleUser.getUserName().equals(userID)){
				// removes
				userList.remove(singleUser);
			}
		}
		return userList;
	}

	// List Users: Users should be able to view all users in the system.
	public static void listUsers(ArrayList <User> userList){
		// print users
		for (User singleUser : userList){
			System.out.println("Name  : " + singleUser.getName());
			System.out.println("UserName  : " + singleUser.getUserName());
			System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
			System.out.println("School  : " + singleUser.getGraduatedSchool());
			System.out.println("----------------------------------------------");
		}
	}


}