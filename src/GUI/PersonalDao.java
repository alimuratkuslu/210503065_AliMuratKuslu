package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import Main.Database;

public class PersonalDao {
	
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());
	Connection connection;

    PreparedStatement ps;

    ResultSet rs;

    Database db = new Database();
    
    public int savePersonal(String name, String vorname, String telefonNummer, String ausweisNummer, String email, String personal_id,
			String position, String sozialVersicherungsNummer, String benutzerKonto, String passwort) {
    	
    	try {
            Class.forName("org.postgresql.Driver");
            connection = db.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM personal WHERE personal_id=?");
            ps.setString(1, personal_id);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == "0"){
                return -1;
            } else {
                ps = connection.prepareStatement("INSERT INTO personal VALUES (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,personal_id);
                ps.setString(2,name);
                ps.setString(3,vorname);
                ps.setString(4,telefonNummer);
                ps.setString(5,ausweisNummer);
                ps.setString(6,email);
                ps.setString(7,position);
                ps.setString(8,sozialVersicherungsNummer);
                ps.setString(9,benutzerKonto);
                ps.setString(10,passwort);
                ps.executeUpdate();
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
