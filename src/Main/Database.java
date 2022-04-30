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

	private Database() {

	}

	public static Connection getDBConnection() throws SQLException {
		Connection connection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return connection;
		} catch (SQLException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}

		return connection;
	}

	public Person getPersonObject(String vorname, String name, String telefonNummer, String ausweisNummer,
			String email) {
		if (vorname.equals("") || name.equals("")) {
			return null;
		} else {
			try {
				Class.forName("postgresql-42.3.4.jar");
				connection = this.getDBConnection();

				ps = connection.prepareStatement("SELECT * FROM person WHERE name=? AND vorname=?");
				ps.setString(1, vorname);
				ps.setString(2, name);
				ps.setString(3, telefonNummer);
				ps.setString(4, ausweisNummer);
				ps.setString(5, email);
				rs = ps.executeQuery();
				if (rs.next()) {
					return new Person(vorname, name, telefonNummer, ausweisNummer, email);
				} else {
					return null;
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public Kunde getKundeObject(String kunde_id) {
		if (kunde_id == " ") {
			return null;
		} else {
			try {
				Class.forName("postgresql-42.3.4.jar");
				connection = this.getDBConnection();
				ps = connection.prepareStatement("SELECT * FROM kunde WHERE KundeID=?");
				ps.setString(6, kunde_id);
				rs = ps.executeQuery();
				if (rs.next()) {
					return new Kunde(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), kunde_id, rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10));
				} else {
					return null;
				}
			} catch (ClassNotFoundException | SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public ArrayList<Kunde> getKunden() {
		ArrayList<Kunde> kunden = new ArrayList<>();
		try {
			Class.forName("postgresql-42.3.4.jar");
			connection = this.getDBConnection();
			ps = connection.prepareStatement("SELECT * FROM kunde");
			rs = ps.executeQuery();
			while (rs.next()) {
				Kunde k1 = new Kunde(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10));
				kunden.add(k1);
			}
			return kunden;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int addPatient(String name, String vorname, String telefonNummer, String ausweisNummer, String email,
			String kunde_id, String vt, String adresse, String bKonto, String pass) {
		try {
			Class.forName("postgresql-42.3.4.jar");
			connection = this.getDBConnection();
			ps = connection.prepareStatement("SELECT COUNT(*) FROM kunde WHERE KundeID=?");
			ps.setString(1, kunde_id);
			rs = ps.executeQuery();
			rs.next();
			if (rs.getInt(1) != 0) {
				return -1;
			} else {
				ps = connection.prepareStatement("INSERT INTO kunde VALUES (?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, vorname);
				ps.setString(3, telefonNummer);
				ps.setString(4, ausweisNummer);
				ps.setString(5, email);
				ps.setString(6, kunde_id);
				ps.setString(7, vt);
				ps.setString(8, adresse);
				ps.setString(9, bKonto);
				ps.setString(10, pass);
				ps.executeUpdate();
				return 0;
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
