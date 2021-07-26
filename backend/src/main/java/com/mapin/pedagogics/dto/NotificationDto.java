package com.mapin.pedagogics.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.mapin.pedagogics.entities.Notification;

public class NotificationDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDate publicationDate;
	
	@NotBlank(message = "Campo obrigatório")
	private String message;
	private boolean read;
	private UserDto user;

	public NotificationDto() {
	}

	public NotificationDto(Notification entity) {
		id = entity.getId();
		publicationDate = LocalDate.now();
		message = entity.getMessage();
		read = entity.isRead();
		user = new UserDto(entity.getUser());
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public static Page<NotificationDto> converter(Page<Notification> page) {
		return page.map(NotificationDto::new);
	}

}
