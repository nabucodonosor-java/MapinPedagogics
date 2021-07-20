package com.mapin.pedagogics.dto;

import java.io.Serializable;
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
	@NotBlank(message = "Campo obrigatório")
	private String name;
	@Email(message = "Digitar email válido!")
	private String email;

	private Set<RoleDto> roles = new HashSet<>();

	private List<CommentDto> comments = new ArrayList<>();

	private List<NotificationDto> notifications = new ArrayList<>();

	private Set<StudyClassDto> studyClasses = new HashSet<>();

	public UserDto() {
	}

	public UserDto(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		entity.getRoles().forEach(r -> this.roles.add(new RoleDto(r)));
		entity.getComments().forEach(c -> this.comments.add(new CommentDto(c)));
		entity.getNotifications().forEach(n -> this.notifications.add(new NotificationDto(n)));
		entity.getStudyClasses().forEach(s -> this.studyClasses.add(new StudyClassDto(s)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static Page<UserDto> converter(Page<User> list) {
		return list.map(UserDto::new);
	}

}
