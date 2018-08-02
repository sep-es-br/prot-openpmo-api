package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.Workpack;

public interface WorkpackRepository extends Neo4jRepository <Workpack, Long>{

}
