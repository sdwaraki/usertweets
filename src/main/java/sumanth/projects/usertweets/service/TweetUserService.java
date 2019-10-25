package sumanth.projects.usertweets.service;

import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;

import java.util.List;

public interface TweetUserService {

     TweetUser getUserByUserId(Integer id);

     TweetUser getUserByUserHandle(String userHandle);

     Integer addUser(TweetUser tweetUser);

     Integer removeUser(Integer id);

     List<TweetUser> getUsersByUserIds(List<Integer> userIdList);

     List<Tweet> getNewsFeed(List<Integer> idList);
}
