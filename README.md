
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

## Instalacion

```bash
$ ./mvnw spring-boot:run
```

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

## Acceso a la consola de la DB H2
http://localhost:8080/h2-ui

- Usuario: sa
- Password: En blanco

## Inicializacion opcional de la DB H2
```sql
delete from tutorials;
insert into tutorials (title, description, published) values ('Aprende a usar Genially', 'Un microcurso autoasistido para aprender a usar Genially, una plataforma en linea para crear diversos objetos digitales interactivos.', false);
insert into tutorials (title, description, published) values ('Aprende a usar Moodle', 'Un microcurso autoasistido para aprender a usar Moodle, una plataforma educativa que permite crear ambientes de aprendizaje personalizados.', false);
insert into tutorials (title, description, published) values ('Aprende a usar YouTube', 'Un microcurso autoasistido para aprender a crear un canal propio en YouTube y usar sus potencialidades con fines pedagogicos.', false);
```





