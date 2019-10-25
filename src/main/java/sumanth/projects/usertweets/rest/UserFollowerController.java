package sumanth.projects.usertweets.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sumanth.projects.usertweets.model.TweetUser;
import sumanth.projects.usertweets.model.UserFollowRequest;
import sumanth.projects.usertweets.model.UserFollower;
import sumanth.projects.usertweets.model.UserFollowerResult;
import sumanth.projects.usertweets.service.UserFollowerService;

import java.util.List;

@RestController
@RequestMapping("/relation")
public class UserFollowerController {

    @Autowired
    private UserFollowerService userFollowerService;


    @PostMapping(path = "/follow", consumes = "application/json", produces = "application/json")
    public UserFollowerResult followUser(@RequestBody UserFollowRequest userFollowRequest) {
        return userFollowerService.followUser(userFollowRequest.getUserHandle(), userFollowRequest.getUserId());
    }

    @PostMapping(path = "/unfollow", consumes = "application/json", produces = "application/json")
    public UserFollowerResult unFollowUser(@RequestBody UserFollowRequest userFollowRequest) {
        return userFollowerService.unfollowUser(userFollowRequest.getUserHandle(), userFollowRequest.getUserId());
    }

    @GetMapping(path = "/getFollowers/{id}")
    public List<TweetUser> getAllFollowers(@PathVariable(value = "id") Integer currentUserId) {
        return userFollowerService.getAllFollowingUsers(currentUserId);
    }

}
