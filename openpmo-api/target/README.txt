OPENPMO: SERVICES

=================================================================

RESOURCE ENVIRONMENT:

DELETE BY ID => http://localhost:8080/api/environments/{id}

DELETE ALL => http://localhost:8080/api/environments/all

UPDATE BY ID => http://localhost:8080/api/environments/id

CREATE => http://localhost:8080/api/environments

	JSON: {
		"name":"PMO-ES",
		"shortName":pmoes,			
		"schemaTemplates":[{}],  /*IS_ADOPTED_BY/*
		"schemas":[{}],          /*IS_ADOPTED_BY/*

	      }

GET ALL => http://localhost:8080/api/environments
GET BY ID => http://localhost:8080/api/environments/{id}

====================================================================

RESOURCE SCHEMATEMPLATE:

DELETE BY ID => http://localhost:8080/api/schematemplates/{id}

DELETE ALL => http://localhost:8080/api/schematemplates/all

UPDATE BY ID => http://localhost:8080/api/schematemplates/id

CREATE => http://localhost:8080/api/schematemplates

	JSON: {
		"name":"MODELO 15-18",
		"shortName":"modelo15-18",
		"workpackTemplates"[{}]	/*IS_ROOT_OF/*		

	      }

GET ALL => http://localhost:8080/api/schematemplates
GET BY ID => http://localhost:8080/api/schematemplates/{id}
GET BY ID OF THE ENVIRONMENT => http://localhost:8080/api/schematemplates/listschematemplates{id of the environment}

========================================================================================================

RESOURCE SCHEMA:

DELETE BY ID => http://localhost:8080/api/schemas/{id}

DELETE ALL => http://localhost:8080/api/schemas/all

UPDATE BY ID => http://localhost:8080/api/schemas/id

CREATE => http://localhost:8080/api/schemas

	JSON: {
		"name":"MODELO 15-18",
		"shortName":"modelo15-18",
		"workpacks":[{}], /*IS_ROOT_OF/*  
		"schemaTemplates":[{}] 	/*IS_INSTANCE_OF/*  		

	      }

GET ALL => http://localhost:8080/api/schemas
GET BY ID => http://localhost:8080/api/schemas/{id}
GET BY ID OF THE ENVIRONMENT => http://localhost:8080/api/schemas/listschemas{id of the environment}

========================================================================================================

RESOURCE WORKPACKTEMPLATE:

DELETE BY ID => http://localhost:8080/api/workpacktemplates/{id}

DELETE ALL => http://localhost:8080/api/workpacktemplates/all

UPDATE BY ID => http://localhost:8080/api/workpacktemplates/id

CREATE => http://localhost:8080/api/workpacktemplates

	JSON: {
		"profile":"Projeto Estruturante",
		"shortProfile":"estruturante",
		"properties":[{}],
                "components":[{}] /*IS_IN/* 			

	      }

GET ALL => http://localhost:8080/api/workpacktemplates
GET BY ID => http://localhost:8080/api/workpacktemplates/{id}
GET BY ID OF THE SCHEMATEMPLATE => http://localhost:8080/api/workpacktemplates/listworkpacktemplates{id of the schemaTemplate}

========================================================================================================

RESOURCE WORKPACK:

DELETE BY ID => http://localhost:8080/api/workpacks/{id}

DELETE ALL => http://localhost:8080/api/workpacks/all

UPDATE BY ID => http://localhost:8080/api/workpacks/id

CREATE => http://localhost:8080/api/workpacks

	JSON: {
		"name":"Projeto Estruturante",
		"shortName":"estruturante",
		"properties":[{}],
		"components":[{}], /*IS_IN/* 
		"workpackTemplates":[{}] /*IS_INSTANCE_OF/*  

			

	      }

GET ALL => http://localhost:8080/api/workpacks
GET BY ID => http://localhost:8080/api/workpacks/{id}
GET BY ID OF THE SCHEMA => http://localhost:8080/api/workpack/listworkpacks{id of the schema}



