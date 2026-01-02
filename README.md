🌱 Organic Zone – Backend
Backend service for Organic Zone, an e-commerce platform that connects farmers and buyers for selling and purchasing organic products.
This backend is built using Spring Boot, MySQL, and Spring Security, and provides REST APIs for authentication, user management, and product operations.

🚀 Features
User Registration & Login (Buyer / Farmer)
Role-based access handling
Secure password hashing using BCrypt
Product management (Add, Update, View products)
Farmer-wise product ownership
Email uniqueness validation
RESTful API design
MySQL database integration

🛠️ Tech Stack
Java 21
Spring Boot
Spring Security
Spring Data JPA (Hibernate)
MySQL
Maven
Postman (API testing)

🧱 Project Structure
organiczone-backend
│
├── controller        # REST Controllers
├── model             # JPA Entities
├── repository        # JPA Repositories
├── service           # Business logic
├── config            # Security & Bean configuration
└── OrganiczoneBackendApplication.java

🔐 Authentication & Security
Passwords are securely hashed using BCrypt
Spring Security is configured using Java-based configuration
Role-based redirection handled at frontend
CORS configured for frontend integration

📦 API Endpoints (Sample)
Authentication
POST /auth/login – User login
POST /test/users – User registration
Products
POST /products – Add or update product (Farmer)
GET /products – View all products
GET /products/{id} – View product by ID

🗄️ Database
MySQL

Tables:
users
products
Email field is unique for users
Hibernate handles schema mapping

▶️ How to Run the Project
Clone the repository
git clone https://github.com/your-username/organiczone-backend.git

Open the project in IntelliJ / Eclipse
Configure MySQL database in application.properties

Run:
mvn spring-boot:run

Backend runs on:
http://localhost:8080

🧪 Testing
APIs tested using Postman
Login and registration validated
Duplicate email handling implemented
Role-based flows verified

📌 Notes
DTOs and config classes are used to separate concerns and improve maintainability
This project was built as a learning-focused full-stack backend
Focused on functionality, security, and clean structure

👩‍💻 Author
Lavanya Medipudi
B.Tech Graduate | Java Backend Developer
Passionate about building real-world applications using Java & Spring Boot
