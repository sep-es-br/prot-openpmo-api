package com.openpmoapi.resource;


import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.event.FeatureCreatedEvent;
import com.openpmoapi.model.Movie;
import com.openpmoapi.repository.MovieRepository;
import com.openpmoapi.service.MovieService;

import io.swagger.annotations.Api;



@RestController
@RequestMapping("/api/movie")
@Api(value = "/api/movie",  tags = "Movie",description=" ")
public class MovieResource {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * This is method delete one Movie
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		movieRepository.deleteById(id);
	}
	
	
	/**
	 * This is method update Movie
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id, @Valid @RequestBody Movie movie) {
		Movie savedMovie = movieService.update(id, movie);
		return ResponseEntity.ok(savedMovie);
	}
	
	
	/**
		This is method save Movie
	 */
	@PostMapping
	public ResponseEntity<Movie> save(@Valid @RequestBody Movie movie, HttpServletResponse response) {
		Movie savedMovie = movieRepository.save(movie);
		publisher.publishEvent(new FeatureCreatedEvent(this, response, savedMovie.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(movieRepository.save(movie));
	}
	
	
	/**
	 * This is method find by all Movie
	 */
	@GetMapping
	public Iterable<Movie> findByAll() {
		 return movieRepository.findAll(2);
	}
	
	
	/**
			This is method find by one Movie
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id) {
		Optional<Movie> movie = movieRepository.findById(id,2);
		return movie.isPresent() ? ResponseEntity.ok(movie.get()) : ResponseEntity.notFound().build();
	}
	
	  
	
	

	
}
