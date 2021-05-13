// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
	private User currentUser = null;

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
				this.currentUser=user;
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
		System.out.println("You have successfully signed out.");
		this.currentUser=null;

	}

	// Updates current user profile information
	public void updateProfile(String name, Date dateOfBirth,String graduatedSchool) throws IOException, ParseException {
		//User must be logged in before updating the profile.
		Objects.requireNonNull(this.currentUser);
		//UPDATEPROFILE<TAB>name<TAB>dateofBirth<TAB>schoolGraduated
		this.currentUser.getName()=name;
		this.currentUser.getDateOfBirth()=dateOfBirth;
		this.currentUser.getGraduatedSchool()=graduatedSchool;
	}
	
	// Changes password upon current user request
	public void changePassword(String password) {
		//CHPASS<TAB>oldPassword<TAB>newPassword
		Objects.requireNonNull(this.currentUser);
		this.currentUser.getPassword()=password;
	}
	
	// Adds friend to current user
	public void addFriend() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Removes friend if not exists
	public void removeFriend() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Lists user friends
	public void listFriends() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Adds posts (maybe required some expansion)
	public void addPost() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Removing the last post of current user
	public void removeLastPost() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Showing all posts related with user
	public void showPosts() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Blocks user from current user if exists
	public void blockUser() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Unblocks user from current user
	public void unblockUser() {
		Objects.requireNonNull(this.currentUser);
	}
	
	// Lists blocked friends of current user
	public void listBlockedFriends() {
		Objects.requireNonNull(this.currentUser);
	}

	// Lists blocked users of current user
	public void listBlockedUsers() {
		Objects.requireNonNull(this.currentUser);
	}

	// Checks whether User logged in or not
	public boolean ifUserLoggedIn() {
		if (this.currentUser == null){
			// Login with any user
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{
			return true;
		}
	}
}
