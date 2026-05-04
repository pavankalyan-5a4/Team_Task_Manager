# 🚀 Team Task Manager (Full-Stack Project)

## 📌 Overview

Team Task Manager is a full-stack web application that allows users to create projects, assign tasks, and track progress with **role-based access control (ADMIN / MEMBER)**.

This project demonstrates real-world backend development using **Spring Boot, JWT Authentication, and REST APIs**, along with a simple frontend interface.

---

## ✨ Features

### 🔐 Authentication

* User Signup & Login
* Secure authentication using JWT (JSON Web Token)

### 👥 Role-Based Access

* **ADMIN**

  * Create projects
  * Assign tasks to users
  * View all tasks
* **MEMBER**

  * View assigned tasks
  * Update task status

### 📁 Project Management

* Create multiple projects
* Each project is linked to a creator (Admin)

### 📋 Task Management

* Create tasks under projects
* Assign tasks to specific users
* Track task status:

  * TODO
  * IN_PROGRESS
  * DONE

### 🌐 Frontend

* Simple UI using HTML, CSS, JavaScript
* Signup → Login → Dashboard flow

---

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Security
* JWT (Authentication)
* Hibernate / JPA

### Database

* MySQL

### Frontend

* HTML
* CSS
* JavaScript (Fetch API)

---

## 🧱 Project Structure

```
src/main/java/com/mpk
│
├── controller
├── model
├── repository
├── security
├── config
└── service
```

---

## ⚙️ How to Run Locally

### 1️⃣ Clone the Repository

```
git clone https://github.com/your-username/team-task-manager.git
cd team-task-manager
```

### 2️⃣ Configure Database

Update `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application

Run the main class:

```
TaskManganerApplication.java
```

### 4️⃣ Open in Browser

```
http://localhost:8080
```

---

## 🔗 API Endpoints

### 🔐 Auth

* `POST /auth/signup`
* `POST /auth/login`

### 📁 Project

* `POST /project` (ADMIN only)

### 📋 Task

* `POST /tasks` (ADMIN only)
* `GET /tasks` (Role-based)
* `PUT /tasks/{id}` (Update status)

---

## 🔄 Application Flow

```
Signup → Login → JWT Token → Create Project → Create Task → Track Status
```

---

## 🧪 Sample Test Flow

1. Signup as ADMIN
2. Login → get JWT token
3. Create Project
4. Create Task and assign to user
5. Login as MEMBER → view assigned tasks

---

## 🚀 Deployment

This project can be deployed using **Railway**:

1. Push code to GitHub
2. Connect repository to Railway
3. Add MySQL plugin
4. Set environment variables
5. Deploy

---

## 🎥 Demo Video

(Attach your demo video link here)

---

## 📌 Future Improvements

* Task list UI (table/dashboard)
* Update/Delete tasks UI
* Notifications
* Better UI (React)

---

## 👨‍💻 Author

**Pavan Kalyan**

* Java Full Stack Developer
* Skills: Java, Spring Boot, MySQL, JavaScript

---

## ⭐ Conclusion

This project demonstrates:

* Backend development with Spring Boot
* Secure authentication with JWT
* Role-based authorization
* Real-world project structure

---
