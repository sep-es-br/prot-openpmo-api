package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.WorkpackTemplate;

public interface WorkpackTemplateRepository extends Neo4jRepository <WorkpackTemplate, Long>{

}
