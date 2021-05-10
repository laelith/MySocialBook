import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySocialBook {
    public static void main(String[] args) throws IOException, ParseException {
    	ArrayList<User> userList = Helper.fetchUsers();
        //UserInterface newUser = new UserInterface();
        //newUser.signIn();
        AdminInterface newUser = new AdminInterface();
        newUser.addUser();
        for (User user: userList){
            System.out.println(user.getName());
        }
    }
}


