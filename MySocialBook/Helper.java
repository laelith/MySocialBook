// Wraps up helper functions to operate main functionality
// 
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

public class Helper {

	private static ArrayList<User> userList = new ArrayList<User>();

		public final static String pathToCsv = "users.txt";
		// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
		public static void populateUsers() throws IOException, ParseException {
			BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
			String row = null;
			while ((row  = csvReader.readLine()) != null) {
				String[] data = row.split("\t");
				String name = data[0];
				String username = data[1];
				String password = data[2];
				SimpleDateFormat dateofBirth = new SimpleDateFormat("MM/dd/yyyy");
				Date convertedDateofBirth = dateofBirth.parse(data[3]);
				//String date = dateofBirth.format(convertedDateofBirth);
				//Trim method is used, because there were some white spaces before the school.
				String graduatedSchool = (data[4].trim());
				//This will be created objects of user class.
				User newUser = new User(name, username, password, convertedDateofBirth, graduatedSchool);
				userList.add(newUser);
			}
			csvReader.close();
		}

	public static ArrayList<User> getUserList() {
		return userList;
	}

}
