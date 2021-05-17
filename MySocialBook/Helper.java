// Wraps up helper functions to operate main functionality

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class Helper {

	private static ArrayList<User> userList = new ArrayList<User>();

		// ADDUSER<TAB>name<TAB>userName<TAB>password<TAB>dateofBirth<TAB>schoolGraduate
		public static void populateUsers(String userFileRelativePath) throws IOException, ParseException {
			BufferedReader csvReader = new BufferedReader(new FileReader(userFileRelativePath));
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
	
	public static void CommandRunner(File commandsFile, Scanner commandsScanner) throws ParseException, IOException
	{
		UserInterface userPanel = new UserInterface();
		while (commandsScanner.hasNextLine()) {
			String commandLine = commandsScanner.nextLine();
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
		commandsScanner.close();
	}

}
