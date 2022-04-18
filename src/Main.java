import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:postgresql://localhost:5431/Autohändler";
		String username = "postgres";
		String password = "0201ALis..";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to Postgres Server");
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Error connecting to Postgres Server");
			e.printStackTrace();
		}
		
		
	}

}
