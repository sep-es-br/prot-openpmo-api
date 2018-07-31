package com.openpmoapi.model;

import org.neo4j.ogm.annotation.NodeEntity;

/**
* Class of the real workpack created from a workpack template.
*
* @author vagner.cordeiro  
* @since 2018-jul-31
*/
@NodeEntity(label="Workpack")
public class Workpack extends WorkpackTemplate{
	
}
