# ComicsAPI
Simple REST API and HTML views for comics characters
## Goals
* Develop a Spring Boot application with PostreSQL database
* Use Flyway to manage the database schema
* Create HTML templates with Thymeleaf and Bootstrap
* Use Docker and Docker Compose to deploy database and application in separate containers
## Development
1. Run PostgreSQL database as Docker container:
	+ Build database container: `docker-compose build database`
	+ Start database container: `docker-compose up database`
	+ Stop database container: `docker-compose down database`
2. Run Spring Boot application with JVM argument `-Dspring.profiles.active=dev`
## Deployment
1. Build Spring Boot application into JAR: `./gradlew bootJar`
2. Run PostreSQL database and Spring Boot application as Docker containers:
	+ Build database and application containers: `docker-compose build`
	+ Start database and application containers: `docker-compose up`
	+ Stop database and application containers: `docker-compose down`
