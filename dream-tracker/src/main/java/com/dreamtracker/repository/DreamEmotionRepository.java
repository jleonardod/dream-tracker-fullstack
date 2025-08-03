package com.dreamtracker.repository;

import com.dreamtracker.model.DreamEmotion;
import com.dreamtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DreamEmotionRepository extends JpaRepository<DreamEmotion, Long>{
	
	@Query("SELECT e.emotion, SUM(e.intensity) as total "+
			"FROM DreamEmotion e WHERE e.dream.user = :user " +
			"GROUP BY e.emotion ORDER BY total DESC ")
	List<Object[]> findEmotionFrequencyByUser(@Param("user") User user);
}
