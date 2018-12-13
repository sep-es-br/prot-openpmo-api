package com.openpmoapi.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Person;

public interface PersonRepository extends Neo4jRepository <Person, Long>{

	
	Person findByName(@Param("name") String name);
	
	//Collection<Person> findByNameLike(@Param("name") String name);
	
	Collection<Person> findByNameOrderByNameAsc();
	
	
	@Query("MATCH (p:Person) WHERE  lower(p.name)  CONTAINS lower($name) or lower(p.fullName) CONTAINS lower($name) RETURN p ORDER BY p.name")
	Collection<Person> findByNameLike(@Param("name") String name);

	

	Optional<Person> findByUserName(@Param("userName") String userName);
	

	
	

	
	
}
