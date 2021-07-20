package com.mapin.pedagogics.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapin.pedagogics.dto.CommentDto;
import com.mapin.pedagogics.dto.NotificationDto;
import com.mapin.pedagogics.dto.RoleDto;
import com.mapin.pedagogics.dto.StudyClassDto;
import com.mapin.pedagogics.dto.UserDto;
import com.mapin.pedagogics.dto.UserInsertDto;
import com.mapin.pedagogics.entities.Comment;
import com.mapin.pedagogics.entities.Notification;
import com.mapin.pedagogics.entities.Role;
import com.mapin.pedagogics.entities.StudyClass;
import com.mapin.pedagogics.entities.User;
import com.mapin.pedagogics.repositories.CommentRepository;
import com.mapin.pedagogics.repositories.NotificationRepository;
import com.mapin.pedagogics.repositories.RoleRepository;
import com.mapin.pedagogics.repositories.StudyClassRepository;
import com.mapin.pedagogics.repositories.UserRepository;
import com.mapin.pedagogics.services.exceptions.DatabaseException;
import com.mapin.pedagogics.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private StudyClassRepository studyClassRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public Page<UserDto> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		return UserDto.converter(list);
	}
	
	@Transactional(readOnly = true)
	public UserDto findById(Long id) {
		Optional<User> optional = repository.findById(id);
		User user = optional.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new UserDto(user);
	}
	
	@Transactional
	public UserDto insert(UserInsertDto dto) {
		User user = new User();
		copyDtoToEntity(dto, user);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user = repository.save(user);
		return new UserDto(user);
	}
	
	@Transactional
	public UserDto update(Long id, UserInsertDto dto) {
		try {
			User user = repository.getOne(id);
			copyDtoToEntity(dto, user);
			user = repository.save(user);
			return new UserDto(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id Not Found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integraty Violation");
		}
	}
	
	private void copyDtoToEntity(UserInsertDto dto, User entity) {
		entity.setImgUserUrl(dto.getImgUserUrl());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		
		entity.getRoles().clear();
		entity.getComments().clear();
		entity.getNotifications().clear();
		entity.getStudyClasses().clear();
		
		for (RoleDto roleDto : dto.getRoles()) {
			Role role = (Role) roleRepository.getOne(roleDto.getId());
			entity.getRoles().add(role);
		}
		
		for (CommentDto commentDto : dto.getComments()) {
			Comment comment = commentRepository.getOne(commentDto.getId());
			entity.getComments().add(comment);
		}
		
		for (NotificationDto notificationDto : dto.getNotifications()) {
			Notification notification = notificationRepository.getOne(notificationDto.getId());
			entity.getNotifications().add(notification);
		}
		
		for (StudyClassDto studyClassDto : dto.getStudyClasses()) {
			StudyClass studyClass = studyClassRepository.getOne(studyClassDto.getId());
			entity.getStudyClasses().add(studyClass);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		
		if (user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found!");
		}
		logger.info("User found: " + username);
		return user;
	}
	
}