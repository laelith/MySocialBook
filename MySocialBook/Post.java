import java.util.ArrayList;
import java.util.Date;

public abstract class Post {
    private String textContent;
    private Location location;
    private ArrayList<User> taggedFriends;
    private Date date;

    public abstract String display(); //In the case of inclusion a new post type to mysocialbook, designer must specify its printing format. Because of this, Abstract method is used.

    public class TextPost extends Post{
        public  String display(){
            return textContent
                    + "Date : " + date
                    + "Location : " + location.getLatitude() + location.getLongitude()
                    + "Friends tagged in this post :" + taggedFriends;
        }
    }

    public class ImagePost extends Post{
        private String imagineFileName;
        private Integer imageResolution;

        public  String display(){
            return textContent
                    + "Date : " + date
                    + "Location : " + location.getLatitude() + location.getLongitude()
                    + "Friends tagged in this post :" + taggedFriends
                    + "Image: " + imagineFileName
                    + "Image Resolution: " + imageResolution;
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

        public  String display(){
            return textContent
                    + "Date : " + date
                    + "Location : " + location.getLatitude() + location.getLongitude()
                    + "Friends tagged in this post :" + taggedFriends
                    + "Video: " + videoFilename
                    + "Video Duration: " + videoDuration + " minutes";
        }

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

        public VideoPost(String videoFilename, Double videoDuration) {
            this.videoFilename = videoFilename;
            //videoDuration is checked inside of the set method.
            setVideoDuration(videoDuration);
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
