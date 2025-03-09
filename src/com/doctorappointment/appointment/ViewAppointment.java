package com.doctorappointment.appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewAppointment {
    private Connection connection;
    private Scanner scanner = new Scanner(System.in);

    public ViewAppointment(Connection connection) {
        this.connection = connection;
    }

    public void viewAppointments() throws SQLException {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();

        String query = "SELECT a.appointment_id, a.appointment_date, d.name AS doctor_name, a.status " +
                       "FROM appointments a " +
                       "JOIN doctors d ON a.doctor_id = d.doctor_id " +
                       "WHERE a.patient_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, patientId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                	System.out.println("-------------------------------------------");
                    System.out.println("| No appointments found for this patient. |");
                    System.out.println("-------------------------------------------");
                    return;
                }
                System.out.println("Appointments for Patient ID " + patientId + ":");
                while (rs.next()) {
                    int appointmentId = rs.getInt("appointment_id");
                    String appointmentDate = rs.getString("appointment_date");
                    String doctorName = rs.getString("doctor_name");
                    String status = rs.getString("status");
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                    //System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("| Appointment ID: " + appointmentId + ", Date: " + appointmentDate + ", Doctor: " + doctorName + ", Status: " + status+" |");
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                }
            }
        }
    }
}