package sumanth.projects.usertweets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedServiceImpl implements FeedService {

    @Autowired
    private UserFollowerService userFollowerService;

    @Autowired
    private TweetUserService tweetUserService;

    @Autowired
    private TweetService tweetService;

    @Override
    public List<Tweet> getNewsFeed(Integer currentUserId) {
        //Get all followers and return their tweets based on recency
        //Can add additional ordering params based on retweets, likes, popularity of the user tweeted etc.

        //Get all users followed by the current user
        List<Integer> tweetUserList = userFollowerService.getAllFollowedUsers(currentUserId).stream().map(x -> x.getId()).collect(Collectors.toList());

        //Get the 10 most recent messages
        List<Tweet> topTweets = tweetUserService.getNewsFeed(tweetUserList);
        return topTweets;
    }
}
