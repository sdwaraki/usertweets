package sumanth.projects.usertweets.model;

import javax.persistence.*;

@Entity
@Table(name = "tweetuser")
public class TweetUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_email")
    private String userEmail;

    @Column(name="user_handle")
    private String userHandle;

    public Integer getId() {
        return id;
    }

    public TweetUser() {
    }

    public TweetUser(String userName, String userEmail, String userHandle) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userHandle = userHandle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }
}
