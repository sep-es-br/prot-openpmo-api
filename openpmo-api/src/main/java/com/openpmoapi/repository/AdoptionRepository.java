package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.Adoption;

public interface AdoptionRepository extends Neo4jRepository <Adoption, Long>{

}
