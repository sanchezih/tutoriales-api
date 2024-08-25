
# Tutoriales API
![GitHub last commit](https://img.shields.io/github/last-commit/sanchezih/tutoriales-api)
![GitHub repo size](https://img.shields.io/github/repo-size/sanchezih/tutoriales-api)

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

## Compilacion y ejecucion

```bash
$ ./mvnw spring-boot:run
```

## Servicios
|Verbo	|Endpoint	|Funcionalidad
|---|---|---
|POST		|/api/v1/tutoriales					|Crea un tutorial
|GET		|/api/v1/tutoriales					|Retorna todos los tutoriales
|GET		|/api/v1/tutoriales/:id				|Retorna un tutorial en base a su id
|PUT		|/api/v1/tutoriales/:id				|Actualiza un tutorial en base a su id
|DELETE		|/api/v1/tutoriales/:id				|Elimina un tutorial en base a su id
|DELETE		|/api/v1/tutoriales					|Elimina todos los tutoriales
|GET		|/api/v1/tutoriales/published		|Retorna todos los tutoriales publicados
|GET		|/api/v1/tutoriales?titulo=[keyword]	|Retorna todos los tutoriales que contengan en su titulo la keyword

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





