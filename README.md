# Konnect - CRM System

## 📌 Overview
**Konnect** is a Customer Relationship Management (CRM) system built with **Spring Boot**. It helps businesses manage customer interactions, streamline sales processes, and enhance client relationships efficiently.

## 🚀 Features
- User Authentication & Authorization (JWT)
- Customer & Contact Management
- Lead Tracking & Sales Pipeline
- Task & Activity Management
- Email Notifications & Reminders
- Role-Based Access Control (RBAC)
- RESTful API with Swagger Documentation
- Database Integration with **PostgreSQL**

## 🏗️ Tech Stack
- **Backend**: Spring Boot, Spring Security, Spring Data JPA
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Tokens)
- **API Documentation**: Swagger / OpenAPI
- **Deployment**: Docker, AWS (optional)

## 🎯 Getting Started
### 1️⃣ Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- PostgreSQL
- Docker (optional)

### 2️⃣ Clone the Repository
```bash
 git clone https://github.com/yourusername/Konnect-CRM.git
 cd Konnect-CRM
```

### 3️⃣ Configure Database
Update `application.properties` or `application.yml`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/konnect_crm
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Run the Application
```bash
mvn spring-boot:run
```
The app will start on `http://localhost:8080`.

## 📡 API Documentation
After running the project, access the Swagger UI at:
```
http://localhost:8080/swagger-ui/
```

## 🛠️ Contributing
Contributions are welcome! Feel free to fork this repository and submit pull requests.

## 📜 License
This project is licensed under the MIT License.

## 📧 Contact
For queries, reach out to **Sowndhariya Saravanan** at [your email] or connect on [LinkedIn/GitHub].
