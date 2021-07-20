package com.mapin.pedagogics.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.mapin.pedagogics.entities.User;

public class UserInsertDto extends UserDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo obrigatório")
	private String password;
	
	public UserInsertDto() {
	}

	public UserInsertDto(User entity) {
		super(entity);
		password = entity.getPassword();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
