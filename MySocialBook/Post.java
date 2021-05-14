import java.util.ArrayList;
import java.util.Date;

public abstract class Post {
    private String textContent;
    private Location location;
    private ArrayList<User> taggedFriends;
    private Date date;

    public abstract String display(); //In the case of inclusion a new post type to mysocialbook, designer must specify its printing format. Because of this, Abstract method is used.

    public class TextPost extends Post{
        private String text;

        public  String display(){
            return text
                    + "Date : " + date
                    + "Location : " + location.getLatitude() + location.getLongitude()
                     ;

        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public class ImagePost extends Post{
        private String imagineFileName;
        private Integer imageResolution;

        public  String display(){
            return " ";
        }

        public Integer getImageResolution() {
            return imageResolution;
        }

        public void setImageResolution(Integer imageResolution) {
            this.imageResolution = imageResolution;
        }

        public String getImagineFileName() {
            return imagineFileName;
        }

        public void setImagineFileName(String imagineFileName) {
            this.imagineFileName = imagineFileName;
        }
    }

    public class VideoPost extends Post{
        private String videoFilename;
        private Double videoDuration;
        private Integer theMaximumVideoLengthInMinutes=10;

        public  String display(){
            return " ";
        }
    }

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
