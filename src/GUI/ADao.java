package GUI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Main.Auto;
import Main.Database;
import Main.Verwaltungspersonal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ADao {
	
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());
	Connection connection;

    PreparedStatement ps;

    ResultSet rs;

    Database db = new Database();
    
    public Auto getAutoObject(String auto_id) {
        if (auto_id.equals("")) {
            return null;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = db.getDBConnection();
                ps = connection.prepareStatement("SELECT * FROM auto WHERE auto_id=?");
                ps.setString(1, auto_id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Auto(auto_id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                } else {
                    return null;
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public int saveAuto(String auto_id, String name, String preis, String model, String fahrzeugTyp, String jahr,
			String treibstoffArt, String getriebeTyp, String motorLeistung, String co2Emission, String beschleunigung, String systemLeistung) {
    	
    	try {
            Class.forName("org.postgresql.Driver");
            connection = db.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM auto WHERE auto_id=?");
            ps.setString(1, auto_id);
            rs = ps.executeQuery();
            rs.next();
            if (rs.getString(1) == "0"){
                return -1;
            } else {
                ps = connection.prepareStatement("INSERT INTO auto VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1,auto_id);
                ps.setString(2,name);
                ps.setString(3,preis);
                ps.setString(4,model);
                ps.setString(5,fahrzeugTyp);
                ps.setString(6,jahr);
                ps.setString(7,treibstoffArt);
                ps.setString(8,getriebeTyp);
                ps.setString(9,motorLeistung);
                ps.setString(10,co2Emission);
                ps.setString(11,beschleunigung);
                ps.setString(12,systemLeistung);
                ps.executeUpdate();
                return 0;
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ObservableList<Auto> getAuto(){
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = db.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM auto");
            rs = ps.executeQuery();
            while (rs.next()){
                Auto auto = new Auto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12));
                autos.add(auto);
            }
            return autos;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
