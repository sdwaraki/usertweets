package sumanth.projects.usertweets.model;

public class UserFollowRequest {

    private String userHandle;

    private Integer userId;

    public UserFollowRequest(String userHandle, Integer userId) {
        this.userHandle = userHandle;
        this.userId = userId;
    }

    public UserFollowRequest(){}

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
