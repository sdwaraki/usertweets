package sumanth.projects.usertweets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;
import sumanth.projects.usertweets.repository.TweetUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TweetUserServiceImpl implements TweetUserService {

    @Autowired
    private TweetUserRepository tweetUserRepository;


    @Override
    public TweetUser getUserByUserId(Integer id) {
        Optional<TweetUser> tweetUser = tweetUserRepository.getUserByUserId(id);
        return tweetUser.get();
    }

    @Override
    public TweetUser getUserByUserHandle(String userHandle) {
        return tweetUserRepository.getUserByUserHandle(userHandle).get();
    }

    @Override
    public Integer addUser(TweetUser tweetUser) {
        //TODO return some sort of API key here - So that user can get authenticated.
        return tweetUserRepository.addUser(tweetUser);
    }

    @Override
    public Integer removeUser(Integer id) {
        return tweetUserRepository.removeUser(id);
    }

    @Override
    public List<TweetUser> getUsersByUserIds(List<Integer> userIdList) {
        return tweetUserRepository.getAllUsers(userIdList);
    }

    @Override
    public List<Tweet> getNewsFeed(List<Integer> idList) {
        return tweetUserRepository.getNewsFeed(idList);
    }


}
