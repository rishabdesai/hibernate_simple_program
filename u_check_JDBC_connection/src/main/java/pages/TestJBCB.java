package pages;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJBCB {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/udemy_spring";
		String user = "root";
		String pass = "rootroot";
		
		
		try {
			System.out.println("connecting to database : "+jdbcUrl);
		Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);	
		System.out.println("connection successful ");		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
