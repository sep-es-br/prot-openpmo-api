package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.PlanStructure;

public interface PlanStructureRepository extends Neo4jRepository <PlanStructure, Long>{

	
	@Query("MATCH (s1:PlanStructure)-[:IS_ADOPTED_BY]->(env:Office) WHERE id(env) = {id} RETURN s1")
	Collection<PlanStructure> findPlanStructureByIdEnvironment(@Param("id") Long id);
	
	
	@Query("match (n:WorkpackModel)-[r1:IS_IN*0..]->(m:WorkpackModel)-[r2:IS_ROOT_OF*0..]->(s:PlanStructure) where id(s)={id} return ()-[r1*0..]->()-[r2*0..]->()")
	Collection<PlanStructure> findPlanStructureByIdTree(@Param("id") Long id);
	
}
