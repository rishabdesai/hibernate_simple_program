package mainDemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckJDBCconnection {
	
	public static void main(String[] args) {
		String jdbcUrl= "jdbc:mysql://localhost:3306/udemy_spring";
		String user= "root";
		String pass="rootroot";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successful");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
