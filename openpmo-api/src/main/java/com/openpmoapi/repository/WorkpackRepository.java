package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Workpack;

public interface WorkpackRepository extends Neo4jRepository <Workpack, Long>{
	
	
	@Query("MATCH (w:Workpack)-[:IS_ROOT_OF | :IS_IN]->(n) WHERE id(n) = {id} RETURN w")
	Collection<Workpack> findWpByIdSchema(@Param("id") Long id);
	

	
	@Query("match (n:Workpack)-[r:IS_IN*0..]->(m:Workpack) where id(m)={id} return ()-[r*0..]->()")
	Collection<Workpack> findWpByIdWorkpack(@Param("id") Long id);
	
	
}
