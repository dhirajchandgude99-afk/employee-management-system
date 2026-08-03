# Employee Management System

## Overview

Employee Management System is a secure REST API application developed using Spring Boot.

This project allows users to:

- Register
- Login
- Perform Employee CRUD Operations
- Secure APIs using JWT Authentication
- Validate User Input
- Manage Employee Data using MySQL

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- BCrypt Password Encryption
- MySQL
- Maven
- Postman
- Git
- GitHub

---

## Features

- Employee CRUD Operations
- User Registration
- User Login
- JWT Authentication
- Password Encryption
- Validation
- Pagination
- Sorting
- JPQL Queries
- Native SQL Queries
- Exception Handling

---

## Project Architecture

Client

↓

Controller

↓

Service

↓

Repository

↓

Hibernate

↓

MySQL Database

---

## Authentication Flow

User Login

↓

AuthenticationManager

↓

DaoAuthenticationProvider

↓

CustomUserDetailsService

↓

Database

↓

JWT Token Generated

↓

Protected APIs

---

## API Endpoints

### Authentication APIs

POST /auth/register

POST /auth/login

---

### Employee APIs

GET /employees

GET /employees/{id}

POST /employees

PUT /employees/{id}

DELETE /employees/{id}

---

## Security

- Spring Security
- JWT Authentication
- BCrypt Password Encryption
- Protected REST APIs

---

## Database

Database Name

employee_db

---

## Author

Dhiraj Chandgude

Java Full Stack Developer