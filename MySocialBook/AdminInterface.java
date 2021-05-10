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
	public static ArrayList<User> addUser(ArrayList<User>  userList, String userName, String name, String password, String dateofBirth, String schoolGraduate) throws IOException, ParseException {
		// check if user exists in list
		for (int i=0; i<userList.size(); i++){
			if (userList[i].getUserName == userName ) {
				System.out.println();
			}
		}
		// do data validation
		
		// add user
		
		// return user list
		return userList;
	}

	// Removes existing user
	public static ArrayList<User> removeUser(ArrayList<User>  userList) {
		// check if user exists
		
		// remove
		
		return userList;
	}

	// Lists users
	public static void listUsers(ArrayList<User>  userList) {
		// print users
	}
}
