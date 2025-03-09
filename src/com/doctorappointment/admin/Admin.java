
package com.doctorappointment.admin;

import com.doctorappointment.appointment.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dab.appointment.DatabaseConnectivity;
import com.doctorappointment.doctor.Doctor;
import com.doctorappointment.patient.Patient;

public class Admin {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DatabaseConnectivity.getConnection()) {
            Patient patient = new Patient(con);
            Doctor doctor = new Doctor(con);
            BookAppointment appointment = new BookAppointment(con, patient, doctor);
            ViewAppointment viewAppointment = new ViewAppointment(con);

            while (true) {
                try {
                    System.out.println("=== Doctor Appointment Booking System ===");
                    System.out.println(" ");
                    System.out.println("1. Add Patient");
                    System.out.println("2. Add Doctor");
                    System.out.println("3. View Patients");
                    System.out.println("4. View Doctors");
                    System.out.println("5. Book Appointment");
                    System.out.println("6. View Appointments");
                    System.out.println("7. Exit");
                    System.out.println(" ");
                    System.out.print("Enter your choice: ");
                    
                    if (!sc.hasNextInt()) { 
                    	System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                        System.out.println("| Invalid input! Please enter a number between 1 and 7. |");
                        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");;
                        sc.next(); 
                        continue;
                    }
                    
                    int ch = sc.nextInt();

                    switch (ch) {
                        case 1:
                            patient.addPatient();
                            break;
                        case 2:
                            doctor.addDoctor();
                            break;
                        case 3:
                            patient.viewPatient();
                            break;
                        case 4:
                            doctor.viewDoctor();
                            break;
                        case 5:
                            appointment.bookAppointment();
                            break;
                        case 6:
                            viewAppointment.viewAppointments();
                            break;
                        case 7:
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            System.out.println("| Thanks for Visiting our Hospital  |");
                            System.out.println("| Project by Dhanush, Ram, Abhishek |");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                            sc.close();
                            return;
                        default:
                        	System.out.println("------------------------------------------------");
                            System.out.println("| Please enter a valid choice between 1 and 7. |");
                            System.out.println("------------------------------------------------");
                            break;
                    }                } catch (InputMismatchException e) {
                	System.out.println("--------------------------------------------");
                    System.out.println("| Invalid input! Please enter a valid number |.");
                    System.out.println("--------------------------------------------");
                    sc.next(); 
                }
            }
        }
    }
}
