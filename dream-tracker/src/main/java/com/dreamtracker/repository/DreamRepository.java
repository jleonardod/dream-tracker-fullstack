package com.dreamtracker.repository;

import com.dreamtracker.model.Dream;
import com.dreamtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface DreamRepository extends JpaRepository<Dream, Long> {
	List<Dream> findByUserOrderByDreamDataDesc(User user);
	List<Dream> findByUserAndDreamDataBetween(User user, LocalDate startDate, LocalDate endDate);
	
	@Query("SELECT d FROM Dream d WHERE d.user = :user AND d.content LIKE %:keyword%")
	List<Dream> findByUserAndKeyword(@Param("user") User user, @Param("keyword") String keyword);
}
