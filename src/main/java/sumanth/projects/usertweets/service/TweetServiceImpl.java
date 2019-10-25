package sumanth.projects.usertweets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.repository.TweetRepository;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public void postTweet(String content, String imageUrl, String metadata) {

    }

    @Override
    public List<Tweet> getTweetsByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<Tweet> getTweetByTweetId(Integer tweetId) {
        return null;
    }

    @Override
    public List<Tweet> removeTweet(Integer tweetId, Integer userId) {
        return null;
    }
}
