package com.mapin.pedagogics.dto;

import java.io.Serializable;

import com.mapin.pedagogics.entities.Subject;

public class SubjectDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String imgSubjectUrl;

	private String description;

	private TrailDto trail;

	private TeacherDto teacher;

	public SubjectDto() {
	}

	public SubjectDto(Subject entity) {

		id = entity.getId();
		name = entity.getName();
		imgSubjectUrl = entity.getImgSubjectUrl();
		description = entity.getDescription();
		trail = new TrailDto(entity.getTrail());
		teacher = new TeacherDto(entity.getTeacher());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgSubjectUrl() {
		return imgSubjectUrl;
	}

	public void setImgSubjectUrl(String imgSubjectUrl) {
		this.imgSubjectUrl = imgSubjectUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TrailDto getTrail() {
		return trail;
	}

	public void setTrail(TrailDto trail) {
		this.trail = trail;
	}

	public TeacherDto getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDto teacher) {
		this.teacher = teacher;
	}

}
