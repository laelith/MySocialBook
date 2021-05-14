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
		// Will use in MySocialBook.java in case of command inputs. Dont implement here.
		// Don't forget what I say, your function needed to do single work.
		// Don't over complicate funtcions.
		Scanner scan = new Scanner (new File("C:\\Users\\merve\\commands.txt"));
		String[] nameAndPassword = scan.nextLine().split("\t");
		
		// what if user enters wrong command like 
		// password then user name.
		// so your user name will be your password
		// and your password will be your user name.
		// Good example of data validation check.
		String inputUserName = nameAndPassword[1];
		String inputUserPassword = nameAndPassword[2];
		//boolean userSignedIn=false;
		//Checks userName and password for every user.
		for (User user: userList){
			if(inputUserName.equals(user.getUserName()) && inputUserPassword.equals(user.getPassword())) {
				//userSignedIn=true;
				this.currentUser=user;
				System.out.print("You have successfully signed in.");
				return;
			}
		}
		
		// why you check below again, you already signed in user above. No ?
		//if (userSignedIn==true){
		//	System.out.print("You have successfully signed in.");
		//}else{
		System.out.print("Invalid username or password! Please try again.");
		return;
		//}
	}

	//Signs out the user
	public void signOut() {
		// what if user has not logged in ????
		// where is the check.
		System.out.println("You have successfully signed out.");
		this.currentUser=null;

	}

	// Updates current user profile information
	public void updateProfile(String name, Date dateOfBirth,String graduatedSchool) throws IOException, ParseException {
		//User must be logged in before updating the profile.
		Objects.requireNonNull(this.currentUser);
		
		// I have very big question on below if statement, do you really need to check true if its true ?
		// true == true results as true.
		// you have true in first stage, why would you need to check true again?
		// it has to be bUserLoggedIn() thats enough
		// if (bUserLoggedIn()){
		//        ......
		//        ......
		//    }
		if (bUserLoggedIn()==true){
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
		if (bUserLoggedIn()==true) {
			this.currentUser.setPassword(password);
		}
	}
	
	// Adds friend to current user
	// ADDFRIEND<TAB>userName
	public void addFriend(String userName) throws IOException, ParseException {
		
		// check usage ... https://www.logicbig.com/how-to/code-snippets/jcode-java-utils-objects-requirenonnull.html
		// Its not logical, below line is related with exception. You dont need that do you ?
		// Objects.requireNonNull(this.currentUser); 
		if (bUserLoggedIn()) {
			System.out.println("User is not logged in");
			return;
		}
		
		// why we are reading those continuously 
		// import it as function call...
		// why reading over and over and over again.
		ArrayList<User> userList = Helper.fetchUsers();
		//boolean userExists=false;
		
		// check if user not exists		
		for (User user: userList){
			if (user.getUserName().equals(userName)){ // why user logged in is in this stage, it has to be upper. Because if user not logged in no need read user list at all...
				this.currentUser.getFriendList().add(user);
				System.out.println(userName + " has been successfully added to your friend list.");
				return;
			}
			else if (this.currentUser.getFriendList().contains(user) && bUserLoggedIn()==true){
				System.out.println("This user is already in your friend list!");
				return;
			}
		}
		// you dont need any or extra boolean for this check. If above ifs are failed that means user doesnt exists.
		System.out.println("This user is not exists. Adding friend failed.");
		return;
	}
	
	// Removes friend if not exists
	// REMOVEFRIEND<TAB>userName
	public void removeFriend(String userName) throws IOException, ParseException {
		Objects.requireNonNull(this.currentUser);
		
		// why reading same list again.
		ArrayList<User> userList = Helper.fetchUsers();
		boolean isFriend=false;
		for (User user: userList){
			// why logged in check in this stage.
			if (bUserLoggedIn() == true && user.getUserName().equals(userName)) {
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
		Objects.requireNonNull(this.currentUser);

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
	// bCamelCase is the naming convention, don't use if in function name.
	public boolean bUserLoggedIn() {
		if (this.currentUser == null){
			// Login with any user
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{
			return true;
		}
	}
}
