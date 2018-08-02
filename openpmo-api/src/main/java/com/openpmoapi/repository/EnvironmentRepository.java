package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.Environment;

public interface EnvironmentRepository extends Neo4jRepository <Environment, Long>{

}
