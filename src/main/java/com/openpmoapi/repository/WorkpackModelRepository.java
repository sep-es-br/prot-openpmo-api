package com.openpmoapi.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.WorkpackModel;

public interface WorkpackModelRepository extends Neo4jRepository <WorkpackModel, Long>{

	
	@Query("MATCH (wptp:WorkpackModel)-[:IS_ROOT_OF | :IS_IN]->(s) WHERE id(s) = {id} RETURN wptp")
	Collection<WorkpackModel> findWpmByIdPlanStructure(@Param("id") Long id);


	@Query("MATCH (n:`WorkpackModel`) WHERE ID(n) = {id} WITH n MATCH p=(n)<-[:IS_IN*0..2]-(m) RETURN n")
	Optional<WorkpackModel> findWpByIdWorkpackModel(@Param("id") Long id);
	
}
