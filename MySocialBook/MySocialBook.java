import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;

public class MySocialBook {
	public static void main(String[] args) throws IOException, ParseException {

		String userFileRelativePath = args[0];
		String commandsFileRelativePath = args[1];
		if (args.length < 2)
		{
			System.out.println("Invalid call of MySocialBook");
			System.out.println("Proper usage is : java MySocialBook users.txt commands.txt");
			System.out.println("Will continue to work with constant file paths.");
			userFileRelativePath = "users.txt";
			commandsFileRelativePath = "commands.txt";
		}
		//Creates users
		Helper.populateUsers(userFileRelativePath);

		//Reads commands.txt
		try 
		{
			File commandsFile = new File(commandsFileRelativePath);
			Scanner commandsScanner = new Scanner(commandsFile);
			Helper.CommandRunner(commandsFile, commandsScanner);
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found : " + e.getMessage());		
		}		
	}
}
