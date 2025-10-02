# Task 7: Employee Database App (Java JDBC CRUD)

## 📌 Description
This is a Java-based **Employee Database Management System** that connects to a **MySQL/PostgreSQL database** using **JDBC**.  
The application allows performing **CRUD operations (Create, Read, Update, Delete)** on employee records through a simple **menu-driven CLI interface**.

## 🚀 Features
- ➕ Add new employee details (ID, Name, Salary)  
- 📋 View all employees stored in the database  
- ✏️ Update employee salary using Employee ID  
- ❌ Delete employee from the database  
- 💾 Demonstrates use of **JDBC, Connection, PreparedStatement, and ResultSet**

## 🛠 Tools & Technologies
- Java  
- MySQL or PostgreSQL  
- JDBC Driver (MySQL Connector J / PostgreSQL JDBC)  
- IDE: VS Code or NetBeans  

## ⚙️ How to Run
1. **Clone the repository**:  
   bash
   git clone https://github.com/your-username/EmployeeDatabaseApp.git
   cd EmployeeDatabaseApp
   
2. **Create database and table in MySQL/PostgreSQL**:
   CREATE DATABASE employee_db;
   USE employee_db;
   CREATE TABLE employees (
     id INT PRIMARY KEY,
     name VARCHAR(50),
     salary DOUBLE
   );
   
3.**Update database connection in Task7_EmployeeDatabaseApp.java**:
   static final String URL = "jdbc:mysql://localhost:3306/employee_db";
   static final String USER = "root";       // Your DB username
   static final String PASS = "your_password"; // Your DB password
   
4. **Add JDBC Driver to project**:
   MySQL → mysql-connector-j-8.0.xx.jar
   
5. **Compile and Run**:
   javac -cp ".;mysql-connector-j-8.0.xx.jar" Task7_EmployeeDatabaseApp.java
   java -cp ".;mysql-connector-j-8.0.xx.jar" Task7_EmployeeDatabaseApp
   
6.**Use the menu in terminal**:
   1 → Add Employee
   2 → View Employees
   3 → Update Employee Salary
   4 → Delete Employee
   5 → Exit
   
##💡Learning Outcomes\n
  Practiced Java Database Connectivity (JDBC)\n
  Implemented CRUD operations with SQL\n
  Learned PreparedStatement & ResultSet handling\n
  Developed a menu-driven CLI application interacting with a relational database
  
##👤 Author
Dimpal Rana
  
