package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.PlanRole;

public interface PlanRoleRepository extends Neo4jRepository <PlanRole, Long>{

	
	PlanRole findByName(@Param("name") String name);
	
	//Collection<SchemaRole> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (s:PlanRole) WHERE  lower(s.name) contains lower($name) RETURN s")
	Collection<PlanRole> findByNameLike(@Param("name") String name);
	
	
}
