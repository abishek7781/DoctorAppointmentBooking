# DoctorAppointmentBooking

📄Project Overview:
  The Doctor Appointment Booking System is a command-line interface (CLI) application developed using Core Java and MySQL. This application allows patients to book doctor appointments, view their scheduled appointments, and doctors can manage their availability.

💻 Tech Stack:

  Programming Language: Java (Core Java)
  Database: MySQL
  Database Connector: MySQL Connector/J
  IDE Used: Eclipse

📁Project Structure:

DoctorAppointmentBooking-main/
│
├── bin/               #compiled class file
│   ├── com/
│   │   ├── dab/
│   │   │   ├── appointment/
│   │   │   │   ├── DatabaseConnectivity.class
│   │   ├── doctorappointment/
│   │       ├── admin/
│   │       │   ├── Admin.class
│   │       ├── appointment/
│   │       │   ├── BookAppointment.class
│   │       │   ├── ViewAppointment.class
│   │       ├── doctor/
│   │       │   ├── Doctor.class
│   │       ├── patient/
│           │   ├── Patient.class
│
├── src/                  # Source code files
│   ├── com/
│   │   ├── dab/
│   │   │   ├── appointment/
│   │   │   │   ├── DatabaseConnectivity.java
│   │   ├── doctorappointment/
│   │       ├── admin/
│   │       │   ├── Admin.java
│   │       ├── appointment/
│   │       │   ├── BookAppointment.java
│   │       │   ├── ViewAppointment.java
│   │       ├── doctor/
│   │       │   ├── Doctor.java

🛠 Features:

✅ Book an Appointment: Allows patients to book appointments with available doctors.
✅ View Appointments: View scheduled appointments for both patients and doctors.
✅ Manage Doctor Information: Add, update, and view doctor information.
✅ Database Connectivity: Uses MySQL database for data storage.
✅ Error Handling: Handles exceptions like InputMismatchException and SQLException.

💾 Database Configuration:

To connect the application with MySQL database:

1.Create a database named dabs in MySQL.
2.Import the SQL script provided in the /sql folder.
3.Update the DatabaseConnectivity.java file with your database credentials.

▶️ How to Run the Project:

1.Open the project in Eclipse IDE or any Java-supported IDE.
2.Ensure you have MySQL Server running.
3.Run the Admin.java file from src/com/doctorappointment/admin/ package.
4.Follow the CLI instructions to book, view, or manage appointments.

✅ Prerequisites:

* Java JDK 8 or higher installed.
* MySQL Server installed and running.
* Eclipse IDE (recommended).

📜 License:
This project is open-source and free to use under the MIT License.

💌 Author:
Abishek Sankar
GitHub: https://github.com/abishek7781
LinkedIn: https://www.linkedin.com/in/abisheksankar2116/
