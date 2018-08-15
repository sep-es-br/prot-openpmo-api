package com.openpmoapi.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.openpmoapi.model.Organization;

public interface OrganizationRepository extends Neo4jRepository <Organization, Long>{

	
	Organization findByName(@Param("name") String name);
	
	Collection<Organization> findByNameLike(@Param("name") String name);
	
	
	
}
