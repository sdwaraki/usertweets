package sumanth.projects.usertweets.model;

public class UserFollowerResult {

    private boolean success;

    public UserFollowerResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
