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

import com.mapin.pedagogics.dto.RoleDto;
import com.mapin.pedagogics.dto.UserDto;
import com.mapin.pedagogics.dto.UserInsertDto;
import com.mapin.pedagogics.entities.Role;
import com.mapin.pedagogics.entities.User;
import com.mapin.pedagogics.repositories.RoleRepository;
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
		entity.setImgUrl(dto.getImgUrl());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		
		entity.getRoles().clear();
		
		for (RoleDto roles : dto.getRoles()) {
			Role role = roleRepository.getOne(roles.getId());
			entity.getRoles().add(role);
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