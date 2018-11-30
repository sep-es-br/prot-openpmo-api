/**
 * 
 */
package com.openpmoapi.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Movie;
import com.openpmoapi.repository.MovieRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class MovieService {

	
	@Autowired
	private MovieRepository movieRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	
	 */
	@Transactional(readOnly = false)
	public Movie update(Long id, Movie movie) {
		Movie savedMovie = findMovieById(id);
		BeanUtils.copyProperties(movie, savedMovie, "id", "movie");
		return movieRepository.save(savedMovie);
	}
	
	
	
	/**
	 * this method find by id a data type Movie, if not exist it treats the exception 
	 * @return
	 */
	@Transactional(readOnly = true)
	public Movie findMovieById(Long id) {
		Optional<Movie> savedMovie = movieRepository.findById(id);
		if (!savedMovie.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedMovie.get();
	}
	
	
	

	
	
	
}
