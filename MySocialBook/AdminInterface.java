// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class AdminInterface {

	// Adds non existing user
	// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
	public static ArrayList<User> addUser(ArrayList<User>  userList, String userName, String name, String password, Date dateofBirth, String schoolGraduate) throws IOException, ParseException{

		// checks if user exists in list
		for (User singleUser : userList) {
			if (singleUser.getUserName().equals(userName)) {
				System.out.println("This user already exists.");
				return null;
			}
		// adds user
		userList.add(new User (userName, name, password, dateofBirth, schoolGraduate));
		// returns user list
		return userList;
	}

	// Removes existing user
	public static ArrayList<User> removeUser(ArrayList<User> userList){
		// checks if user exists
		for (User singleUser : userList) {
			if (singleUser.getUserName().equals(userName)) {
				// removes
				userList.remove(singleUser);
			}
		return userList;
	}

	// Lists users
	public static void listUsers(ArrayList<User>  userList) {
		// print users
	}
}
