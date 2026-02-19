# 📚 Personal Library - A Simple CRUD App

## Overview
A portfolio CRUD application that manages Book entities and supports create, read, update, and delete operations through both a web interface and a REST API.
The application includes:
- Server-side rendering with Spring MVC and Thymeleaf
- RESTful API endpoints returning JSON

## Features

### Web Interface
- List all books
- Create a new book entry
- Update a book entry
- Delete a book entry

### REST API
- List all books
- Get a book by ID
- Create a book entry
- Update a book entry
- Delete a book entry
- Update specific fields of a book entry (PATCH method)

## Tech Stack
- Java 17
- Maven
- Spring/Spring Boot
- Spring Data JPA
- MySQL
- Spring MVC
- Thymeleaf

## Architecture
This application uses a layered architecture as follows:

```
controller/
  BookMVCController.java
  BookRestController.java
dao/
  BookRepository.java
entity/
  Book.java
service/
  BookService.java
  BookServiceImpl.java
```

`BookMVCController.java` handles browser requests and returns Thymeleaf templates and `BookRestController.java`  provides `/api` endpoints. The DAO layer uses Spring Data JPA to handle reading and writing from the database, and the service layer handles the underlying business logic.

## Web Routes

Base Path: `/personalLibrary`

| Method | Endpoint           | Description                   |
|--------|--------------------|-------------------------------|
|  GET   | /books             | Get a list of all book entries|
|  POST  | /save              | Create or update a book entry |
|  GET   | /showFormForAdd    | Show form to add new entry    |
|  GET   | /showFormForUpdate | Show form to update entry     |
| DELETE | /delete            | Delete book entry             |

## REST API Endpoints

Base Path: `/api/personalLibrary`

| Method | Endpoint           | Description                             |
|--------|--------------------|-----------------------------------------|
|  GET   | /books             | Get a list of all book entries          |
|  GET   | /books/{bookId}    | Retrieve a book by id                   |
|  POST  | /books             | Create a book entry                     |
|  PUT   | /books             | Update a book entry                     |
| PATCH  | /books/{bookId}    | Update a specific field of a book entry |
| DELETE | /books/{bookId}    | Delete book entry                       |

## Database
This application uses MySQL as the relational database to store book entries. 

### Requirements:
1. MySQL Version 8+
2. A running instance of MySQL

### Create Database

Use the following script to create a database and table:
   ```sql
   CREATE DATABASE IF NOT EXISTS `personal_library`;
   USE `personal_library`;

   DROP TABLE IF EXISTS `book`;

   CREATE TABLE `book` (
      `id` int NOT NULL AUTO_INCREMENT,
      `title` varchar(45) DEFAULT NULL,
      `author` varchar(45) DEFAULT NULL,
      PRIMARY KEY (`id`)
   ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
   ```
### Add Application Properies

Update `application.properties' file to include:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/personal_library
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

## How to Run

### Steps
1. Clone repository
   ` git clone https://github.com/EPisharody/PersonalLibrary.git `
2. Navigate to project root directory
3. Run the project using the command `./mvnw spring-boot:run`
4. Open in browser at `http://localhost:8080`

Note: ensure that database is created (see above "Database" section) before running the application.

## Screenshots

View List of Book Entries:

<img width="848" height="415" alt="personalLibraryLandingPage" src="https://github.com/user-attachments/assets/27202714-3ac2-41fc-96f4-9f6638b523c6" />



Add New Book Entry:


<img width="226" height="264" alt="personalLibraryAddBook" src="https://github.com/user-attachments/assets/4e4738de-2cde-4939-a400-71450cf1b9ba" />



Update Book Entry:


<img width="215" height="257" alt="personalLibraryUpdateBook" src="https://github.com/user-attachments/assets/00bd9862-6763-411a-a3b8-c67ddf07174d" />



Deleting Book Entry:

<img width="887" height="430" alt="personalLibraryDeleteBook" src="https://github.com/user-attachments/assets/47a252b5-55b9-4153-a04c-8dbe403f7ca6" />


## Future Improvements
- Add authentication with Spring Security
- Unit tests for both controllers
- Add endpoints to sort and filter book entries
- Add additional fields for each book entry

## Skills Learned
This project was built as part of a portfolio to demonstrate understanding of:
- Spring MVC architecture
- RESTful API design
- Layered application structure
- Server-side rendering with Thymeleaf
- Database integration with MySQL


