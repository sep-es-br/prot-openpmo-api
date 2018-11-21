package com.openpmoapi.repository;

import java.util.Collection;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import com.openpmoapi.model.Plan;

public interface PlanRepository extends Neo4jRepository <Plan, Long>{

	
	@Query("MATCH (s1:Plan)-[:IS_ADOPTED_BY]->(env:Office) WHERE id(env) = {id} RETURN s1")
	Collection<Plan> findPlanByIdEnveronment(@Param("id") Long id);
	
	

	@Query("match (n:Workpack)-[r1:IS_IN*0..]->(m:Workpack)-[r2:IS_ROOT_OF*0..]->(s:Plan) where id(s)={id} return ()-[r1*0..]->()-[r2*0..]->()")
	Collection<Plan> findPlanByIdTree(@Param("id") Long id);
	
	
	
	
}
