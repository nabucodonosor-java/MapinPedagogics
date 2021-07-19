package com.mapin.pedagogics.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_test")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate publicationDate;
	private Double totalScore;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	private Set<Question> questions = new HashSet<>();

}
