package sumanth.projects.usertweets.service;

import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.TweetUser;
import sumanth.projects.usertweets.model.UserFollowerResult;

import java.util.List;

public interface UserFollowerService {

    public UserFollowerResult followUser(String targetUserHandle, Integer currentUserId);

    public List<TweetUser> getAllFollowedUsers(Integer currentUserId);

    public List<TweetUser> getAllFollowingUsers(Integer currentUserId);

    public UserFollowerResult unfollowUser(String targetUserHandle, Integer currentUserId);
}
