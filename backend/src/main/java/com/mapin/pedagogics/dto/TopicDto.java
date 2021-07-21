package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mapin.pedagogics.entities.Topic;

public class TopicDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String imgTopicUrl;

	private String title;

	private String description;

	private SubjectDto subject;

	private List<StudyClassDto> studyClasses = new ArrayList<>();

	private List<QuestionDto> questions = new ArrayList<>();

	public TopicDto() {
	}

	public TopicDto(Topic entity) {
		id = entity.getId();
		imgTopicUrl = entity.getImgTopicUrl();
		title = entity.getTitle();
		description = entity.getDescription();
		subject = new SubjectDto(entity.getSubject());
		entity.getStudyClasses().forEach(sc -> this.studyClasses.add(new StudyClassDto(sc)));
		entity.getQuestions().forEach(q -> this.questions.add(new QuestionDto(q)));
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

	public SubjectDto getSubject() {
		return subject;
	}

	public void setSubject(SubjectDto subject) {
		this.subject = subject;
	}

	public List<StudyClassDto> getStudyClasses() {
		return studyClasses;
	}

	public List<QuestionDto> getQuestions() {
		return questions;
	}

}
