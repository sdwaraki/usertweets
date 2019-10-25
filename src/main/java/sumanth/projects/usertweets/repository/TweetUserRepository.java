package sumanth.projects.usertweets.repository;

import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;

import java.util.List;
import java.util.Optional;

public interface TweetUserRepository {

     Optional<TweetUser> getUserByUserId(Integer id);

     Optional<TweetUser> getUserByUserHandle(String userHandle);

     Integer addUser(TweetUser tweetUser);

     Integer removeUser(Integer id);

     List<TweetUser> getAllUsers(List<Integer> userIdList);

     List<Tweet> getNewsFeed(List<Integer> idList);
}
