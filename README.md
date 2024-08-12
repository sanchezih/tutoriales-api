# Tutorials
![GitHub last commit](https://img.shields.io/github/last-commit/sanchezih/tutorials-api)
![GitHub repo size](https://img.shields.io/github/repo-size/sanchezih/tutorials-api)

Aplicacion que permite administrar tutoriales.

 - Cada tutorial tiene un id, un titulo, una descripcion y un status que indica si esta publicado o no.
 - La API permite crear, obtener, actualizar y eliminar tutoriales.
 - Ademas, permite buscar tutoriales a traves de su titulo o a traves de su estado de publicacion.

## Tecnologias
- Java 21
- Spring Boot 3
- Spring Data JPA
- Maven
- H2

## Servicios
|Verbo	|Endpoint	|Funcionalidad
|---|---|---
|POST		|/api/v1/tutorials					|create new Tutorial
|GET		|/api/v1/tutorials					|retrieve all Tutorials
|GET		|/api/v1/tutorials/:id				|retrieve a Tutorial by :id
|PUT		|/api/v1/tutorials/:id				|update a Tutorial by :id
|DELETE		|/api/v1/tutorials/:id				|delete a Tutorial by :id
|DELETE		|/api/v1/tutorials					|delete all Tutorials
|GET		|/api/v1/tutorials/published		|find all published Tutorials
|GET		|/api/v1/tutorials?title=[keyword]	|find all Tutorials which title contains keyword







