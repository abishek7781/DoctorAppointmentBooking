package com.doctorappointment.appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.doctorappointment.doctor.Doctor;
import com.doctorappointment.patient.Patient;

public class BookAppointment {
	private Connection connection;
	private Patient patient;
	private Doctor doctor;
	Scanner scanner= new Scanner(System.in) ;
	public BookAppointment(Connection connection,Patient patient,Doctor doctor) {
		this.connection=connection;
		this.patient=patient;
		this.doctor=doctor;
		
	}
	public void bookAppointment() throws SQLException {
		System.out.print("Enter Patient id :");
		int PatientId =scanner.nextInt();
		System.out.print("Enter Doctor id: ");
		int DoctorId =scanner.nextInt();
		System.out.print("Enter Appointment date: yyyy-mm-dd: ");
		String appointmentDate=scanner.next();
		
		if(!patient.getPatientById(PatientId)) {
			System.out.println("please enter valid patient id ");
			return;
		}
		if(!doctor.getDoctorById(DoctorId)) {
			System.out.println("please enter valid patient id ");
			return;
		}
		
		if(!checkAvailability(connection,DoctorId,appointmentDate)) {
			
			System.out.println("Doctor not Available");
			return;
		}
		String query="insert into appointments(patient_id,doctor_id,appointment_date) values (?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(query)) {
			ps.setInt(1,PatientId);
			ps.setInt(2,DoctorId);
    		ps.setString(3, appointmentDate);
    		
    		if(ps.executeUpdate()>0) {
    			System.out.println("-----------------------------------");
    			System.out.println("| Appointment booked successfully |");
    			System.out.println("-----------------------------------");
    		}else {
    			System.out.println("--------------------------");
    			System.out.println("| Appointment not booked |");
    			System.out.println("--------------------------");
    			
    		}
		}
	}
	public boolean checkAvailability(Connection connection,int doctorid ,String appointmentDate) throws SQLException {
		String query="Select count(1) from appointments where doctor_id=? and appointment_date=?";
		try(PreparedStatement ps=connection.prepareStatement(query)) {
    		ps.setInt(1,doctorid);
    		ps.setString(2, appointmentDate);
    		try(ResultSet rs=ps.executeQuery()){
    			if(rs.next()) {
    				return rs.getInt(1)==0;
    				}
    		}
		
		}
		return false;	
	}
	
 
}
