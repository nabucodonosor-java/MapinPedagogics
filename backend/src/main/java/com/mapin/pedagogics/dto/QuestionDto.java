package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.mapin.pedagogics.entities.Question;

public class QuestionDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

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

	private String studentAnswer;

	private String rightAnswer;
	private Double questionValue;
	private Double score;

	private TopicDto topic;

	private Set<TestDto> tests = new HashSet<>();

	private QuestionTypeDto questionType;

	public QuestionDto() {
	}

	public QuestionDto(Question entity) {
		id = entity.getId();
		questionStatement = entity.getQuestionStatement();
		altA = entity.isAltA();
		valueA = entity.getValueA();
		altB = entity.isAltB();
		valueB = entity.getValueB();
		altC = entity.isAltC();
		valueC = entity.getValueC();
		altD = entity.isAltD();
		valueD = entity.getValueD();
		altE = entity.isAltE();
		valueE = entity.getValueE();
		studentAnswer = entity.getStudentAnswer();
		rightAnswer = entity.getRightAnswer();
		questionValue = entity.getQuestionValue();
		score = entity.getScore();
		topic = new TopicDto(entity.getTopic());
		questionType = new QuestionTypeDto(entity.getQuestionType());
		entity.getTests().forEach(t -> this.tests.add(new TestDto(t)));
	}

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

	public TopicDto getTopic() {
		return topic;
	}

	public void setTopic(TopicDto topic) {
		this.topic = topic;
	}

	public QuestionTypeDto getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionTypeDto questionType) {
		this.questionType = questionType;
	}

	public Set<TestDto> getTests() {
		return tests;
	}

}
