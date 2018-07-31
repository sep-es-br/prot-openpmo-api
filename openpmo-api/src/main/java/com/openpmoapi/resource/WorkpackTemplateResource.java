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

import com.openpmoapi.model.WorkpackTemplate;
import com.openpmoapi.repository.WorkpackTemplateRepository;

@RestController
@RequestMapping("/workpacktemplates")
public class WorkpackTemplateResource {
	
	@Autowired
	private WorkpackTemplateRepository wptmplRepo;
	
	@PostMapping
	public ResponseEntity<WorkpackTemplate> save(@Valid @RequestBody WorkpackTemplate wpTmpl, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.CREATED).body(wptmplRepo.save(wpTmpl));
	}
}
