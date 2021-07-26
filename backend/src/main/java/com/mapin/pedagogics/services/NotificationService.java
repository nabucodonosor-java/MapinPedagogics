package com.mapin.pedagogics.services;

import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapin.pedagogics.dto.NotificationDto;
import com.mapin.pedagogics.entities.Notification;
import com.mapin.pedagogics.entities.User;
import com.mapin.pedagogics.repositories.NotificationRepository;
import com.mapin.pedagogics.services.exceptions.DatabaseException;
import com.mapin.pedagogics.services.exceptions.ResourceNotFoundException;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<NotificationDto> notificationsForCurrentUser(boolean unreadOnly, Pageable pageable) {
		User user = authService.authenticated();
		Page<Notification> page = repository.find(user, unreadOnly, pageable);
		return NotificationDto.converter(page);
	}
	
	@Transactional
	public NotificationDto insert(NotificationDto dto) {
		Notification entity = new Notification();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new NotificationDto(entity);
	}
	
	@Transactional
	public NotificationDto update(Long id, NotificationDto dto) {
		
		try {
			
			Notification entity = new Notification();
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new NotificationDto(entity);
			
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id de usuário não encontrado! " + id);
		}
	}
	
	public void delete(Long id) {
		try {

			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id de usuário não encontrado! " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de Integridade do DB");
		}
	}

	private void copyDtoToEntity(NotificationDto dto, Notification entity) {
		
		if (entity.getPublicationDate() == null) {
			entity.setPublicationDate(LocalDate.now());
		}
		
		entity.setRead(dto.isRead());
		
		entity.setMessage(dto.getMessage());
		
		entity.setUser(new User(dto.getUser()));
	}

}
