package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Cost;

public interface CostRepository extends Neo4jRepository <Cost, Long>{

	
	@Query("match (c:Cost)-[r:APPLIES_TO]->(w:Workpack) where id(w)= {id} return c,r,w")
	Collection<Cost> findCostByWpId(@Param("id") Long id);

}
