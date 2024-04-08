# Tomcat and Postgres Demo
FabricSoul

## How to run
Navigate to current directory and run the following command:
```bash
docker compose up
```

Opem a web browser and navigate to `http://localhost:8080/assignment4/` to view the web application.

- note that the database data is volumed into postgres_data directory, so the data will persist even if the container is removed.
- There is no users created by default, so you will need to create a user to login.

The password is hased using SHA-256 in the database.

## Design Choices
### General Design
- The database is setup using a docker container with a volume to persist the data.
- The web application is setup using a docker container with a volume to persist the code.
- The deployment is done using docker-compose to simplify the process.
### Database
- The schema is designed to have a users table with `username`,`hashed_password`, and `salt` columns for security purposes.
- The hashed_password is hashed using SHA-256 and the salt is randomly generated.
### Web Application
- The web application is designed to have a login page and a register page using servlets for security purposes.

## Dependencies
- Docker
- Docker-compose

