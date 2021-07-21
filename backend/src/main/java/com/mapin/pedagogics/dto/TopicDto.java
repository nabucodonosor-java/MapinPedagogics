package com.mapin.pedagogics.dto;

import java.io.Serializable;

import com.mapin.pedagogics.entities.Topic;

public class TopicDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String imgTopicUrl;

	private String title;

	private String description;

	public TopicDto() {
	}

	public TopicDto(Topic entity) {
		id = entity.getId();
		imgTopicUrl = entity.getImgTopicUrl();
		title = entity.getTitle();
		description = entity.getDescription();
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

}
