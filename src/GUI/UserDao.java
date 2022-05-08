package GUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Database;
import Main.Kunde;
import Main.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDao {

	private static final Logger logger = Logger.getLogger(UserDao.class.getName());
	Connection connection;

    PreparedStatement ps;

    ResultSet rs;

    Database db = new Database();

	public boolean userExists(String kunde_id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		List<Kunde> kunde = new ArrayList<>();

		try {
			connection = Database.getDBConnection();
			connection.setAutoCommit(false);
			String query = "SELECT name, vorname, telefonnummer, ausweisnummer, email, versicherungsTyp, adresse, kunde_id, benutzerkonto, passwort FROM kunde WHERE kunde_id = ?";
			statement = connection.prepareStatement(query);
			int counter = 1;
			statement.setString(counter++, kunde_id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Kunde k = new Kunde(query, query, query, query, query, query, query, query, query, query);
				k.setName(resultSet.getString(1));
				k.setVorname(resultSet.getString(2));
				k.setTelefonNummer(resultSet.getString(3));
				k.setAusweisNummer(resultSet.getString(4));
				k.setEmail(resultSet.getString(5));
				k.setKunde_id(resultSet.getString(6));
				k.setVersicherungsTyp(resultSet.getString(7));
				k.setAdresse(resultSet.getString(8));
				k.setBenutzerKonto(resultSet.getString(9));
				k.setPasswort(resultSet.getString(10));
				kunde.add(k);
			}

			return kunde.isEmpty() ? false : true;
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

		return kunde.isEmpty() ? false : true;
	}
	
	public Kunde getKundeObject(String uname, String pass){
        if (uname.equals("") || pass.equals("")) {
            return null;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = db.getDBConnection();
                ps = connection.prepareStatement("SELECT * FROM kunde WHERE benutzerkonto=? AND passwort=?");
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Kunde(uname, pass, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                } else {
                    return null;
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

	public int saveKunde(String name, String vorname, String telefonNummer, String ausweisNummer, String email, String kunde_id,
			String versicherungsTyp, String adresse, String benutzerKonto, String passwort) throws SQLException {
		try {
            Class.forName("org.postgresql.Driver");
            connection = db.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM kunde WHERE kunde_id=?");
            ps.setString(1, kunde_id);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == "0"){
                return -1;
            } else {
                ps = connection.prepareStatement("INSERT INTO kunde VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,kunde_id);
                ps.setString(2,name);
                ps.setString(3,vorname);
                ps.setString(4,telefonNummer);
                ps.setString(5,ausweisNummer);
                ps.setString(6,versicherungsTyp);
                ps.setString(7,adresse);
                ps.setString(8,email);
                ps.setString(9,benutzerKonto);
                ps.setString(10,passwort);
                ps.executeUpdate();
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
	}
	
	public ObservableList<Kunde> getKunden(){
        ObservableList<Kunde> kunden = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = db.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM public.kunde");
            rs = ps.executeQuery();
            while (rs.next()){
                Kunde kunde = new Kunde(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(8),rs.getString(1),rs.getString(6),rs.getString(7),rs.getString(9),rs.getString(10));
                kunden.add(kunde);
            }
            return kunden;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
