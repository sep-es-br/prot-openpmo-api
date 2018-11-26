package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.PersonRoleAtWorkpack;

public interface PersonRoleAtWorkpackRepository extends Neo4jRepository <PersonRoleAtWorkpack, Long>{

	
	//PersonRoleAtWorkpack findByName(@Param("name") String name);
	
	//Collection<WorkpackRole> findByNameLike(@Param("name") String name);
	
	
	@Query("MATCH (e:WorkpackRole) WHERE  lower(e.name) contains lower($name) RETURN e")
	Collection<PersonRoleAtWorkpack> findByNameLike(@Param("name") String name);
}
