package sumanth.projects.usertweets.service;

import sumanth.projects.usertweets.model.Tweet;

import java.util.List;

public interface FeedService {

    public List<Tweet> getNewsFeed(Integer currentUserId);
}
