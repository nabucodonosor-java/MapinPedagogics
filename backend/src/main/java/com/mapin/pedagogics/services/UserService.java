package com.mapin.pedagogics.services;

import java.util.Arrays;
import java.util.List;
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
import com.mapin.pedagogics.dto.UserUpdateDto;
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
	public Page<UserDto> findAllPaged(PageRequest pageRequest, Long roleId, String name) {
		List<Role> roles = (roleId == 0) ? null : Arrays.asList(roleRepository.getOne(roleId));
		Page<User> page = repository.find(roles, name, pageRequest);
		repository.find(page.toList());
		return page.map(x -> new UserDto(x));
	}

	@Transactional(readOnly = true)
	public UserDto findById(Long id) {
		Optional<User> optional = repository.findById(id);
		User entity = optional.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado!"));
		return new UserDto(entity);
	}

	@Transactional
	public UserDto insert(UserInsertDto dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity = repository.save(entity);
		return new UserDto(entity);
	}

	@Transactional
	public UserDto update(Long id, UserUpdateDto dto) {
		try {
			User user = repository.getOne(id);
			copyDtoToEntity(dto, user);
			user = repository.save(user);
			return new UserDto(user);
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

	private void copyDtoToEntity(UserDto dto, User entity) {
		entity.setImgUrl(dto.getImgUrl());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());

		entity.getRoles().clear();
		
		entity.getRoles().add(new Role(1L, "ROLE_STUDENT"));

		/* for (RoleDto roles : dto.getRoles()) {
			Role role = roleRepository.getOne(roles.getId());
			entity.getRoles().add(role);
		}*/

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);

		if (user == null) {
			logger.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("Email não encontrado!");
		}
		logger.info("Usuário encontrado: " + username);
		return user;
	}

}