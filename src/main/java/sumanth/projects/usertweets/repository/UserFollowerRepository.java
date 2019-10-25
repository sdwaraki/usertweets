package sumanth.projects.usertweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowerRepository {

     Integer followUser(Integer targetUserId, Integer currentUserId);

     Integer unfollowUser(Integer targetUserId, Integer currentUserId);

     List<Integer> getAllFollowedUsers(Integer currentUserId);

     List<Integer> getAllFollowingUsers(Integer currentUserId);

}
