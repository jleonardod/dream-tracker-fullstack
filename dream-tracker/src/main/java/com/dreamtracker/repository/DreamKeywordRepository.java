package com.dreamtracker.repository;

import com.dreamtracker.model.DreamKeyword;
import com.dreamtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DreamKeywordRepository extends JpaRepository<DreamKeyword, Long> {
	List<DreamKeyword> findDreamUserId(Long userId);
	
	@Query("SELECT k.keyword, SUM(k.frequency) as total " + 
			"FROM DreamKeyword k WHERE k.dream.user = :user " +
			"GROUP BY k.keyword ORDER BY total DESC")
	List<Object[]> findKeywordFrequencyByUser(@Param("user") User user);
}
