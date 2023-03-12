JDBC CRUD Operations Project
This is a Java project that demonstrates the basic CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity) API. It includes the implementation of a simple command-line application that allows users to interact with a relational database using JDBC.

Getting Started
Prerequisites
To run this project, you will need the following software installed on your system:

Java JDK 8 or later
Apache Maven
An IDE (optional)
Installing
To install the project, follow these steps:

Clone the repository to your local machine using Git.
Navigate to the project directory.
Build the project using Maven by running the command mvn clean package.
Running the Application
To run the application, follow these steps:

Ensure that you have a database server installed and running.
Create a database and table using the SQL script provided in the sql directory.
Update the config.properties file with your database connection details.
Run the application using the command java -jar target/jdbc-crud-1.0-SNAPSHOT.jar.
Using the Application
The application provides a command-line interface that allows users to perform CRUD operations on the database. The available commands are:

create <name> <email> <phone>: Creates a new user with the specified name, email, and phone number.
read <id>: Retrieves the user with the specified ID.
update <id> <name> <email> <phone>: Updates the user with the specified ID with the new name, email, and phone number.
delete <id>: Deletes the user with the specified ID.
To use a command, simply enter it at the prompt and follow the instructions.

License
This project is licensed under the MIT License - see the LICENSE file for details.
