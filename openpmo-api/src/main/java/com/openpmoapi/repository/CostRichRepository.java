package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.CostRich;

public interface CostRichRepository extends Neo4jRepository <CostRich, Long>{

	
	
}
