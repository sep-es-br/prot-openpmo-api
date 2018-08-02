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

import com.openpmoapi.model.Adoption;
import com.openpmoapi.repository.AdoptionRepository;


@RestController
@RequestMapping("/adoptions")
public class AdoptionResource {
	
	@Autowired
	private AdoptionRepository adoptionRepo;
	
	@PostMapping
	public ResponseEntity<Adoption> save(@Valid @RequestBody Adoption adoption, HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.CREATED).body(adoptionRepo.save(adoption));
	}
}
