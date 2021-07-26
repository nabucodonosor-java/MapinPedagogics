package com.mapin.pedagogics.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mapin.pedagogics.dto.NotificationDto;
import com.mapin.pedagogics.services.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService service;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDto>> findAll(
			@RequestParam(value = "unreadOnly", defaultValue = "false") Boolean unreadOnly,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "12") Integer size) {
				
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<NotificationDto> list = service.notificationsForCurrentUser(unreadOnly, pageRequest);
		
		return ResponseEntity.ok().body(list);

	}
	
	@PostMapping
	public ResponseEntity<NotificationDto> insert(@Valid @RequestBody NotificationDto dto) {
		NotificationDto nDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(nDto.getId()).toUri();
		return ResponseEntity.created(uri).body(nDto);
	}
}
