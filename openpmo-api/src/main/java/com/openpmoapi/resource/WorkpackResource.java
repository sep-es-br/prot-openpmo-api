package com.openpmoapi.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.Workpack;
import com.openpmoapi.repository.WorkpackRepository;

@RestController
@RequestMapping("/workpacks")
public class WorkpackResource {
	
	@Autowired
	private WorkpackRepository wpRepo;
	
	@PostMapping
	public ResponseEntity<Workpack> save(@Valid @RequestBody Workpack wp, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.CREATED).body(wpRepo.save(wp));
	}
}
