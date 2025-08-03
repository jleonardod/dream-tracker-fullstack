package com.dreamtracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dream_keywords")
public class DreamKeyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "dream_id", nullable = false)
	private Dream dream;
	
	@Column(nullable = false)
	private String keyword;
	
	private int frequency;
	
	public DreamKeyword() { 
		this.frequency = 1;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Dream getDream() {
		return dream;
	}

	public void setDream(Dream dream) {
		this.dream = dream;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
