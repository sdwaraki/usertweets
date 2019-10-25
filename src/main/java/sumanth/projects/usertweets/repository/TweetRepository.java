package sumanth.projects.usertweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sumanth.projects.usertweets.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Integer> {
}
