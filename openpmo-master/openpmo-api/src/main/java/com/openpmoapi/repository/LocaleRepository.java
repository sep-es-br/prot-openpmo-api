package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Locale;

public interface LocaleRepository extends Neo4jRepository <Locale, Long>{

	
	Locale findByName(@Param("name") String name);
	
	//Collection<Locale> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (l:Locale) WHERE  lower(l.name) contains lower($name) RETURN l")
	Collection<Locale> findByNameLike(@Param("name") String name);
	
}
