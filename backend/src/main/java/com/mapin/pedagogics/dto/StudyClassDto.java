package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mapin.pedagogics.entities.StudyClass;

public class StudyClassDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate publicationDate;
	private String title;
	private String subtitle;
	private String videoUrl;
	private Integer videoTime;
	private boolean finished;
	private String description;

	private SubjectDto subject;

	private TopicDto topic;

	private List<CommentDto> comments = new ArrayList<>();

	public StudyClassDto() {
	}

	public StudyClassDto(StudyClass entity) {
		id = entity.getId();
		publicationDate = entity.getPublicationDate();
		title = entity.getTitle();
		subtitle = entity.getSubtitle();
		videoUrl = entity.getVideoUrl();
		videoTime = entity.getVideoTime();
		finished = entity.isFinished();
		description = entity.getDescription();
		subject = new SubjectDto(entity.getSubject());
		topic = new TopicDto(entity.getTopic());
		entity.getComments().forEach(c -> this.comments.add(new CommentDto(c)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Integer getVideoTime() {
		return videoTime;
	}

	public void setVideoTime(Integer videoTime) {
		this.videoTime = videoTime;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
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

	public TopicDto getTopic() {
		return topic;
	}

	public void setTopic(TopicDto topic) {
		this.topic = topic;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

}
