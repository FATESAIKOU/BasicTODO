# Basic TODO Application

## Overview
This is a basic TODO application with a backend and frontend. The backend is built with Java and Spring Boot, and the frontend is built with React.

## Prerequisites
- Docker
- Docker Compose
- Java 21+
- Node.js 14+

## Project Structure
```
basicTODO/
├── backend/
│   ├── .gradle/
│   ├── bin/
│   ├── build/
│   ├── gradle/
│   ├── src/
│   ├── build.gradle
│   ├── gradlew
│   └── settings.gradle
├── frontend/
│   ├── dist/
│   ├── src/
│   ├── index.html
│   ├── package-lock.json
│   ├── package.json
│   ├── vite.config.js
│   └── vitest.config.js
├── docker-compose.yml
├── Dockerfile
└── README.md
```

## Backend Configuration
The backend configuration is specified in the `application.properties` file located in the `backend` directory.

### application.properties
```properties
server.port=8080
service.data-file-path=./data/todos.json
spring.web.resources.static-locations=file:./frontend/dist/
spring.jackson.serialization.indent_output=true
```

## Frontend Configuration
The frontend configuration is specified in the `package.json` file located in the `frontend` directory.

## Docker Configuration
The Docker configuration is specified in the `docker-compose.yml` file located in the root directory.

### docker-compose.yml
```yaml
version: '3.8'

services:
  web:
    build:
      context: .
      dockerfile: ./Dockerfile
    ports:
      - "8080:8080"
    environment:
      - SERVICE_DATA-FILE-PATH=/data/todos.json
    volumes:
      - ./data/todos.json:/data/todos.json
```

## Running the Application
To run the application, use Docker Compose:

```sh
docker-compose up --build
```

This will start the services.

## Building the Frontend
To build the frontend, navigate to the `frontend` directory and run:

```sh
npm install
npm run build
```

The build artifacts will be stored in the `frontend/dist` directory.

## Building the Backend
To build the backend, navigate to the `backend` directory and run:

```sh
./gradle build
```

The build artifacts will be stored in the `backend/target` directory.