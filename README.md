# ApiAlura
 API
EXECUTE THIS CODE IN ORDER TO RUN API.

CREATE DATABASE apialura;

USE apialura;

CREATE TABLE tema(

id int NOT NULL PRIMARY KEY auto_increment, nombre VARCHAR(20), descripcion VARCHAR (100) );

INSERT INTO tema(nombre, descripcion) VALUES ("Tema 1", "Aqui se adjuntaria descripcion sobre el tema 1");

SELECT * FROM tema;
