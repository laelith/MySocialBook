// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminInterface {

	// Adds non existing user
	// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
	public static void addUser(String userName, String name, String password, Date dateofBirth, String schoolGraduate) throws IOException, ParseException {
		// checks if user exists in list
		for (User singleUser : Helper.getUserList()) {
			if (singleUser.getUserName().equals(userName)){
				System.out.println("This user already exists.");
				return;
			}
		}
		User newUser = new User(userName, name, password, dateofBirth, schoolGraduate);
		Helper.getUserList().add(newUser);
	}

	// Removes existing user
	// REMOVEUSER<TAB>userID
	public static void removeUser (Integer userID) {
		// checks if user exists
		for (User singleUser : Helper.getUserList()) {
			if (singleUser.getUserID() == userID) {
				// removes
				Helper.getUserList().remove(singleUser);
				System.out.println("User has been successfully removed.");
				return;
			}
		}
		System.out.println("No such user!");
	}

	// List Users: Users should be able to view all users in the system.
	public static void listUsers(){
		// print users
		for (User singleUser : Helper.getUserList()){
			System.out.println("Name  : " + singleUser.getName());
			System.out.println("Username  : " + singleUser.getUserName());
			String pattern = "MM/dd/yyyy";
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			Date userBirthDay = singleUser.getDateOfBirth();
			String userBirthDayAsString = dateFormat.format(userBirthDay);
			System.out.println("Date Of Birth  : " + userBirthDayAsString);
			System.out.println("School  : " + singleUser.getGraduatedSchool());
			System.out.println("----------------------------------------------");
		}
	}


}