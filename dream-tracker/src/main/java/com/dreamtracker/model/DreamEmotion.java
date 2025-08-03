package com.dreamtracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dream_emotions")
public class DreamEmotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "dream_id", nullable = false)
	private Dream dream;
	
	@Column(nullable = false)
	private String emotion;
	
	private int intensity;
	
	public DreamEmotion() {
		this.intensity = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dream getDream() {
		return dream;
	}

	public void setDream(Dream dream) {
		this.dream = dream;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public int getIntensity() {
		return intensity;
	}

	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
	
}
