import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

abstract class Post {
    protected String textContent;
    protected Location location;
    protected ArrayList<User> taggedFriends;
    protected Date date;


    //In the case of inclusion a new post type to mysocialbook, designer must specify its printing format. Because of this, Abstract method is used.
    public abstract String display();


    public Post(String textContent, Location location, ArrayList<User> taggedFriends, Date date) {
        this.textContent = textContent;
        this.location = location;
        this.taggedFriends = taggedFriends;
        this.date = date;
    }

    //Public
    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<User> getTaggedFriends() {
        return taggedFriends;
    }

    public void setTaggedFriends(ArrayList<User> taggedFriends) {
        this.taggedFriends = taggedFriends;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

class TextPost extends Post{
    public String display(){
        System.out.println(textContent);
        String pattern = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String postBirthDayAsString = dateFormat.format(date);
        System.out.println("Date : " + postBirthDayAsString);
        System.out.println("Location : " + location.getLatitude() +", " + location.getLongitude());
        if (!taggedFriends.isEmpty()){
            //Check whether there are taggedFriends or not
            System.out.println("Friends tagged in this post :" + taggedFriends);
        }
        System.out.println("----------------");
        return " ";
    }

    //Public
    public TextPost(String textContent, Location location, ArrayList<User> taggedFriends, Date date) {
        super(textContent, location, taggedFriends, date);
    }
}

class ImagePost extends Post{
    private String imagineFileName;
    private String imageResolution;

    public  String display(){
        System.out.println(textContent);
        String pattern = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String postBirthDayAsString = dateFormat.format(date);
        System.out.println("Date : " + postBirthDayAsString);
        System.out.println("Location : " + location.getLatitude() +", " + location.getLongitude());
        if (!taggedFriends.isEmpty()){
            //Check whether there are taggedFriends or not
            System.out.print("Friends tagged in this post: " );
            for (User friend: taggedFriends){
                System.out.print(friend.getName()+ ",");
            }
            System.out.println();
        }
        System.out.println("Image: " + imagineFileName);
        System.out.println("Image resolution: " + imageResolution);
        System.out.println("----------------");
        return " ";
    }

    public ImagePost(String textContent, Location location, ArrayList<User> taggedFriends, Date date, String imagineFileName, String imageResolution) {
        super(textContent, location, taggedFriends, date);
        this.imagineFileName = imagineFileName;
        this.imageResolution = imageResolution;
    }

    //Public
    public String getImageResolution() {
        return imageResolution;
    }

    public void setImageResolution(String imageResolution) {
        this.imageResolution = imageResolution;
    }

    public String getImagineFileName() {
        return imagineFileName;
    }

    public void setImagineFileName(String imagineFileName) {
        this.imagineFileName = imagineFileName;
    }
}

class VideoPost extends Post {
    private String videoFilename;
    private Double videoDuration;

    public  String display(){
        System.out.println(textContent);
        String pattern = "MM/dd/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        String postBirthDayAsString = dateFormat.format(date);
        System.out.println("Date : " + postBirthDayAsString);
        System.out.println("Location : " + location.getLatitude() + ", " + location.getLongitude());
        if (!taggedFriends.isEmpty()) {
            //Check whether there are taggedFriends or not
            System.out.print("Friends tagged in this post: ");
            for (User friend : taggedFriends) {
                System.out.print(friend.getName() + ",");
            }
            System.out.println();
        }
        System.out.println("Video: " + videoFilename);
        System.out.println("Video Duration: " + videoDuration + " minutes");
        return " ";
    }

    public VideoPost(String textContent, Location location, ArrayList<User> taggedFriends, Date date, String videoFilename, Double videoDuration) {
        super(textContent, location, taggedFriends, date);
        this.videoFilename = videoFilename;
        //Checks whether duration is longer than 10 minutes or not.
        setVideoDuration(videoDuration);
    }

    //Public
    public String getVideoFilename() {
        return videoFilename;
    }

    public void setVideoFilename(String videoFilename) {
        this.videoFilename = videoFilename;
    }

    public Double getVideoDuration() {
        return videoDuration;
    }

    public void setVideoDuration(Double videoDuration) {
        if (videoDuration<10.00){
            this.videoDuration = videoDuration;
        }else{
            System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
        }
    }
}