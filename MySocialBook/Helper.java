// Wraps up helper functions to operate main functionality
// 
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class Helper
{
	public final static String pathToCsv = "users.txt";
	public static ArrayList <User> FetchUsers()
	{
		ArrayList<User> userList = new ArrayList<User>();
		BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
		String row = null;
		while ((row  = csvReader.readLine()) != null) {
		    String[] data = row.split("\t");
		    //data bir array, burada senin satırını tablara göre ayıracak, sen de bunları atayacaksın.
		}
		csvReader.close();
		return userList;
	}
}
