package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.BaseLine;

public interface BaseLineRepository extends Neo4jRepository <BaseLine, Long>{

	
	
}
