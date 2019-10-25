package sumanth.projects.usertweets.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="content")
    private String content;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="image_url")
    private String imageURL;

    @Column(name="metadata")
    private String metaData;

    public Tweet() {
    }

    public Tweet(Integer userId, String content, Date createdDate, String imageURL, String metaData) {
        this.userId = userId;
        this.content = content;
        this.createdDate = createdDate;
        this.imageURL = imageURL;
        this.metaData = metaData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
