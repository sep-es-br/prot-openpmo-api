/**
 * 
 */
package com.openpmoapi.model;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

/**
* This is a relationship between an environment and a schema.
*
* @author vagner.cordeiro  
* @since 2018-08-01
*/
@RelationshipEntity(type="IS_ADOPTED_BY")
public class Adoption {
	
	@Id @GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}

	
	@StartNode
	private Schema schema;
	public Schema getSchema() {
		return schema;
	}
	public void setSchema(Schema schema) {
		this.schema = schema;
	}
	
	@EndNode
	private Environment environment;
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DateString
	private Date periodStart;
	public Date getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}
	
	@DateString
	private Date periodEnd;
	public Date getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
	
	
	
	
}
