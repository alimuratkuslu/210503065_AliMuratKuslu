package Main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());

	public boolean userExists(String name) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Person> person = new ArrayList<>();

		try {
			connection = Database.getDBConnection();
			connection.setAutoCommit(false);
			String query = "SELECT name, vorname, telefonnummer, ausweisnummer, email FROM user WHERE name = ?";
			statement = connection.prepareStatement(query);
			int counter = 1;
			statement.setString(counter++, name);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Person p = new Person(query, query, query, query, query);
				p.setName(resultSet.getString(1));
				p.setVorname(resultSet.getString(2));
				p.setTelefonNummer(resultSet.getString(3));
				p.setAusweisNummer(resultSet.getString(4));
				p.setEmail(resultSet.getString(5));
				person.add(p);
			}

			return person.isEmpty() ? false : true;
		} catch (SQLException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		} finally {
			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return person.isEmpty() ? false : true;
	}

	public int saveUser(Person person) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getDBConnection();
			connection.setAutoCommit(false);
			String query = "INSERT INTO user(name, vorname, telefonnummer, ausweisnummer, email) VALUES(?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			int counter = 1;
			statement.setString(counter++, person.getName());
			statement.setString(counter++, person.getVorname());
			statement.setString(counter++, person.getTelefonNummer());
			statement.setString(counter++, person.getAusweisNummer());
			statement.setString(counter++, person.getEmail());
			statement.executeUpdate();
			connection.commit();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
			if (null != connection) {
				connection.rollback();
			}
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}

			if (null != statement) {
				statement.close();
			}

			if (null != connection) {
				connection.close();
			}
		}

		return 0;
	}

}
