# Bakery System

## Description

This project is a **Bakery System** designed to manage various bakery products such as **Breads**, their **Ingredients**, and **Bakeries** that produce them. The system tracks relationships between breads, their ingredients, and bakeries. CRUD operations are available for each entity, and the application also supports JSP views for displaying and managing the data.

## Features

- **Bread Management**: Track different types of bread and their ingredients.
- **Ingredient Management**: Store details of ingredients used in bread recipes.
- **Bakery Management**: Record information about bakeries and their products.
- **Data Relationships**: Link breads to ingredients and bakeries, ensuring that the relationships are maintained in the database.

## Technologies Used

- **Spring Boot** for the backend framework.
- **JPA/Hibernate** for database management and ORM.
- **MySQL** for the database.
- **JSP** for views.
- **Maven** for dependency management.
  
## Project Structure

- `com.bakerysystem.model` – Contains the domain classes for Bread, Ingredient, and Bakery.
- `com.bakerysystem.controller` – Includes controllers for managing the data, such as `BreadController`, `IngredientController`, and `BakeryController`.
- `com.bakerysystem.repo` – Contains JPA repositories for Bread, Ingredient, and Bakery.

