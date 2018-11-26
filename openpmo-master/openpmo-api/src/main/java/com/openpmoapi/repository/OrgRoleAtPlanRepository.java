/**
 * 
 */
package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.OrgRoleAtOffice;
import com.openpmoapi.model.OrgRoleAtPlan;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-26
*/
public interface OrgRoleAtPlanRepository  extends Neo4jRepository<OrgRoleAtPlan, Long>{

	
	
	
}
