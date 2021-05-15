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
					System.out.println(commandParts[1] + " has been successfully added.");
					System.out.println("----------------");
					break;
				case "REMOVEUSER":
					AdminInterface.removeUser(Integer.parseInt(commandParts[1]));
					System.out.println("----------------");
					break;
				case "SIGNIN":
					userPanel.signIn(commandParts[1],commandParts[2]);
					System.out.println("----------------");
					break;
				case "LISTUSERS":
					AdminInterface.listUsers();
					break;
				case "UPDATEPROFILE":
					Date dateOfBirth = new SimpleDateFormat("MM/dd/yyyy").parse(commandParts[2]);
					userPanel.updateProfile(commandParts[1],dateOfBirth,commandParts[3]);
					System.out.println("----------------");
					break;
				case "CHPASS":
					userPanel.changePassword(commandParts[1]);
					System.out.println("----------------");
					break;
				case "ADDFRIEND":
					userPanel.addFriend(commandParts[1]);
					System.out.println("----------------");
					break;

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
