package sumanth.projects.usertweets.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sumanth.projects.usertweets.model.UserFollower;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserFollowerRepositoryImpl implements UserFollowerRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Integer followUser(Integer targetUserId, Integer currentUserId) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            UserFollower userFollower = new UserFollower(currentUserId, targetUserId);
            currentSession.save(userFollower);
            return 1;
        }
        catch(Exception e) {
            return -1;
        }
    }


    //Can do without using transactional too.
    @Override
    public Integer unfollowUser(Integer targetUserId, Integer currentUserId) {
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.beginTransaction();
            UserFollower userFollower = new UserFollower(currentUserId, targetUserId);
            currentSession.delete(userFollower);
            currentSession.getTransaction().commit();
            return 1;
        }
        catch(Exception e) {
            return 0;
        }
    }

    //Gives back who is following the current user
    @Override
    public List<Integer> getAllFollowedUsers(Integer currentUserId) {
        try {
            return entityManager.createQuery("SELECT u.followerId FROM UserFollower u where u.userId=:userId").setParameter("userId", currentUserId).getResultList();
        }
        catch (Exception e) {
            return new ArrayList<>();
        }
    }

    //Get all users which the current user follows
    @Override
    public List<Integer> getAllFollowingUsers(Integer currentUserId) {
        try {
            return  entityManager.createQuery("SELECT u.userId FROM UserFollower u where u.followerId=:userId").setParameter("userId", currentUserId).getResultList();
        }
        catch (Exception e) {
            return new ArrayList<>();
        }    }
}
