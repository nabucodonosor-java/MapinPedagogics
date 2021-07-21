package com.mapin.pedagogics.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String imgTopicUrl;

	@Column(unique = true)
	@Unique
	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@OneToMany(mappedBy = "topic")
	private List<StudyClass> studyClasses = new ArrayList<>();
	
	@OneToMany(mappedBy = "topic")
	private List<Question> questions = new ArrayList<>();
	
	public List<StudyClass> getStudyClasses() {
		return studyClasses;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgTopicUrl() {
		return imgTopicUrl;
	}

	public void setImgTopicUrl(String imgTopicUrl) {
		this.imgTopicUrl = imgTopicUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
