package com.openpmoapi.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.WorkpackTemplate;

public interface WorkpackTemplateRepository extends Neo4jRepository <WorkpackTemplate, Long>{

	
	@Query("MATCH (wptp:WorkpackTemplate)-[:IS_ROOT_OF | :IS_IN]->(s) WHERE id(s) = {id} RETURN wptp")
	Collection<WorkpackTemplate> findWptpByIdSchemaTmpl(@Param("id") Long id);


	@Query("MATCH (n:`WorkpackTemplate`) WHERE ID(n) = {id} WITH n MATCH p=(n)<-[:IS_IN*0..2]-(m) RETURN n")
	Optional<WorkpackTemplate> findWpByIdWorkpackTmpl(@Param("id") Long id);
	
}
