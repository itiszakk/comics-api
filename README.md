# ComicsAPI
Simple REST API for comics characters

## Development
1. Run database as Docker container:
	+ Start: `docker-compose up database`
	+ Stop: `docker-compose down database`
2. Run application via IDE
## Deployment
1. Build application into JAR: `./gradlew bootJar`
2. Build application Docker image: `docker-compose build`
3. Run database and application as Docker containers:
	+ Start: `docker-compose up`
	+ Stop: `docker-compose down`
