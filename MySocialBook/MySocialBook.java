import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class MySocialBook {
    
    public static void main(String[] args) throws IOException, ParseException {
    	/// Already implemented below part in Helper.FetchUsers() function
        ArrayList<User> fetchedUsers = Helper.FetchUsers();
=======

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class MySocialBook {
    
    public static void main(String[] args) throws FileNotFoundException, ParseException {
    	/// Already implemented below part in Helper.FetchUsers() function
        Scanner userToAdd = new Scanner(new File("C:\\Users\\merve\\users.txt"));
        userToAdd.useDelimiter("\t");
        
        ArrayList <User> userList = new ArrayList <User>();
        while(userToAdd.hasNext()) {

            //name<TAB>username<TAB>password<TAB>dateofBirth<TAB>graduatedSchool
            String name = userToAdd.next();
            String username = userToAdd.next();
            String password = userToAdd.next();
            SimpleDateFormat dateofBirth = new SimpleDateFormat("MM/dd/yyyy");
            Date convertedDateofBirth = dateofBirth.parse(userToAdd.next());
            // String date = dateofBirth.format(convertedDateofBirth);
            //Trim method is used, because there were some white spaces before the school.
            String graduatedSchool = (userToAdd.nextLine()).trim();
            //This will be created objects of user class.
            User newUser = new User(name, username, password, convertedDateofBirth, graduatedSchool);
            userList.add(newUser);
        }
        userToAdd.close();

>>>>>>> origin/master

    }


}


