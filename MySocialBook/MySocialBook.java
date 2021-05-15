import java.io.File;
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

		File file = new File("commands.txt");
		Scanner scanner = new Scanner(file);
		

		UserInterface userPanel = new UserInterface();
		while (scanner.hasNextLine()) {
			String commandLine = scanner.nextLine();
			System.out.println("Command : " + commandLine);
			String[] commandParts = commandLine.split("\t");

			switch (commandParts[0].toUpperCase()) { // Means COMMAND in capital case
				case "ADDUSER":
					Date date = new SimpleDateFormat("MM/dd/yyyy").parse(commandParts[4]);
					AdminInterface.addUser(commandParts[1], commandParts[2], commandParts[3], date, commandParts[5]);
					break;
				case "SIGNIN":
					userPanel.signIn(commandParts[1], commandParts[2]);
					break;
				default:
					;
//		case "REMOVEUSER":
//		case "LISTUSERS":
//		case "UPDATEPROFILE":
//		case "CHPASS":
//		case "ADDFRIEND":
//		case "REMOVEFRIEND":
//		case "LISTFRIEND":
//		case "ADDPOST-TEXT":
//		case "ADDPOST-IMAGE":
//		case "ADDPOST-VIDEO":
//		case "REMOVELASTPOST":
//		case "SHOWPOSTS":
//		case "BLOCK":
//		case "SHOWBLOCKEDFRIENDS":
//		case "UNBLOCK":
//		case "SHOWBLOCKEDUSERS":
//		case "SIGNOUT":
			}
		}
		scanner.close();
	}
}
