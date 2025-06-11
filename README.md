# Text Generator API

This is a Java application developed with Spring Boot that manages inspirational quotes. The API provides full CRUD functionality connected to a MySQL database.

## Description

The API stores and manages phrases, each consisting of a text and an author. It follows a three-layer MVC architectural pattern and exposes RESTful endpoints that can be consumed by any client (e.g., Postman or frontend application).

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Architecture

The project follows a three-layer MVC structure:

- **Model**: contains the `Phrase` entity, mapped to the `phrases` table.
- **Repository**: `PhraseRepository` interface extending `JpaRepository`.
- **Service**: `PhraseService` class implementing business logic.
- **Controller**: `PhraseController` class exposing the REST endpoints.

## Endpoints

- `GET /` → Welcome message.
- `GET /phrases` → Retrieve all phrases.
- `GET /phrases/{id}` → Retrieve a phrase by its ID.
- `POST /phrases` → Add a new phrase.
- `PUT /phrases/{id}` → Update an existing phrase.
- `DELETE /phrases/{id}` → Delete a phrase by its ID.

## Functional Requirements

- Each phrase must contain at least a text and an author.
