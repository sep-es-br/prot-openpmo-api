package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.LocaleItem;

public interface LocaleItemRepository extends Neo4jRepository <LocaleItem, Long>{

	
	LocaleItem findByName(@Param("name") String name);
	
	Collection<LocaleItem> findByNameLike(@Param("name") String name);
	
	
	
}
