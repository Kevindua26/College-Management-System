# 🎓 College Management System (CMS)

A full-stack web application designed to streamline college operations such as student management, faculty coordination, course enrollment, attendance tracking, and grading. This project includes two main modules: **Admin Panel** and **Faculty Panel**, offering a seamless and efficient management experience for educational institutions.

---

## 📂 Project Structure

CollegeManagementSystem/
├── .idea/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── collegemanagementsystem/
│       │               ├── AdminPortalScene.java
│       │               ├── FacultyPortalScene.java
│       │               ├── HelloApplication.java
│       │               ├── HelloController.java
│       │               └── WelcomeScene.java
│       └── resources/
│           └── com/
│               └── example/
│                   └── collegemanagementsystem/
│                       ├── hello-view.fxml
│                       └── icon/
│                           ├── SO.png
│                           ├── BVIMR.png
│                           ├── BVP.png
│                           ├── home.svg
│                           └── icon.png
├── target/
└── .gitignore


## 💡 Features

### Admin Module
- View, add, and delete students and faculty
- Assign subjects and schedule
- Monitor attendance and grades

### Faculty Module
- View assigned subjects and student lists
- Mark student attendance
- Assign and record grades

---

## 🛠 Tech Stack

- **Java 17** (Eclipse Adoptium)
- **JavaFX**
- **FXML** for UI layout
- **Scene Builder** (optional)
- **Maven** for project management
- **MySQL** (optional, for DB integration)

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 17+
- IntelliJ IDEA / Eclipse
- JavaFX SDK
- MySQL (if you plan to add database support)

### Run Locally

1. Clone the repo:

```bash
git clone https://github.com/your-username/CollegeManagementSystem.git
cd CollegeManagementSystem
```

```sql
CREATE DATABASE cms;

USE cms;

CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE faculty (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    subject VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    roll_no VARCHAR(20) UNIQUE,
    department VARCHAR(100),
    year INT
);

CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    date DATE,
    status VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES student(id)
);
```


Let me know if you’d like me to include GitHub badges, logo headers, or dark-mode styling using HTML in the README!
