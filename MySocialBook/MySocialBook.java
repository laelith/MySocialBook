import java.io.File;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySocialBook {
	public static void main(String[] args) throws IOException, ParseException {

		//String userFile = args[0];
		//String commandsFile = args[1];
		//Creates users
		Helper.populateUsers();

		//Reads commands.txt
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
					userPanel.signIn(commandParts[1], commandParts[2]);
					System.out.println("----------------");
					break;
				case "LISTUSERS":
					AdminInterface.listUsers();
					break;
				case "UPDATEPROFILE":
					Date dateOfBirth = new SimpleDateFormat("MM/dd/yyyy").parse(commandParts[2]);
					userPanel.updateProfile(commandParts[1], dateOfBirth, commandParts[3]);
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
				case "REMOVEFRIEND":
					userPanel.removeFriend(commandParts[1]);
					System.out.println("----------------");
					break;
				case "LISTFRIENDS":
					userPanel.listFriends();
					break;
				case "ADDPOST-TEXT":
					Double longitudeText = Double.parseDouble(commandParts[2]);
					Double latitudeText = Double.parseDouble(commandParts[3]);
					userPanel.addTextPost(commandParts[1], longitudeText, latitudeText, commandParts[4]);
					System.out.println("----------------");
					break;
				case "ADDPOST-IMAGE":
					Double longitudeImage = Double.parseDouble(commandParts[2]);
					Double latitudeImage = Double.parseDouble(commandParts[3]);
					userPanel.addImagePost(commandParts[1], longitudeImage, latitudeImage, commandParts[4], commandParts[5], commandParts[6]);
					System.out.println("----------------");
					break;
				case "ADDPOST-VIDEO":
					Double longitudeVideo = Double.parseDouble(commandParts[2]);
					Double latitudeVideo = Double.parseDouble(commandParts[3]);
					Double videoDuration = Double.parseDouble(commandParts[6]);
					userPanel.addVideoPost(commandParts[1], longitudeVideo, latitudeVideo, commandParts[4], commandParts[5], videoDuration);
					System.out.println("----------------");
					break;
				case "REMOVELASTPOST":
					userPanel.removeLastPost();
					System.out.println("----------------");
					break;
				case "SHOWPOSTS":
					userPanel.showPosts(commandParts[1]);
					System.out.println("----------------");
					break;
				case "BLOCK":
					userPanel.blockUser(commandParts[1]);
					System.out.println("----------------");
					break;
				case "SHOWBLOCKEDFRIENDS":
					userPanel.showBlockedFriends();
					break;
				case "UNBLOCK":
					userPanel.unblockUser(commandParts[1]);
					System.out.println("----------------");
					break;
				case "SHOWBLOCKEDUSERS":
					userPanel.showBlockedUsers();
					break;
				case "SIGNOUT":
					userPanel.signOut();
					break;
			}
		}
		scanner.close();
	}
}
