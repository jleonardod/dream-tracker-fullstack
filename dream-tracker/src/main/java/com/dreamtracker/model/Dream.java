package com.dreamtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="dreams")
public class Dream {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String Content;
	
	@Column(name = "dream_date", nullable = false)
	private LocalDate dreamDate;
	
	@Column(name = "emotional_state")
	private String emotionalState;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "dream", cascade = CascadeType.ALL)
	private List<DreamKeyword> keywords;
	
	@OneToMany(mappedBy = "dream")
	private List<DreamEmotion> emotions;
	
	public Dream() {
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public LocalDate getDreamDate() {
		return dreamDate;
	}

	public void setDreamDate(LocalDate dreamDate) {
		this.dreamDate = dreamDate;
	}

	public String getEmotionalState() {
		return emotionalState;
	}

	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<DreamKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<DreamKeyword> keywords) {
		this.keywords = keywords;
	}

	public List<DreamEmotion> getEmotions() {
		return emotions;
	}

	public void setEmotions(List<DreamEmotion> emotions) {
		this.emotions = emotions;
	}
	
	
}
