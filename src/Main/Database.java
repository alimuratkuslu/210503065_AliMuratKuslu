package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	private static final Logger logger = Logger.getLogger(Database.class.getName());

	private static final String DB_DRIVER = "postgresql-42.3.4.jar";
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5431/Autohändler";
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "password";

	Connection connection;
	ResultSet rs;
	PreparedStatement ps;

	public Database() {

	}

	public static Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	}
	
	public void ShowError(SQLException exception) {
        System.out.printf("Error: " + exception.getMessage());
        System.out.printf("Error Code: " + exception.getErrorCode());
    }

	

	
}
