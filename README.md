# Digital Library - Book Management System

## 📖 Project Overview
The **Digital Library** is a web-based book management system that allows librarians to efficiently **add, update, search, and remove books while maintaining their availability status**. This system ensures smooth book management with a structured and scalable approach.

## 🚀 Technologies Used
### **Backend: Spring Boot**
- **Spring Boot**: Used for building the RESTful API.
- **Spring Data JPA**: For interacting with the MySQL database.
- **Hibernate**: ORM framework to manage database interactions.
- **MySQL**: Cloud-based relational database for storing book data.
- **JUnit & Mockito**: Used for unit and integration testing.

### **Deployment & Infrastructure**
- **FreeDB (sql.freedb.tech)**: Used as the cloud MySQL database.
- **Render**: Used for deploying the backend API.
- **Docker**: Containerized the application for easy deployment.

### **Development Best Practices Followed**
- **SOLID Principles**: Ensured modularity, maintainability, and scalability.
- **MVC Pattern**: Organized the application into Model, View, and Controller layers.
- **DRY (Don't Repeat Yourself)**: Eliminated redundant code with reusable components.

## 📂 Project Structure
```
book-management/
├── src/main/java/com/example/bookmanagement/
│   ├── controller/   # Contains REST controllers for API endpoints
│   ├── service/      # Contains business logic for the application
│   ├── repository/   # Data access layer using Spring Data JPA
│   ├── model/        # Entity classes representing database tables
│   ├── config/       # Configuration files
│   ├── exception/    # Custom exception handling
│   ├── test/         # Unit and integration tests
├── src/main/resources/
│   ├── application.properties # Configuration file
├── build.gradle       # Gradle build configuration
├── Dockerfile         # Instructions for Docker containerization
├── README.md          # Project documentation
```

## 📡 API Endpoints
| HTTP Method | Endpoint                 | Description |
|------------|--------------------------|-------------|
| GET        | `/books`                 | Retrieve all books |
| GET        | `/books/{id}`            | Retrieve book by ID |
| GET        | `/books/title/{title}`   | Retrieve book by Title |
| POST       | `/books`                 | Add a new book |
| PUT        | `/books/{id}`            | Update a book |
| DELETE     | `/books/{id}`            | Delete a book |

## 🏗️ Project Implementation Details
### **1. Entity & Model Layer**
- Created a `Book` entity with attributes **id, title, author, genre, and availability status**.
- Applied **data validation constraints** to ensure book ID is unique and title/author are non-empty.

### **2. Repository Layer**
- Implemented `BookRepository` using **Spring Data JPA**, allowing seamless database operations.
- Methods include **findByTitle(), findById(), save(), deleteById()**, etc.

### **3. Service Layer**
- Created `BookService` to handle business logic.
- Methods include:
  - `addBook(Book book)`: Adds a new book to the database.
  - `getAllBooks()`: Retrieves all books.
  - `getBookById(Long id)`: Fetches a book by ID.
  - `getBookByTitle(String title)`: Fetches a book by title.
  - `updateBook(Long id, Book updatedBook)`: Updates book details.
  - `deleteBook(Long id)`: Removes a book record.

### **4. Controller Layer**
- Implemented `BookController` to expose **RESTful APIs**.
- Each API method is mapped to a service method and returns a **ResponseEntity**.

### **5. Exception Handling**
- Created `GlobalExceptionHandler` for handling common errors.
- Defined custom exceptions like `BookNotFoundException` for better error reporting.

### **6. Unit & Integration Testing**
- Used **JUnit and Mockito** to test service and repository layers.
- Created test cases for:
  - Adding a book
  - Fetching books by ID/title
  - Updating book details
  - Deleting a book
  - Handling invalid inputs

### **7. Containerization & Deployment**
- Wrote a `Dockerfile` to containerize the Spring Boot application.
- Deployed the API on **Render**, connecting it with a **FreeDB MySQL database**.

## 🎯 Functional Requirements
✅ **Add a Book**: Accepts Book ID, Title, Author, Genre, and Availability Status as input.
✅ **View All Books**: Displays all books with their details.
✅ **Search Book by ID or Title**: Allows searching for a book using its ID or title.
✅ **Update Book Details**: Modifies book details like availability status, title, or author.
✅ **Delete a Book Record**: Removes a book from the catalog.
✅ **Exit System**: Allows the system to be shut down safely.

## 🎯 Constraints & Validation
🔹 **Book ID must be unique**
🔹 **Title and Author cannot be empty**
🔹 **Availability Status should be either Available or Checked Out**

## 📌 Challenges & Improvements
- **Database Connection Issues**: Faced issues configuring FreeDB due to MySQL version conflicts. Solved by updating the **MySQL driver and Hibernate dialect**.
- **Handling Edge Cases**: Added proper exception handling for cases where books do not exist.
- **Deployment Limitations**: Free hosting on Render has resource constraints; future improvements can include moving to a more scalable service like **AWS or Google Cloud**.

## ⚙️ How to Setup the Project
1. **Clone the Repository**
   ```sh
   git clone https://github.com/mirzaysbaig/Digital_Library.git
   cd book-management
   ```
2. **Configure Database**
   - Update `src/main/resources/application.properties` with database credentials.
3. **Build the Project**
   ```sh
   ./gradlew build
   ```
4. **Run the Application**
   ```sh
   java -jar build/libs/book-management.jar
   ```
5. **Access API**
   - Open `http://localhost:8080/books` in your browser or use Postman.

## 🚀 Conclusion
The **Digital Library - Book Management System** is a **robust, scalable, and well-structured** project that efficiently manages books using **Spring Boot, MySQL, Docker, and Render**. It follows best coding practices, including **OOP principles, SOLID principles, MVC pattern, and proper exception handling**. The system ensures efficient book catalog management while maintaining a clean, modular, and testable codebase. 🚀

