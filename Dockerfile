FROM node:22.12.0 AS frontend-build
WORKDIR /app
COPY ./frontend/package*.json ./
RUN npm install
COPY ./frontend .
RUN npm run build

FROM gradle:jdk21-corretto AS backend-build
WORKDIR /app
COPY ./backend/gradlew .
COPY ./backend/gradle gradle
COPY ./backend/src src
COPY ./backend/build.gradle .
COPY ./backend/settings.gradle .
RUN ./gradlew build -x test

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=backend-build /app/build/libs/*.jar app.jar
COPY --from=frontend-build /app/dist dist

ENV SPRING_WEB_RESOURCES_STATIC-LOCATIONS=file:/app/dist/
ENTRYPOINT ["java", "-jar", "app.jar"]