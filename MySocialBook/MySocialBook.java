import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySocialBook {
    public static void main(String[] args) throws IOException, ParseException {
    	Helper.populateUsers();
    	
    	//ADDUSER    Adnan    adnan    adnan1    01/01/1991    Selcuk Universitesi
    	String commandString = "ADDUSER    Adnan    adnan    adnan1    01/01/1991    Selcuk Universitesi";
    	// Split command into parts
    	String[] commandParts = commandString.split("\t");

		switch (commandParts[0].toUpperCase()) // Means ADDUSER
    	{
    	case "ADDUSER":
    		Date date = new SimpleDateFormat("MM/dd/yyyy").parse(commandParts[4]);
    		AdminInterface.addUser(Helper.getUserList(), commandParts[1], commandParts[2], commandParts[3], date, commandParts[5]);
    		break;
        }
    }
}


