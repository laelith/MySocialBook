// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminInterface {

	// Adds non existing user
	// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
	public void AddUser() throws IOException, ParseException {
		ArrayList<User> userList = Helper.FetchUsers();
		BufferedReader csvReader = new BufferedReader(new InputStreamReader(System.in));
		String row = csvReader.readLine();
		String[] data = row.split("\t");
		String name = data[0];
		String username = data[1];
		String password = data[2];
		Date convertedDateofBirth = new SimpleDateFormat("MM/dd/yyyy").parse(data[3]);
		String graduatedSchool = data[4];
		User newUser = new User(name, username, password, convertedDateofBirth, graduatedSchool);
		userList.add(newUser);
	}

	// Removes existing user
	public void RemoveUser() {
		
	}
	// Lists users
	public void ListUsers() {
		
	}
}
