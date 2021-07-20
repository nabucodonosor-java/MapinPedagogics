package com.mapin.pedagogics.dto;

import java.io.Serializable;

import com.mapin.pedagogics.entities.StudyClass;

public class StudyClassDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public StudyClassDto() {}
	
	public StudyClassDto(StudyClass entity) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
