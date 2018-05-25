
 CREATE TABLE RS_GENERAL_DATA (
    id int NOT NULL PRIMARY KEY,
    createdAt timestamp,
    idUser		int,
    proyectoReciente	TEXT,
    nombre	TEXT,
    razonSocial	TEXT,
    rfc		TEXT,
    clasificationId	int,
    fechaConstitucion timestamp,
    inicioOperacion		timestamp,
    propertyTypeId		int,
    comentarios			TEXT,
    calle				TEXT,
    numero				int,
    colonia				TEXT,
    codigoPostal		int,
    ciudadId			int,
    estadoId			int,
    pais				TEXT,
    telefonoOficina		int,
    www					TEXT,
    email				TEXT,
    nombreDelContacto	TEXT,
    telefonoDeContacto	int,
    emailDeContacto		TEXT
    
 	
);
