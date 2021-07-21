package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mapin.pedagogics.entities.Teacher;

public class TeacherDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String imgTeacherUrl;

	private String name;

	private String resume;

	public TeacherDto() {
	}

	public TeacherDto(Teacher entity) {
		id = entity.getId();
		imgTeacherUrl = entity.getImgTeacherUrl();
		name = entity.getName();
		resume = entity.getResume();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImgTeacherUrl() {
		return imgTeacherUrl;
	}

	public void setImgTeacherUrl(String imgTeacherUrl) {
		this.imgTeacherUrl = imgTeacherUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
