
package com.dab.appointment;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnectivity {
	public static  Connection con;
	public static Connection createcon() throws ClassNotFoundException, SQLException {		 
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/dabs?useSSL=false&allowPublicKeyRetrieval=true";
		Connection con = DriverManager.getConnection(url, "root", "abishek21");

		return con;
		}
		public static Connection getConnection() throws ClassNotFoundException, SQLException {
			if(con==null) {
				return createcon();
		}		
return con;
	}
}

