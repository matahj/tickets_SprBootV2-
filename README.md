# tickets Spring Boot V2

### Resumen
Se desarrolla una aplicación para la venta de boletos de Autobús, el backend con SpringBoot y el Frontend con Angular. El backend se despliega continuamente (CD) en Railway y el frontend en Netlify.

Frontend:

[https://resilient-kitten-27a2e6.netlify.app](https://resilient-kitten-27a2e6.netlify.app)

Backend:

[https://ticketssprbootv2-production.up.railway.app/](https://ticketssprbootv2-production.up.railway.app/)


**USER**: jorge, 1234

**ADMIN**: admin, admin1234

### Prácticas ágiles
Se tiene un respositorio y un tablero Kanban en github, cada vez que se cumple con una tarea se hace push a la rama principal y se despliega automáticamente en Railway y Netlify.

Respositorio del frontend:

[https://github.com/matahj/ticketsFront](https://github.com/matahj/ticketsFront)

Respositorio del backend:

[https://github.com/matahj/tickets_SprBootV2-](https://github.com/matahj/tickets_SprBootV2-)

Tablero:

[https://github.com/users/matahj/projects/4/views/1](https://github.com/users/matahj/projects/4/views/1)


### Especificaciones
Se tienen terminales en diferentes estados de la República, las cuales son origen y destino de los viajes. Cada terminal tiene adscritos un conjunto de autobuses y uno de conductores, los cuales son asignados a cada viaje según su disponibilidad y de manera independiente unos de otros. Los viajes son programados con origen, destino, fecha y hora de salida. El precio del boleto se establece al programar el viaje (dependiendo de diferentes factores). Todos los autobuses tienen cuarenta asientos y se clasifican en las clases primera, segunda y tercera; otras características importantes que se deben tomar en cuenta son la matrícula del autobús y su estado mecánico (operativo o en mantenimiento). Los clientes deben registrarse con: nombre completo, domicilio, correo electrónico y telefono. Cuando el cliente compra un vije selecciona un asiento. El usuario "administrador" tiene acceso y puede modificar todas las tablas (operaciones CRUD), los usuario "cliente" pueden leer "viajes", crear-leer-actualizar su propia información en "clientes" y crear-leer sus propios boletos en "boletos" (no puede hacer cancelaciones ni cambios).

![tripsSpringBootDBdeer.png](./imgs/ticketsDBv2_diagrama.png)

### Herramientas y dependencias utilizadas

Se utiliza IntelliJ como IDE, el fronend se desarrolla con Angular y el backend con Spring boot y las siguientes dependencias: Spring Web, Spring JPA, Spring Rest Repositories, Spring Validation, Spring Security, MySQL Driver, Lombok y Mapstruct.

### Compilación-Construcción-Ejecución en desarrollo

El acceso a la base de datos MySQL se configura en `src/main/resources/application.properties`. La base de datos y el usuario deben existir, en el sigueinte cuadro se muestra un ejemplo de configuración, el nombre de la base de datos es "ticketsDBv2" y el nombre del usuario es "root". 

~~~
spring.datasource.url=jdbc:mysql://localhost:3306/ticketsDBv2
spring.datasource.username=root
spring.datasource.password=root
~~~

Compilación y ejecución:
~~~
mvn clean   //opcional
mvn spring-boot:run
~~~

Para compilar y construir un archivo jar:
~~~
mvn clean   //recomendado
mvn package
~~~

Para ejecutar el jar
~~~
java -jar ./target/tripsSpringBoot-0.0.1-SNAPSHOT.jar
~~~

Los siguientes end point son públicos:

GET
~~~
http://localhost:8080/trips
http://localhost:8080/trips/{id}
~~~

Como USER, se puede acceder a los siguientes end points:

GET
~~~
http://localhost:8080/trips
http://localhost:8080/trips/{id}
http://localhost:8080/tickets
http://localhost:8080/tickets/{id}
~~~

POST
~~~
http://localhost:8080/tickets
http://localhost:8080/tickets/{id}
http://localhost:8080/users
http://localhost:8080/users/{id}
~~~

Como ADMIN, se puede acceder a los siguientes end points:

GET | POST | PUT | DELETE
~~~
http://localhost:8080/admins
http://localhost:8080/admins/{id}
http://localhost:8080/buses
http://localhost:8080/buses/{id}
http://localhost:8080/drivers
http://localhost:8080/drivers/{id}
http://localhost:8080/stations
http://localhost:8080/stations/{id}
http://localhost:8080/tickets
http://localhost:8080/tickets/{id}
http://localhost:8080/trips
http://localhost:8080/trips/{id}
http://localhost:8080/users
http://localhost:8080/users/{id}
~~~

### Despliegue

El backend se despliega en Railway y el frontend en Netlify, esto, automáticamente al hacer push a la rama main.
