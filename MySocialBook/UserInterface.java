// User requests will be controlled here.
// Designed as the first user interface corresponding logged in user

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class UserInterface {
	private User currentUser = null;

	//Signs in the user
	//SIGNIN<TAB>userName<TAB>password
	public void signIn() throws IOException, ParseException {
		String inputUserName = nameAndPassword[1]; //****
		String inputUserPassword = nameAndPassword[2]; //****
		//boolean userSignedIn=false;
		//Checks userName and password for every user.
		for (User user: Helper.getUserList()) {
			if (inputUserName.equals(user.getUserName()) && inputUserPassword.equals(user.getPassword())){
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
			if (user.getUserName().equals(userName)){ // why user logged in is in this stage, it has to be upper. Because if user not logged in no need read user list at all...
				this.currentUser.getFriendList().add(user);
				System.out.println(userName + " has been successfully added to your friend list.");
				return;
			}
			else if (this.currentUser.getFriendList().contains(user) && LoggedIn()){
				System.out.println("This user is already in your friend list!");
				return;
			}
		}
		System.out.println("This user is not exists. Adding friend failed.");
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
			if (currentUser.getFriendList()==null){
				System.out.println("You have not added any friend yet!");
				return;
			}else{
				for (User singleUser : currentUser.getFriendList()) {
					System.out.println("Name  : " + singleUser.getName());
					System.out.println("Username  : " + singleUser.getUserName());
					System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
					System.out.println("School  : " + singleUser.getGraduatedSchool());
					System.out.println("----------------------------------------------");
				}
			}
		}
	}
	
	// Adds posts (maybe required some expansion)
	// ADDPOST-TEXT<TAB>textContent<TAB>longitude<TAB>latitude<TAB> userName1<:>userName2<:>..<:>userNameN
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

	}
	
	// Unblocks user from current user
	public void unblockUser() {
		Objects.requireNonNull(this.currentUser);

	}
	
	// Lists blocked friends of current user
	public void listBlockedFriends() {

	}

	// Lists blocked users of current user
	public void listBlockedUsers() {
		if (LoggedIn()) {
			if (currentUser.getBlockedList() == null) {
				System.out.println("You haven’t blocked any friend yet!");
				return;
			}else{
				for (User singleUser : currentUser.getBlockedList()) {
					System.out.println("Name  : " + singleUser.getName());
					System.out.println("Username  : " + singleUser.getUserName());
					System.out.println("Date Of Birth  : " + singleUser.getDateOfBirth());
					System.out.println("School  : " + singleUser.getGraduatedSchool());
					System.out.println("----------------------------------------------");
				}
			}
		}
	}

	// Checks whether User logged in or not
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
