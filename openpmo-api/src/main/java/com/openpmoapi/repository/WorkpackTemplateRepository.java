package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.WorkpackTemplate;

public interface WorkpackTemplateRepository extends Neo4jRepository <WorkpackTemplate, Long>{

	
	@Query("MATCH (wptp:WorkpackTemplate)-[:IS_ROOT_OF | :IS_IN]->(s) WHERE id(s) = {id} RETURN wptp")
	Collection<WorkpackTemplate> findWptpByIdSchemaTmpl(@Param("id") Long id);
	
}
