package sumanth.projects.usertweets.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sumanth.projects.usertweets.model.Tweet;
import sumanth.projects.usertweets.model.TweetUser;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TweetUserRepositoryImpl implements TweetUserRepository {


    private EntityManager entityManager;

    @Autowired
    public TweetUserRepositoryImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public Optional<TweetUser> getUserByUserId(Integer id) {
        return Optional.ofNullable((TweetUser) entityManager.createQuery("SELECT u FROM TweetUser u where u.id=:userId").setParameter("userId", id).getResultList().get(0));
    }

    @Override
    public Optional<TweetUser> getUserByUserHandle(String userHandle) {
        return Optional.ofNullable((TweetUser) entityManager.createQuery("SELECT u from TweetUser u where u.userHandle LIKE :userHandle").setParameter("userHandle", userHandle).getSingleResult());
    }

    @Override
    @Transactional
    public Integer addUser(TweetUser tweetUser) {
        try {
            //check if user with same email exists
            List<Integer> userIdList = entityManager.createQuery("SELECT u.id from TweetUser u where u.userEmail LIKE :userEmail").setParameter("userEmail", tweetUser.getUserEmail()).getResultList();
            if (userIdList.size() > 0)
                return -1;
            entityManager.persist(tweetUser);
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }


    @Override
    @Transactional
    public Integer removeUser(Integer id) {
        try {
            //check if user with same id exists
            List<Integer> userIdList = entityManager.createQuery("SELECT u.id from TweetUser u where u.id=:userId").setParameter("userId", id).getResultList();
            if (userIdList.size() > 0) {   //Remove all the users tweets
                entityManager.createQuery("DELETE FROM Tweet t WHERE t.userId=:userId").setParameter("userId", id).executeUpdate();
                //Remove all the users entries in follower table
                entityManager.createQuery("DELETE FROM UserFollower WHERE userId=:userId OR followerId=:userId").setParameter("userId", id).executeUpdate();
                //Remove the user from the user table
                entityManager.createQuery("DELETE FROM TweetUser where id=:userId").setParameter("userId", id).executeUpdate();
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
        return -1;
    }

    @Override
    public List<TweetUser> getAllUsers(List<Integer> userIdList) {
        try {
            List<TweetUser> tweetUserList = entityManager.createQuery("SELECT u from TweetUser u where u.id in :userIdList").setParameter("userIdList", userIdList).getResultList();
            return tweetUserList;
        }
        catch(Exception e) {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Tweet> getNewsFeed(List<Integer> idList) {
        return entityManager.createNativeQuery("WITH toptweet AS (SELECT *, ROW_NUMBER() OVER (PARTITION BY id ORDER BY created_date DESC) AS rn FROM TWEET t WHERE t.user_id in (:idList)) SELECT user_id,content,created_date,image_url,metadata FROM toptweet WHERE rn=1 ORDER BY created_date desc LIMIT 100")
                .setParameter("idList", idList).getResultList();
    }
}

