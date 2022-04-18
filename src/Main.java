import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:postgresql://localhost:5431/Autohändler";
		String username = "postgres";
		String password = "password";
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgres Server");
			
			String sql = "INSERT INTO person (name, vorname, telefonnummer, ausweisnummer, email)" 
			+ "VALUES ('Kuşlu', 'Ali', 05325323232, 12345678999, 'ali@gmail.com')";
			
			Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sql);
			
			if(rows > 0) {
				System.out.println("New Person has been added");
			}
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Error connecting to Postgres Server");
			e.printStackTrace();
		}
		
		
	}

}
