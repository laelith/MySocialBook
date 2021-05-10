// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class UserInterface {
	private User CurrentUser = null;

	//Signs in the user
	public void signIn() throws IOException, ParseException {
		ArrayList<User> userList = Helper.fetchUsers();
		File file = new File("C:\\Users\\merve\\commands.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null)
			System.out.println(st);
	}
	
	// Updates current user profile information
	public void updateProfile() {
		if (ifUserLoggedIn()){
			
		}
	}
	
	// Changes password upon current user request
	public void changePass() {

	}
	
	// Adds friend to current user
	public void addFriend() {

	}
	
	// Removes friend if not exists
	public void removeFriend() {
		
	}
	
	// Lists user friends
	public void listFriends() {
		
	}
	
	// Adds posts (maybe required some expansion)
	public void addPost() {
		
	}
	
	// Removing the last post of current user
	public void removeLastPost() {
		
	}
	
	// Showing all posts related with user
	public void showPosts() {
		
	}
	
	// Blocks user from current user if exists
	public void blockUser() {
		
	}
	
	// Unblocks user from current user
	public void unblockUser() {
		
	}
	
	// Lists blocked friends of current user
	public void listBlockedFriends() {
		
	}
	// Lists blocked users of current user
	public void listBlockedUsers() {
		
	}
	// Checks whether User logged in or not
	public boolean ifUserLoggedIn() {
		if (this.CurrentUser == null){
			// Login with any user
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{
			return true;
		}
	}
}
