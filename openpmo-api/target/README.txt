OPENPMO: SERVICES

=================================================================

RESOURCE OFFICE

DELETE BY ID => http://localhost:8080/api/office/{id}

DELETE ALL => http://localhost:8080/api/office/all

UPDATE BY ID => http://localhost:8080/api/office/id

CREATE => http://localhost:8080/api/environments

	JSON: {
		"name":"PMO-ES",
		"shortName":pmoes,			
		"schemaTemplates":[{}],  /*IS_ADOPTED_BY/*
		"schemas":[{}],          /*IS_ADOPTED_BY/*

	      }

GET ALL => http://localhost:8080/api/office
GET BY ID => http://localhost:8080/api/office/{id}

====================================================================

RESOURCE SCHEMATEMPLATE:

DELETE BY ID => http://localhost:8080/api/schematemplate/{id}

DELETE ALL => http://localhost:8080/api/schematemplate/all

UPDATE BY ID => http://localhost:8080/api/schematemplate/id

CREATE => http://localhost:8080/api/schematemplate

	JSON: {
		"name":"MODELO 15-18",
		"shortName":"modelo15-18",
		"workpackTemplates"[{}]	/*IS_ROOT_OF/*		

	      }

GET ALL => http://localhost:8080/api/schematemplate
GET BY ID => http://localhost:8080/api/schematemplate/{id}
GET BY ID OF THE ENVIRONMENT => http://localhost:8080/api/schematemplate/listschematemplates{id of the environment}

========================================================================================================

RESOURCE SCHEMA:

DELETE BY ID => http://localhost:8080/api/schema/{id}

DELETE ALL => http://localhost:8080/api/schema/all

UPDATE BY ID => http://localhost:8080/api/schema/{id}

CREATE => http://localhost:8080/api/schema

	JSON: {
		"name":"MODELO 15-18",
		"shortName":"modelo15-18",
		"workpacks":[{}], /*IS_ROOT_OF/*  
		"schemaTemplates":[{}] 	/*IS_INSTANCE_OF/*  		

	      }

GET ALL => http://localhost:8080/api/schema
GET BY ID => http://localhost:8080/api/schema/{id}
GET BY ID OF THE ENVIRONMENT => http://localhost:8080/api/schema/listschemas{id of the environment}

========================================================================================================

RESOURCE WORKPACKTEMPLATE:

DELETE BY ID => http://localhost:8080/api/workpacktemplate/{id}

DELETE ALL => http://localhost:8080/api/workpacktemplate/all

UPDATE BY ID => http://localhost:8080/api/workpacktemplate/{id}

CREATE => http://localhost:8080/api/workpacktemplate

	JSON: {
		"profile":"Projeto Estruturante",
		"shortProfile":"estruturante",
		"properties":[{}],
                "components":[{}] /*IS_IN/* 			

	      }

GET ALL => http://localhost:8080/api/workpacktemplate
GET BY ID => http://localhost:8080/api/workpacktemplate/{id}
GET BY ID OF THE SCHEMATEMPLATE => http://localhost:8080/api/workpacktemplate/listworkpacktemplates{id of the schemaTemplate}
GET ALL PROPERTIES => http://localhost:8080/api/workpacktemplate/properties

========================================================================================================

RESOURCE WORKPACK:

DELETE BY ID => http://localhost:8080/api/workpack/{id}

DELETE ALL => http://localhost:8080/api/workpack/all

UPDATE BY ID => http://localhost:8080/api/workpack/{id}

CREATE => http://localhost:8080/api/workpack

	JSON: {
		"name":"Projeto Estruturante",
		"shortName":"estruturante",
		"properties":[{}],
		"components":[{}], /*IS_IN/* 
		"workpackTemplates":[{}] /*IS_INSTANCE_OF/*  

			

	      }

GET ALL => http://localhost:8080/api/workpack
GET BY ID => http://localhost:8080/api/workpack/{id}
GET BY ID => http://localhost:8080/api/workpack/listworkpacks/{environmentId} or {schemaId} or {workpackId}


========================================================================================================

RESOURCE PERSON

DELETE BY ID => http://localhost:8080/api/person/{id}

DELETE ALL => http://localhost:8080/api/person/all

UPDATE BY ID => http://localhost:8080/api/person/{id}

CREATE => http://localhost:8080/api/person

	JSON: {
		"name":"MARCOS" 

	      }

GET ALL => http://localhost:8080/api/person
GET BY ID => http://localhost:8080/api/person/{id}
GET BY NAME => http://localhost:8080/api/person/like/{name}


========================================================================================================

RESOURCE ORGANIZATION

DELETE BY ID => http://localhost:8080/api/organization/{id}

DELETE ALL => http://localhost:8080/api/organization/all

UPDATE BY ID => http://localhost:8080/api/organization/{id}

CREATE => http://localhost:8080/api/organization

	JSON: {
		"name":"SEP" 

	      }

GET ALL => http://localhost:8080/api/organization
GET BY ID => http://localhost:8080/api/organization/{id}
GET BY NAME => http://localhost:8080/api/organization/like/{name}

========================================================================================================

RESOURCE LOCALE

DELETE BY ID => http://localhost:8080/api/locale/{id}

DELETE ALL => http://localhost:8080/api/locale/all

UPDATE BY ID => http://localhost:8080/api/locale/{id}

CREATE => http://localhost:8080/api/locale

	JSON: {
		"name":"Vitória" 

	      }

GET ALL => http://localhost:8080/api/locale
GET BY ID => http://localhost:8080/api/locale/{id}
GET BY NAME => http://localhost:8080/api/locale/like/{name}


========================================================================================================

RESOURCE OFFICEROLE (RELATIONSHIP BETWEEN PERSON AND OFFICE

DELETE BY ID => http://localhost:8080/api/officeroles/{id}

DELETE ALL => http://localhost:8080/api/officeroles/all

UPDATE BY ID => http://localhost:8080/api/officeroles/{id}

CREATE => http://localhost:8080/api/officeroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/officeroles
GET BY ID => http://localhost:8080/api/officeroles/{id}
GET BY NAME => http://localhost:8080/api/officeroles/like/{name}

========================================================================================================

RESOURCE ORGANIZATIONROLE (RELATIONSHIP BETWEEN PERSON AND ORGANIZATION)

DELETE BY ID => http://localhost:8080/api/officeroles/{id}

DELETE ALL => http://localhost:8080/api/officeroles/all

UPDATE BY ID => http://localhost:8080/api/officeroles/{id}

CREATE => http://localhost:8080/api/officeroles

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/officeroles
GET BY ID => http://localhost:8080/api/officeroles/{id}
GET BY NAME => http://localhost:8080/api/officeroles/like/{name}


========================================================================================================

RESOURCE SCHEMAROLE (RELATIONSHIP BETWEEN PERSON AND SCHEMA)

DELETE BY ID => http://localhost:8080/api/schemarole/{id}

DELETE ALL => http://localhost:8080/api/schemarole/all

UPDATE BY ID => http://localhost:8080/api/schemarole/{id}

CREATE => http://localhost:8080/api/schemarole

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/schemarole
GET BY ID => http://localhost:8080/api/schemarole/{id}
GET BY NAME => http://localhost:8080/api/schemarole/like/{name}


========================================================================================================

RESOURCE WORKPACKROLE (RELATIONSHIP BETWEEN PERSON AND WORKPACK)

DELETE BY ID => http://localhost:8080/api/workpackrole/{id}

DELETE ALL => http://localhost:8080/api/workpackrole/all

UPDATE BY ID => http://localhost:8080/api/workpackrole/{id}

CREATE => http://localhost:8080/api/workpackrole

	JSON: {
		"name":"" 

	      }

GET ALL => http://localhost:8080/api/workpackrole
GET BY ID => http://localhost:8080/api/workpackrole/{id}
GET BY NAME => http://localhost:8080/api/workpackrole/like/{name}





