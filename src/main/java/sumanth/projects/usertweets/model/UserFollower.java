package sumanth.projects.usertweets.model;

import javax.persistence.*;

@Entity
@Table(name="userfollower")
public class UserFollower {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="follower_id")
    private Integer followerId;

    public UserFollower(){}

    public UserFollower(Integer id, Integer userId, Integer followerId) {
        this.id = id;
        this.userId = userId;
        this.followerId = followerId;
    }

    public UserFollower(Integer userId, Integer followerId) {
        this.userId = userId;
        this.followerId = followerId;
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

    public Integer getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Integer followerId) {
        this.followerId = followerId;
    }
}
