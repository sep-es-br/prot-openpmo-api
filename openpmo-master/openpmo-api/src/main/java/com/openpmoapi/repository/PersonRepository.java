package com.openpmoapi.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Person;

public interface PersonRepository extends Neo4jRepository <Person, Long>{

	
	Person findByName(@Param("name") String name);
	
	//Collection<Person> findByNameLike(@Param("name") String name);
	
	Collection<Person> findByNameOrderByNameAsc();
	
	public Optional<Person> findByEmail(String email);
	
	public List<Person> findByPermissoesDescricao(String permissaoDescricao);
	
	
	@Query("MATCH (p:Person) WHERE  lower(p.name) CONTAINS lower($name) RETURN p ORDER BY p.name")
	Collection<Person> findByNameLike(@Param("name") String name);
	

	
	

	
	
}
