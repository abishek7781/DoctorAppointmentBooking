package com.doctorappointment.doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

		
		public class Doctor {
			private Connection con;
			Scanner sc=new Scanner(System.in);
			
			public Doctor(Connection con) {
				this.con=con;
				
				
			}
		    public void addDoctor() throws SQLException {
		    	System.out.println("Enter Doctor Name: ");
		    	String name=sc.next();
		    	System.out.println("Enter  Doctor specialty: ");
		    	String specialty=sc.next();
		    	System.out.println("Enter  Doctor phone: ");
		    	String phone=sc.next();
		    	String query ="insert into  doctors(name,specialty,phone) values(?,?,?) ";
		    	try(PreparedStatement ps=con.prepareStatement(query)) {
		    		ps.setString(1,name);
		    		ps.setString(2, specialty);
		    		ps.setString(3, phone);
		    		 if (ps.executeUpdate()>0) {
		    			 System.out.println(" -------------------------------------");
		    			 System.out.println(" | Doctor details added successfully |");
		    			 System.out.println(" -------------------------------------");
		    		 }
		    		 else{
		    			 System.out.println(" ---------------------------------");
		    			 System.out.println("failed to added  Doctor details");
		    			 System.out.println(" ---------------------------------");
		    		 }
		    	}
		    	
		    }
		    public void viewDoctor() throws SQLException {
		    	String query="Select * from  doctors";
		    	try(PreparedStatement ps=con.prepareStatement(query)) {
		    		try(ResultSet rs=ps.executeQuery()){
		    			System.out.println(" Doctor details");
		    			while(rs.next()) {
		    				int id=rs.getInt("doctor_id");
		    				String name=rs.getString("name");
		    				String specialty=rs.getString("specialty");
		    				String phone=rs.getString("phone");
		    			System.out.println("----------------------");
		       			 System.out.println("  Doctor id :" + id);
		    			 System.out.println("  Doctor name :" + name);
		    			 System.out.println("  Doctor gender :" + specialty);
		    			 System.out.println("  Doctor phone :" + phone);
		    			 System.out.println("----------------------");
		    				
		    			}
		    			
		    		}
		    	}
		    	
		    }
		    public boolean getDoctorById(int id) throws SQLException {
		    	String query="Select count(1) from  doctors where doctor_id =?";
		    	try(PreparedStatement ps=con.prepareStatement(query)) {
		    		ps.setInt(1, id);
		    		try(ResultSet rs=ps.executeQuery()){
		    			return rs.next();
		    		}
		    		}
		    		
		    	}
		    	
		    }


	
		