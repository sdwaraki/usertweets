package sumanth.projects.usertweets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.TweetUser;
import sumanth.projects.usertweets.model.UserFollower;
import sumanth.projects.usertweets.model.UserFollowerResult;
import sumanth.projects.usertweets.repository.UserFollowerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFollowerServiceImpl implements UserFollowerService {

    @Autowired
    private TweetUserService tweetUserService;

    @Autowired
    private UserFollowerRepository userFollowerRepository;


    @Override
    public UserFollowerResult followUser(String targetUserHandle, Integer currentUserId) {
        //Get targetUserId
        TweetUser targetUser = tweetUserService.getUserByUserHandle(targetUserHandle);
        if(targetUser == null)
            return new UserFollowerResult(false);
        Integer targetUserId = targetUser.getId();
        //Save in userfollower table
        if(userFollowerRepository.followUser(targetUserId, currentUserId) > 0)
            return new UserFollowerResult(true);

        return new UserFollowerResult(false);
    }

    @Override
    public List<TweetUser> getAllFollowedUsers(Integer currentUser) {
        //Get all users that the current user follows
        List<Integer> followedUserList = userFollowerRepository.getAllFollowedUsers(currentUser);
        List<TweetUser> tweetUserList = new ArrayList<>();
        //Get all users and return their name, userHandle
        tweetUserList = tweetUserService.getUsersByUserIds(followedUserList);
        return tweetUserList;
    }

    @Override
    public List<TweetUser> getAllFollowingUsers(Integer currentUserId) {
        //Get all users that follow the current user
        List<Integer> followingUserList = userFollowerRepository.getAllFollowingUsers(currentUserId);
        List<TweetUser> tweetUserList = tweetUserService.getUsersByUserIds(followingUserList);
        return tweetUserList;
    }

    @Override
    public UserFollowerResult unfollowUser(String targetUserHandle, Integer currentUserId) {
        //Get targetUserId
        TweetUser targetUser = tweetUserService.getUserByUserHandle(targetUserHandle);
        if(targetUser == null)
            return new UserFollowerResult(false);

        Integer targetUserId = targetUser.getId();

        //Delete entry from the user follower table
        if(userFollowerRepository.unfollowUser(targetUserId, currentUserId) > 0)
            return new UserFollowerResult(true);

        return new UserFollowerResult(false);
    }
}
