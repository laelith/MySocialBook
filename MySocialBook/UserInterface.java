// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	private User CurrentUser = null;

	//Signs in the user
	//SIGNIN<TAB>userName<TAB>password
	public void signIn() throws IOException, ParseException {
		ArrayList<User> userList = Helper.fetchUsers();
		Scanner scan = new Scanner (new File("C:\\Users\\merve\\commands.txt"));
		String[] nameAndPassword = scan.nextLine().split("\t");
		String inputUserName = nameAndPassword[1];
		String inputUserPassword = nameAndPassword[2];
		boolean userSignedIn=false;
		//Checks userName and password for every user.
		for (User user: userList){
			if(inputUserName.equals(user.getUserName()) && inputUserPassword.equals(user.getPassword())) {
				userSignedIn=true;
			}
		}
		if (userSignedIn==true){
			System.out.print("You have successfully signed in.");
		}else{
			System.out.print("Invalid username or password! Please try again.");
		}
	}

	//Signs out the user
	public void signOut() {
		//Sign-in durumunu false yap
	}

	// Updates current user profile information
	public void updateProfile() {

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
