package com.mapin.pedagogics.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_study_class")
public class StudyClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate publicationDate;
	private String imgStudyClassUrl;
	private String title;
	private String subtitle;
	private String videoUrl;
	private Integer videoTime;
	private boolean finished;
	private String description;
	
	private Subject subject;
	
	private Topic topic;
	
	@ManyToMany(mappedBy = "studyClasses")
	private Set<User> alunos = new HashSet<>();
	
	@OneToMany(mappedBy = "studyClass")
	private List<Comment> comments = new ArrayList<>();
	
	
}
