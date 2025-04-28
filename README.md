# StellarLink Service

StellarLink is a lightweight and scalable chat backend service built with Spring Boot.  
It provides real-time messaging, file sharing, authentication, and auditing capabilities.  
This project is the first version (MVP) — focused purely on building strong backend foundations.

---

## 🚀 Project Goals

- Enable user authentication with JWT-based security.
- Allow real-time chat messaging between users.
- Support file uploads (images, attachments).
- Track entity creation/update automatically with auditing.
- Design a clean, maintainable, scalable backend architecture.

---

## 🛠️ Tech Stack

| Layer | Technology                       |
|:---|:---------------------------------|
| Language | Java 17                          |
| Framework | Spring Boot 3.x                  |
| Database | PostgreSQL                       |
| ORM | Hibernate / JPA                  |
| Security | Spring Security + JWT            |
| Build Tool | Gradle                           |
| Testing | JUnit 5, Mockito, Testcontainers |
| Documentation | OpenAPI 3 (Swagger)              |

---

## 🧩 Main Modules

- **Authentication**
    - User Registration & Login
    - JWT Token generation and validation
- **Messaging**
    - Sending and receiving text messages
    - (Planned) Future real-time support (e.g., WebSocket)
- **File Upload**
    - Upload files as message attachments
    - Store metadata in the database
- **Audit**
    - Track who created/updated records and when
- **Common Infrastructure**
    - Global exception handling
    - Security configuration
    - Base entities

---

## 🚦 Getting Started

### Prerequisites
- Java 17+
- Gradle 8+
- PostgreSQL 15+

### Running Locally

```bash
# Clone the repository
git clone https://github.com/khanhnd17/stellarlink-service.git
cd stellarlink-service

# Build the project
./gradlew clean build

# Run the app
./gradlew bootRun
