// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import Post.TextPost;

public class UserInterface {
	private User currentUser = null;
	
	public UserInterface() {
		//empty constructor
	}

	/** 
	* Signs in the user<br>
	* Command:<br>
	* SIGNIN	userName	password
	*/
	public void signIn(String Username, String Password) throws IOException, ParseException {
		//boolean userSignedIn=false;
		//Checks userName and password for every user.
		for (User user: Helper.getUserList()) {
			if (Username.equals(user.getUserName()) && Password.equals(user.getPassword())){
				//userSignedIn=true;
				this.currentUser = user;
				System.out.print("You have successfully signed in.");
				return;
			}
		}
		System.out.print("Invalid username or password! Please try again.");
		return;
		}

	//Signs out the user
	public void signOut() {
		if (LoggedIn()){
			System.out.println("You have successfully signed out.");
			this.currentUser=null;
		}

	}

	// Updates current user profile information
	public void updateProfile(String name, Date dateOfBirth,String graduatedSchool) throws IOException, ParseException {
		//User must be logged in before updating the profile.
		Objects.requireNonNull(this.currentUser);
		if (LoggedIn()){
			//UPDATEPROFILE<TAB>name<TAB>dateofBirth<TAB>schoolGraduated
			this.currentUser.setName(name);
			this.currentUser.setDateOfBirth(dateOfBirth);
			this.currentUser.setGraduatedSchool(graduatedSchool);
		}
	}
	
	// Changes password upon current user request
	public void changePassword(String password) {
		//CHPASS<TAB>oldPassword<TAB>newPassword
		Objects.requireNonNull(this.currentUser);
		if (LoggedIn()) {
			this.currentUser.setPassword(password);
		}
	}
	
	// Adds friend to current user
	// ADDFRIEND<TAB>userName
	public void addFriend(String userName) throws IOException, ParseException {
		if (LoggedIn()) {
			System.out.println("User is not logged in");
			return;
		}
		// check if user not exists		
		for (User user: Helper.getUserList()){
			if (user.getUserName().equals(userName)){
				this.currentUser.getFriendList().add(user);
				System.out.println(userName + " has been successfully added to your friend list.");
				return;
			}
			else if (this.currentUser.getFriendList().contains(user) && LoggedIn()){
				System.out.println("This user is already in your friend list!");
				return;
			}
		}
		System.out.println("No such user!");
		return;
	}
	
	// Removes friend if not exists
	// REMOVEFRIEND<TAB>userName
	public void removeFriend(String userName) throws IOException, ParseException {
			ArrayList<User> userList = Helper.getUserList();
			boolean isFriend=false;
			for (User user: userList){
				if (LoggedIn() && user.getUserName().equals(userName)) {
					this.currentUser.getFriendList().remove(user);
					isFriend = true;
					System.out.println(userName + " has been successfully removed from your friend list.");
				}
			}if (isFriend==false){
				System.out.println("No such friend!");
			}
	}
	
	// Lists user friends
	public void listFriends() {
		if (LoggedIn()){
			if (this.currentUser.getFriendList()==null){
				System.out.println("You have not added any friend yet!");
				return;
			}else{
				for (User singleUser : this.currentUser.getFriendList()) {
					System.out.println("Name  : " + singleUser.getName());
					System.out.println("Username  : " + singleUser.getUserName());
					System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
					System.out.println("School  : " + singleUser.getGraduatedSchool());
					System.out.println("----------------------------------------------");
				}
			}
		}
	}
	
	// Adds Text posts
	// ADDPOST-TEXT<TAB>textContent<TAB>longitude<TAB>latitude<TAB> userName1<:>userName2<:>..<:>userNameN
	public void addTextPost(String textContent, Double longitude, Double latitude, ArrayList<User> taggedFriends) 
	{
		if (LoggedIn()) 
		{
			Location location = new Location(latitude,longitude);
			Date date = new Date(System.currentTimeMillis());
			//formatter.format(date); (To make a human-readable date)
			TextPost userPost = new TextPost(textContent, location, taggedFriends, date);
			this.currentUser.getPostCollection().add(userPost);
		}
	}

//	public void addImagePost(textContent, longitude, latitude, ArrayList<User> taggedFriends) {
//		if (LoggedIn()) {
//
//		}
//
//	}
//
//	public void addVideoPost(textContent, longitude, latitude, ArrayList<User> taggedFriends) {
//		if (LoggedIn()) {
//
//		}
//
//	}
//
//	// Removing the last post of current user
//	public void removeLastPost() {
//		if (LoggedIn()) {
//
//		}
//
//	}
//
//	// Showing all posts related with user
//	public void showPosts() {
//		if (LoggedIn()) {
//
//		}
//
//	}
	
	// Blocks user from current user if exists
	// BLOCK<TAB>userName
	public void blockUser(String userName) {
		if (LoggedIn()) {
			// Blocking a user
			for (User singleUser: Helper.getUserList()){
				if (singleUser.getUserName().equals(userName)){
					if (this.currentUser.getFriendList().contains(singleUser)){
						//If these two users are friends, removing these friends from each other will be appropriate.
						this.currentUser.getFriendList().remove(singleUser);
					}
					//Blocks whether friend or a user
					this.currentUser.getBlockedList().add(singleUser);
					System.out.println(userName + " has been successfully blocked.");
					return;
				}
			}
		}
	}
	
	// Unblocks user from current user
	// UNBLOCK<TAB>userName
	public void unblockUser(String userName) {
		if (LoggedIn()) {
			//For friends
			for (User singleUser : this.currentUser.getBlockedFriendList()){
				if (singleUser.getUserName().equals(userName)) {
					//Unblocks user
					this.currentUser.getBlockedFriendList().remove(singleUser);
					System.out.println(singleUser.getUserName() + " has been successfully unblocked.");
					return;
				}
			}
			//For users who aren't friends
			for (User singleUser : this.currentUser.getBlockedList()){
				if (singleUser.getUserName().equals(userName)) {
					//Unblocks user
					this.currentUser.getBlockedList().remove(singleUser);
					System.out.println(singleUser.getUserName() + " has been successfully unblocked.");
					return;
				}
			}
		}
	}
	
	// Lists blocked friends of current user
	public void showBlockedFriends() {
		if (LoggedIn()) {
			if (this.currentUser.getBlockedFriendList()==null){
				System.out.println("You haven’t blocked any friend yet!");
			}else{
				for (User singleUser : this.currentUser.getBlockedFriendList()) {
					System.out.println("Name  : " + singleUser.getName());
					System.out.println("Username  : " + singleUser.getUserName());
					System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
					System.out.println("School  : " + singleUser.getGraduatedSchool());
					System.out.println("----------------------------------------------");
				}
			}
		}
	}

	// Lists blocked users of current user
	public void showBlockedUsers() {
		if (LoggedIn()) {
			if (this.currentUser.getBlockedFriendList() == null) {
				System.out.println("You haven’t blocked any friend yet!");
			}
			//For users who are blocked
			for (User singleUser : this.currentUser.getBlockedList()) {
				System.out.println("Name  : " + singleUser.getName());
				System.out.println("Username  : " + singleUser.getUserName());
				System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
				System.out.println("School  : " + singleUser.getGraduatedSchool());
				System.out.println("----------------------------------------------");
			}
			//For friends who are blocked (Friends are also users.)
			for (User singleUser : this.currentUser.getBlockedFriendList()) {
				System.out.println("Name  : " + singleUser.getName());
				System.out.println("Username  : " + singleUser.getUserName());
				System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
				System.out.println("School  : " + singleUser.getGraduatedSchool());
				System.out.println("----------------------------------------------");
			}
		}
	}

	// Checks whether user logged in or not
	public boolean LoggedIn() {
		if (this.currentUser == null){
			// Login with any user
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{
			return true;
		}
	}

}
