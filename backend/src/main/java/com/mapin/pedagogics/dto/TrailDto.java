package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mapin.pedagogics.entities.Trail;

public class TrailDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String imgTrailUrl;

	private String name;

	private String description;


	public TrailDto() {
	}

	public TrailDto(Trail entity) {
		id = entity.getId();
		imgTrailUrl = entity.getImgTrailUrl();
		name = entity.getName();
		description = entity.getDescription();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgTrailUrl() {
		return imgTrailUrl;
	}

	public void setImgTrailUrl(String imgTrailUrl) {
		this.imgTrailUrl = imgTrailUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
