package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.mapin.pedagogics.entities.Comment;

public class CommentInsertDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotBlank(message = "Campo obrigatório")
	private LocalDate publicationDate;

	@NotBlank(message = "Campo obrigatório")
	private String comment;

	private StudyClassDto studyClass;

	private UserDto student;

	public CommentInsertDto() {
	}

	public CommentInsertDto(Comment entity) {
		id = entity.getId();
		publicationDate = entity.getPublicationDate();
		comment = entity.getComment();
		studyClass = new StudyClassDto(entity.getStudyClass());
		student = new UserDto(entity.getStudent());
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public StudyClassDto getStudyClass() {
		return studyClass;
	}

	public void setStudyClass(StudyClassDto studyClass) {
		this.studyClass = studyClass;
	}

	public UserDto getStudent() {
		return student;
	}

	public void setStudent(UserDto student) {
		this.student = student;
	}

}
