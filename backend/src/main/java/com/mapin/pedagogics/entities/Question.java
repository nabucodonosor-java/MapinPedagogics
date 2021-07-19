package com.mapin.pedagogics.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_question")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String questionStatement;

	private boolean altA;
	private String valueA;
	private boolean altB;
	private String valueB;
	private boolean altC;
	private String valueC;
	private boolean altD;
	private String valueD;
	private boolean altE;
	private String valueE;

	@Column(columnDefinition = "TEXT")
	private String studentAnswer;

	@Column(columnDefinition = "TEXT")
	private String rightAnswer;
	private Double questionValue;
	private Double score;

	@ManyToOne
	@JoinColumn(name = "topic_id")
	private Topic topic;

	@ManyToMany(mappedBy = "questions")
	private Set<Test> tests = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "question_type_id")
	private QuestionType questionType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public boolean isAltA() {
		return altA;
	}

	public void setAltA(boolean altA) {
		this.altA = altA;
	}

	public String getValueA() {
		return valueA;
	}

	public void setValueA(String valueA) {
		this.valueA = valueA;
	}

	public boolean isAltB() {
		return altB;
	}

	public void setAltB(boolean altB) {
		this.altB = altB;
	}

	public String getValueB() {
		return valueB;
	}

	public void setValueB(String valueB) {
		this.valueB = valueB;
	}

	public boolean isAltC() {
		return altC;
	}

	public void setAltC(boolean altC) {
		this.altC = altC;
	}

	public String getValueC() {
		return valueC;
	}

	public void setValueC(String valueC) {
		this.valueC = valueC;
	}

	public boolean isAltD() {
		return altD;
	}

	public void setAltD(boolean altD) {
		this.altD = altD;
	}

	public String getValueD() {
		return valueD;
	}

	public void setValueD(String valueD) {
		this.valueD = valueD;
	}

	public boolean isAltE() {
		return altE;
	}

	public void setAltE(boolean altE) {
		this.altE = altE;
	}

	public String getValueE() {
		return valueE;
	}

	public void setValueE(String valueE) {
		this.valueE = valueE;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public Double getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(Double questionValue) {
		this.questionValue = questionValue;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Set<Test> getTests() {
		return tests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
