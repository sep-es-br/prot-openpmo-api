package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.CostEntry;

public interface CostEntryRepository extends Neo4jRepository <CostEntry, Long>{

	
	
}
