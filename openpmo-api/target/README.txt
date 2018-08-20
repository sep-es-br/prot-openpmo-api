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

UPDATE BY ID => http://localhost:8080/api/schemas/{id}

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

UPDATE BY ID => http://localhost:8080/api/workpacktemplates/{id}

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

UPDATE BY ID => http://localhost:8080/api/workpacks/{id}

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
GET BY ID => http://localhost:8080/api/workpack/listworkpacks/{environmentId} or {schemaId} or {workpackId}


========================================================================================================

RESOURCE PERSON

DELETE BY ID => http://localhost:8080/api/persons/{id}

DELETE ALL => http://localhost:8080/api/persons/all

UPDATE BY ID => http://localhost:8080/api/persons/{id}

CREATE => http://localhost:8080/api/persons

	JSON: {
		"name":"MARCOS" 

	      }

GET ALL => http://localhost:8080/api/persons
GET BY ID => http://localhost:8080/api/persons/{id}
GET BY NAME => http://localhost:8080/api/persons/like/{name}


========================================================================================================

RESOURCE ORGANIZATION

DELETE BY ID => http://localhost:8080/api/organizations/{id}

DELETE ALL => http://localhost:8080/api/organizations/all

UPDATE BY ID => http://localhost:8080/api/organizations/{id}

CREATE => http://localhost:8080/api/organizations

	JSON: {
		"name":"SEP" 

	      }

GET ALL => http://localhost:8080/api/organizations
GET BY ID => http://localhost:8080/api/organizations/{id}
GET BY NAME => http://localhost:8080/api/organizations/like/{name}

========================================================================================================

RESOURCE LOCALE

DELETE BY ID => http://localhost:8080/api/locales/{id}

DELETE ALL => http://localhost:8080/api/locales/all

UPDATE BY ID => http://localhost:8080/api/locales/{id}

CREATE => http://localhost:8080/api/locales

	JSON: {
		"name":"Vitória" 

	      }

GET ALL => http://localhost:8080/api/locales
GET BY ID => http://localhost:8080/api/locales/{id}
GET BY NAME => http://localhost:8080/api/locales/like/{name}


========================================================================================================

RESOURCE ENVIRONMENTROLE (RELATIONSHIP BETWEEN PERSON AND ENVIRONMENT)

DELETE BY ID => http://localhost:8080/api/environmentroles/{id}

DELETE ALL => http://localhost:8080/api/environmentroles/all

UPDATE BY ID => http://localhost:8080/api/environmentroles/{id}

CREATE => http://localhost:8080/api/environmentroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/environmentroles
GET BY ID => http://localhost:8080/api/environmentroles/{id}
GET BY NAME => http://localhost:8080/api/environmentroles/like/{name}

========================================================================================================

RESOURCE ORGANIZATIONROLE (RELATIONSHIP BETWEEN PERSON AND ORGANIZATION)

DELETE BY ID => http://localhost:8080/api/organizationroles/{id}

DELETE ALL => http://localhost:8080/api/organizationroles/all

UPDATE BY ID => http://localhost:8080/api/organizationroles/{id}

CREATE => http://localhost:8080/api/organizationroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/organizationroles
GET BY ID => http://localhost:8080/api/organizationroles/{id}
GET BY NAME => http://localhost:8080/api/organizationroles/like/{name}


========================================================================================================

RESOURCE SCHEMAROLE (RELATIONSHIP BETWEEN PERSON AND SCHEMA)

DELETE BY ID => http://localhost:8080/api/schemaroles/{id}

DELETE ALL => http://localhost:8080/api/schemaroles/all

UPDATE BY ID => http://localhost:8080/api/schemaroles/{id}

CREATE => http://localhost:8080/api/schemaroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/schemaroles
GET BY ID => http://localhost:8080/api/schemaroles/{id}
GET BY NAME => http://localhost:8080/api/schemaroles/like/{name}


========================================================================================================

RESOURCE WORKPACKROLE (RELATIONSHIP BETWEEN PERSON AND WORKPACK)

DELETE BY ID => http://localhost:8080/api/workpackroles/{id}

DELETE ALL => http://localhost:8080/api/workpackroles/all

UPDATE BY ID => http://localhost:8080/api/workpackroles/{id}

CREATE => http://localhost:8080/api/workpackroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/workpackroles
GET BY ID => http://localhost:8080/api/workpackroles/{id}
GET BY NAME => http://localhost:8080/api/workpackroles/like/{name}





