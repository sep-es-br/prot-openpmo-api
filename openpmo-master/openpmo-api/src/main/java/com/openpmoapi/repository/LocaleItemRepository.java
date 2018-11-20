package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.LocaleRich;

public interface LocaleItemRepository extends Neo4jRepository <LocaleRich, Long>{

	
	LocaleRich findByName(@Param("name") String name);
	
	Collection<LocaleRich> findByNameLike(@Param("name") String name);
	
	
	
}
