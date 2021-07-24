package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.mapin.pedagogics.entities.User;

public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate enrollmentDate;

	private String imgUrl;

	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@Email(message = "Digitar email válido!")
	private String email;

	private Set<RoleDto> roles = new HashSet<>();

	private List<TestDto> tests = new ArrayList<>();

	public UserDto() {
	}

	public UserDto(User entity) {
		id = entity.getId();
		enrollmentDate = entity.getEnrollmentDate();
		imgUrl = entity.getImgUrl();
		name = entity.getName();
		email = entity.getEmail();
		entity.getRoles().forEach(r -> this.roles.add(new RoleDto(r)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public List<TestDto> getTests() {
		return tests;
	}

	public static Page<UserDto> converter(Page<User> list) {
		return list.map(UserDto::new);
	}

}
