package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.SchemaRole;

public interface SchemaRoleRepository extends Neo4jRepository <SchemaRole, Long>{

	
	SchemaRole findByName(@Param("name") String name);
	
	//Collection<SchemaRole> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (s:SchemaRole) WHERE  lower(s.name) contains lower($name) RETURN s")
	Collection<SchemaRole> findByNameLike(@Param("name") String name);
	
	
}
