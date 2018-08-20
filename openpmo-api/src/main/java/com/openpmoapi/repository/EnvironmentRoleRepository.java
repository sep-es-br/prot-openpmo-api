package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.EnvironmentRole;

public interface EnvironmentRoleRepository extends Neo4jRepository <EnvironmentRole, Long>{

	
	EnvironmentRole findByName(@Param("name") String name);
	
	//Collection<EnvironmentRole> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (e:EnvironmentRole) WHERE  lower(e.name) contains lower($name) RETURN e")
	Collection<EnvironmentRole> findByNameLike(@Param("name") String name);
	
}
