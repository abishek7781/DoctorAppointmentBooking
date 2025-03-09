package com.doctorappointment.patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
	private Connection con;
	Scanner sc=new Scanner(System.in);
	
	public Patient(Connection con) {
		this.con=con;
		
		
	}
    public void addPatient() throws SQLException {
    	System.out.println("Enter Patient Name: ");
    	String name=sc.next();
    	System.out.println("Enter Patient age: ");
    	int age=sc.nextInt();
    	System.out.println("Enter Patient gender: ");
    	String gender=sc.next();
    	System.out.println("Enter Patient phone: ");
    	String phone=sc.next();
    	System.out.println("Enter Patient Email: ");
    	String Email=sc.next();
    	System.out.println("Enter Patient address: ");
    	String address=sc.next();
    	String query ="insert into patients (name,age,gender,phone,email,address) values(?,?,?,?,?,?) ";
    	try(PreparedStatement ps=con.prepareStatement(query)) {
    		ps.setString(1,name);
    		ps.setInt(2, age);
    		ps.setString(3, gender);
    		ps.setString(4, phone);
    		ps.setString(5, Email);
    		ps.setString(6, address);
    		 if (ps.executeUpdate()>0) {
    			 System.out.println("--------------------------------------");
    			 System.out.println("| patient details added successfully |");
    			 System.out.println("--------------------------------------");
    		 }
    		 else{
    			 System.out.println("failed to add patient details");
    		 }
    	}
    	
    }
    public void viewPatient() throws SQLException {
    	String query="Select * from patients";
    	try(PreparedStatement ps=con.prepareStatement(query)) {
    		try(ResultSet rs=ps.executeQuery()){
    			System.out.println("patient details :");
    			
    			while(rs.next()) {
    				int id=rs.getInt("patient_id");
    				String name=rs.getString("name");
    				int age=rs.getInt("age");
    				String gender=rs.getString("gender");
    				String phone=rs.getString("phone");
    				String email=rs.getString("email");
    				String address=rs.getString("address");
    			System.out.println("-----------------------");
       			 System.out.println(" patient id :" + id);
    			 System.out.println(" patient name :" + name);
    			 System.out.println(" patient age :" + age);
    			 System.out.println(" patient gender :" + gender);
    			 System.out.println(" patient phone :" + phone);
    			 System.out.println(" patient  email :" + email);
    			 System.out.println(" patient address :"+ address);
    			 System.out.println("-----------------------");
    				
    			}
    			
    		}
    	}
    	
    }
    public boolean getPatientById(int id) throws SQLException {
    	String query="Select count(1) from patients where patient_id =?";
    	try(PreparedStatement ps=con.prepareStatement(query)) {
    		ps.setInt(1, id);
    		try(ResultSet rs=ps.executeQuery()){
    			return rs.next();
    		}
    		}
    		
    	}
    	
    }

