Student Management System
A Java-based web application for managing student records. The system allows users to register students, view their details, update existing records using a student ID, delete records, and view all student information in one place.

Features
Student Registration — Add and store student details in the database.
View Student — Retrieve and view student information.
Update Student — Enter a student ID to fetch the existing details and update them.
Delete Student — Delete a student record using the student ID.
View All Students — Display all stored student records and their details.
Technologies Used
Java
Java Servlets
JDBC
MySQL
HTML
Apache NetBeans
Apache Tomcat
How It Works
The application follows a simple CRUD-based workflow:

Register Student
       ↓
View Student Details
       ↓
Enter Student ID
       ↓
Fetch Existing Data
       ↓
Update Student Details
       ↓
Delete Student Record
       ↓
View All Student Details
CRUD Operations
Operation	Function
Create	Register a new student
Read	View student details
Update	Update student information using ID
Delete	Delete a student record using ID
Project Structure
StudentManagementSystem
│
├── src
│   └── java
│       ├── RegisterServlet.java
│       ├── FetchServlet.java
│       ├── UpdateServlet.java
│       ├── DeleteServlet.java
│       └── ViewServlet.java
│
├── Web Pages
│   └── HTML/JSP files
│
└── nbproject
Database Setup
This project uses MySQL to store student information.

Install and start MySQL.
Create a database for the project.
Create the required student table and columns.
Update the database connection details in your local project configuration.
Run the project using Apache Tomcat.
Note: Database passwords and private configuration files are not included in this repository for security reasons.

How to Run
Clone this repository.
Open the project in Apache NetBeans.
Configure your local MySQL database.
Make sure Apache Tomcat is configured in NetBeans.
Start the MySQL server.
Run the project on Tomcat.
Use the web interface to manage student records.
Future Improvements
Add user authentication and authorization.
Improve the user interface with responsive design.
Add student search and filtering.
Add input validation and better error handling.
Add pagination for large numbers of student records.
## Screenshots


### Student Registration
![Student Registration](registerPage.png)

### Delete Student
![Delete Student](deletePage.png)

### Update Student
![Update Student](updatePage.png)

### All Student Details
![All Student Details](viewPage.png)
Contributors
Jhanvi
Nakul
This project was collaboratively developed as a Java web application for managing student records.