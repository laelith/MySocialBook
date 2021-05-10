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
	public void addUser() throws IOException, ParseException {
		ArrayList<User> userList = Helper.fetchUsers();
		File file = new File("C:\\Users\\merve\\commands.txt");
		Scanner sc = new Scanner(file);
		String[] addedUser = sc.nextLine().split("\t");
		String name = addedUser[1] ;
		String username = addedUser[2];
		String password = addedUser[3];
		SimpleDateFormat dateofBirth = new SimpleDateFormat("MM/dd/yyyy");
		Date convertedDateofBirth = dateofBirth.parse(addedUser[4]);
		String graduatedSchool = (addedUser[5]);
		User newUser = new User(name, username, password, convertedDateofBirth, graduatedSchool);
		userList.add(newUser);
	}

	// Removes existing user
	public void removeUser() {
		
	}

	// Lists users
	public void listUsers() {
		
	}
}
