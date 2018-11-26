package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.PersonRoleAtPlan;

public interface PersonRoleAtPlanRepository extends Neo4jRepository <PersonRoleAtPlan, Long>{

	
	//PersonRoleAtPlan findByName(@Param("name") String name);
	
	//Collection<SchemaRole> findByNameLike(@Param("name") String name);
	
	@Query("MATCH (s:PlanRole) WHERE  lower(s.name) contains lower($name) RETURN s")
	Collection<PersonRoleAtPlan> findByNameLike(@Param("name") String name);
	
	
}
