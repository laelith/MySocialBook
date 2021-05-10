import java.util.ArrayList;
import java.util.Date;


public class Post {
    private String textContent;
    private Location location;
    private ArrayList<User> taggedFriends;
    private Date date;


    public class TextPost extends Post{
        private String text;
    }

    public class ImagePost extends Post{
        private String imagineFileName;
        private Integer imageResolution;

    }

    public class VideoPost extends Post{
        private String videoFilename;
        private Double videoDuration;
        private Integer theMaximumVideoLengthInMinutes=10;

    }
}
