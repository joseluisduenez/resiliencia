
 CREATE TABLE RS_SUSTENTABILIDAD (
    id int NOT NULL PRIMARY KEY,
    idUser	int,
 	createdAt timestamp
	sourceId int,
	benefactor TEXT,
	porcentajeAnual int,
	comentario	TEXT,
	status int
);



/*status fields
 * 0 = inactivo 
 * 1 = activo 
 */