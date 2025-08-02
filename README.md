# Happy Folder Tests

This repository contains automated tests for Happy Folder application, organized into API and UI test modules.

## Technologies

- Java
- Spring Boot
- Maven
- JUnit5
- Selenium

## Project Structure

- `api/`  
  Contains API-level tests and supporting code for testing backend services.

- `ui/`  
  Contains UI-level tests and supporting code for testing frontend via browser automation.

## Configuration

Application properties can be found in each module under  
`src/main/resources/application.properties`.

## How to Build

```bash
./mvnw clean compile
```

## How to Run Tests

To run all tests:

```bash
./mvnw test
```

To run tests for a specific module from the root directory:

```bash
cd api
../mvnw test
```
```bash
cd ui
../mvnw test
```