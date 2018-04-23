
 CREATE TABLE RS_USER (
    id SERIAL NOT NULL PRIMARY KEY,
    createdAt timestamp,
    name 		TEXT,
 	password	TEXT,
 	role 	int,
 	status int
 	
);