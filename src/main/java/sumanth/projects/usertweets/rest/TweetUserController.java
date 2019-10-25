package sumanth.projects.usertweets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;
import sumanth.projects.usertweets.service.FeedService;
import sumanth.projects.usertweets.service.TweetUserService;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class TweetUserController {

    @Autowired
    TweetUserService tweetUserService;

    @Autowired
    FeedService feedService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TweetUser getUserById(@PathVariable Integer id) {
        return tweetUserService.getUserByUserId(id);
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Integer addUser(@RequestBody TweetUser tweetUser) {
        Integer result = tweetUserService.addUser(tweetUser);
        return result;
    }

    @RequestMapping(value="/remove/{id}", method = RequestMethod.POST)
    public Integer removeUser(@PathVariable Integer id) {
        return tweetUserService.removeUser(id);
    }

    @RequestMapping(value="/newsfeed/{id}", method = RequestMethod.GET)
    public List<Tweet> getNewsFeed(@PathVariable Integer id) {
        return feedService.getNewsFeed(id);
    }

}
