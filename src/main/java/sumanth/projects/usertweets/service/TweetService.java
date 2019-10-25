package sumanth.projects.usertweets.service;

import sumanth.projects.usertweets.model.Tweet;

import java.util.List;

public interface TweetService {

    void postTweet(String content, String imageUrl, String metadata);

    List<Tweet> getTweetsByUserId(Integer userId);

    List<Tweet> getTweetByTweetId(Integer tweetId);

    List<Tweet> removeTweet(Integer tweetId, Integer userId);

}
