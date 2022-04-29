import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
	
	
	private static final Logger logger = Logger.getLogger(Database.class.getName());
	
	private static final String jdbcURL = "jdbc:postgresql://localhost:5431/Autohändler";
	private static final String username = "postgres";
	private static final String password = "password";
	
	
	
	private Database() {
		
	}
	
	public static Connection getDBConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName(jdbcURL);
		}
		catch (ClassNotFoundException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}
		
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);
			return connection;
		}
		catch (SQLException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}
		
		return connection;
	}
}
