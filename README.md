# TODO Application

This is a simple TODO application built with a Spring Boot backend and a React frontend. The application allows users to manage their TODO items through a RESTful API and a user-friendly interface.

## Project Structure

```
todo-app
├── backend                # Spring Boot backend
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── todo
│   │   │   │               ├── TodoApplication.java
│   │   │   │               ├── controller
│   │   │   │               │   └── TodoController.java
│   │   │   │               ├── model
│   │   │   │               │   └── Todo.java
│   │   │   │               └── service
│   │   │   │                   └── TodoService.java
│   │   │   ├── resources
│   │   │       ├── application.properties
│   │   │       └── todos.json
│   ├── build.gradle
│   └── settings.gradle
├── frontend               # React frontend
│   ├── src
│   │   ├── App.jsx
│   │   ├── components
│   │   │   └── TodoList.jsx
│   │   ├── index.css
│   │   └── main.jsx
│   ├── index.html
│   ├── package.json
│   ├── vite.config.js
│   └── vitest.config.js
├── docker-compose.yml     # Docker Compose configuration
├── Dockerfile.backend      # Dockerfile for backend
├── Dockerfile.frontend     # Dockerfile for frontend
└── README.md              # Project documentation
```

## Getting Started

### Prerequisites

- Java 21
- Gradle
- Node.js
- Docker and Docker Compose

### Backend Setup

1. Navigate to the `backend` directory.
2. Build the backend application using Gradle:
   ```
   ./gradlew build
   ```
3. Run the application:
   ```
   ./gradlew bootRun
   ```

### Frontend Setup

1. Navigate to the `frontend` directory.
2. Install the dependencies:
   ```
   npm install
   ```
3. Start the development server:
   ```
   npm run dev
   ```

### Docker Setup

To run the application using Docker, use the following command in the root directory of the project:

```
docker-compose up --build
```

### Environment Variables

You can modify the file path for the JSON database by setting the `DATABASE_PATH` environment variable in the Docker environment.

## Usage

- Access the frontend application at `http://localhost:3000`.
- Use the provided API endpoints to manage TODO items.

## Testing

The frontend includes unit tests using Vitest. To run the tests, navigate to the `frontend` directory and execute:

```
npm run test
```

## License

This project is licensed under the MIT License.