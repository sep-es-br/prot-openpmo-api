package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.openpmoapi.model.Role;

public interface RoleRepository extends Neo4jRepository <Role, Long>{

	
	
	
}
