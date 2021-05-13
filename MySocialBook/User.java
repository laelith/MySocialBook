import java.util.ArrayList;
import java.util.Date;

public class User {
	// Private
	private int userID;
    private static int nextUserID = 1;
    // I used nextUserID to increase ID's and also give everyone an unique ID
    private String name;
    private String userName;
    private String password;
    private Date dateOfBirth;
    private String graduatedSchool;
    private Date lastLoginDate;
    private ArrayList<User> friendList;
    private ArrayList<User> blockedList;
    private ArrayList<Post> postCollection;

    // Public
    public User(String name, String userName, String password, Date dateOfBirth, String graduatedSchool) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.graduatedSchool = graduatedSchool;
        this.userID = nextUserID;
        nextUserID++;
    }

    /*
    It is said These IDs cannot be changed later. So I didn't write set method.
    public void setUserID(int userID) {this.userID = userID;}
    */

    public int getUserID() { return userID;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }

    public ArrayList<User> getBlockedList() {
        return blockedList;
    }

    public void setBlockedList(ArrayList<User> blockedList) {
        this.blockedList = blockedList;
    }

    public ArrayList<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(ArrayList<Post> postCollection) {
        this.postCollection = postCollection;
    }
}
