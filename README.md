# DoneRight - Task Management Application

DoneRight is a simple task management application built using **Spring Boot**. It provides a RESTful API to manage tasks, including creating, reading, updating, and deleting tasks.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete tasks.
- **RESTful Endpoints**: Exposes endpoints for task management.
- **Database Integration**: Uses JPA for database interactions.

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database**

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8+
- IDE (e.g., IntelliJ IDEA)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/sourabhkourav/doneright.git

2. Navigate to the project directory:
   ```bash
   cd doneright
   
3. Build the project:
   ```bash
   mvn clean install

4. Run the application:
   ```bash
   mvn spring-boot:run


### Accessing the API
The application will run on http://localhost:8080. Use tools like Postman or curl to interact with the API.


**Example Task JSON**
```json
{
  "title": "Complete project documentation",
  "completed": false
}
```
