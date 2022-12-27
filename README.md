# CRUD Spring Boot: Lista de tareas de empleados 
Se implementó Spring JPA One-To-Many con Hibernate usando anotación @ManyToOne de forma unidireccional.
 
- se configuró Spring Data, JPA, Hibernate para trabajar con H2 en memoria
- se carga en la base de datos 2 empleados con 1 tarea para cada uno desde el archivo data.sql
- se definieron las capas de Servicio, Repositorio, Entidad, Dto y Controlador
- se manejarón las excepciones que puedan ocurrir
- se validaron los datos de entrada incluidos los ENUM para el cual se creo una validacion personalizada
- se realizaron algunos test 

Los endpoints son los siguientes:

<blockquote>http://localhost:8080/employees (obtiene una lista de todos los empleados)</blockquote>
<blockquote>http://localhost:8080/create/employee (crea un empleado. Al ser unidereccional la relacion no hace falta crear una tarea)</blockquote>
<blockquote>http://localhost:8080/delete/employee/1 (borra el empleado con id:1)</blockquote>
<blockquote>http://localhost:8080/update/employee/2 (actualiza el empleado con id:2)</blockquote>
<blockquote>http://localhost:8080/employee/1/tasks (se obtiene las tareas del empleado con id:1)</blockquote>
<blockquote>http://localhost:8080/delete/tasks/employee/1 (se borran todas las tareas del empledo con id:1)</blockquote>
<blockquote>http://localhost:8080/task/1 (se obtiene la tarea con id:1)</blockquote>
<blockquote>http://localhost:8080/create/task/employee/1 (se agrega una tarea al empledo con id:1)</blockquote>
<blockquote>http://localhost:8080/delete/task/1 (se elimina la tarea con id:1)</blockquote>
<blockquote>http://localhost:8080/update/task/3 (se actualiza la tarea con id:3)</blockquote>
