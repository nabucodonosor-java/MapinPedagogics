package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.mapin.pedagogics.entities.User;

public class UserInsertDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private LocalDate enrollmentDate;

	private String imgUrl;

	@NotBlank(message = "Campo obrigatório")
	private String name;

	@Email(message = "Digitar email válido!")
	private String email;

	@NotBlank(message = "Campo obrigatório")
	private String password;

	private Set<RoleDto> roles = new HashSet<>();

	private RoleDto roleDto = new RoleDto("STUDENT");

	public UserInsertDto() {
	}

	public UserInsertDto(User entity) {
		id = entity.getId();
		enrollmentDate = LocalDate.now();
		imgUrl = "https://mapin-pedagogics.s3.sa-east-1.amazonaws.com/user-padrao.png";
		password = entity.getPassword();
		this.roles.add(roleDto);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public RoleDto getRoleDto() {
		return roleDto;
	}

}
