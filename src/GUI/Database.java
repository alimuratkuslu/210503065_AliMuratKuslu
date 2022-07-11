package GUI;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import Main.Auto;
import Main.Kunde;
import Main.Service;
import Main.Termin;
import Main.Verwaltungspersonal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {

	private static final Logger logger = Logger.getLogger(Database.class.getName());

	Connection connection;
	ResultSet rs;
	PreparedStatement ps;
	
	public static Connection databaseLink;

	public Database() {

	}

	public static Connection getDBConnection(){
		
		String jdbcURL = "jdbc:postgresql://localhost:5431/Autohändler";
	    String username = "postgres";
	    String password = "password";

        try {
        	Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(jdbcURL,username,password);
        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
	} 
	
	public Verwaltungspersonal validateLoginPersonal(String uname,String pass){
		
		connection = Database.getDBConnection();
		
        if (uname.equals("") || pass.equals("")) {
            return null;
        } else {
            try {
            	Class.forName("org.postgresql.Driver");
                connection = Database.getDBConnection();
                ps = connection.prepareStatement("SELECT * FROM personal WHERE benutzerkonto=? AND passwort=?");
                ps.setString(1, uname);
                ps.setString(2, pass);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Verwaltungspersonal(rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), uname, pass);
                } else {
                    return null;
                }

            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
	
	public boolean personalExists(String personal_id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
		try {
        	Class.forName("org.postgresql.Driver");
			connection.setAutoCommit(false);
            ps = connection.prepareStatement("SELECT * FROM personal WHERE personal_id=?");
            
            ps.setString(1, personal_id);
            rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean savePersonal(String name, String vorname, String telefonNummer, String ausweisNummer, String email, String personal_id,
			String position, String sozialVersicherungsNummer, String benutzerKonto, String passwort) {
    	
    	try {
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM personal WHERE personal_id=?");
            ps.setString(1, personal_id);
            rs = ps.executeQuery();
            rs.next();
            if (personalExists(personal_id)){
                return false;
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
                return true;
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
	
	public boolean löschePersonal(String id) {

		Connection connection = null;
		PreparedStatement statement = null;

        try {
        	Class.forName("org.postgresql.Driver");
        	connection = Database.getDBConnection();
			String query = "DELETE FROM personal WHERE personal_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.executeUpdate();
			return true;

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;

    }
	
	public ObservableList<Verwaltungspersonal> getPersonal(){
        ObservableList<Verwaltungspersonal> personal = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM personal");
            rs = ps.executeQuery();
            while (rs.next()){
                Verwaltungspersonal person = new Verwaltungspersonal(rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(1),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                personal.add(person);
            }
            return personal;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Kunde validateLoginKunde(String uname,String pass){
		
		connection = Database.getDBConnection();
		
        if (uname.equals("") || pass.equals("")) {
            return null;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
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
	
	public boolean saveKunde(String name, String vorname, String telefonNummer, String ausweisNummer, String email, String kunde_id,
			String versicherungsTyp, String adresse, String benutzerKonto, String passwort) throws SQLException {
		try {
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM kunde WHERE kunde_id=?");
            ps.setString(1, kunde_id);
            rs = ps.executeQuery();
            rs.next();
            if (kundeExists(kunde_id)){
                return false;
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
                return true;
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
	}
	
	public boolean kundeExists(String kunde_id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
		try {
        	Class.forName("org.postgresql.Driver");
			connection.setAutoCommit(false);
            ps = connection.prepareStatement("SELECT * FROM kunde WHERE kunde_id=?");
            
            ps.setString(1, kunde_id);
            rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public boolean löscheKunde(String id) {

		Connection connection = null;
		PreparedStatement statement = null;

        try {
        	Class.forName("org.postgresql.Driver");
        	connection = Database.getDBConnection();
			String query = "DELETE FROM kunde WHERE kunde_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.executeUpdate();
			return true;

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;

    }
	
	
	public ObservableList<Kunde> getKunden(){
        ObservableList<Kunde> kunden = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
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
	
	public ObservableList<Kunde> getKunden1(String id){
		
		ObservableList<Kunde> kunden = FXCollections.observableArrayList();
		Connection connection = null;
		PreparedStatement statement = null;
		
        try{
        	Class.forName("org.postgresql.Driver");
        	connection = Database.getDBConnection();
        	ps = connection.prepareStatement("SELECT * FROM public.kunde WHERE kunde_id=?");
        	ps.setString(1, id);
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
	
	public Auto getAutoObject(String auto_id) {
        if (auto_id.equals("")) {
            return null;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = Database.getDBConnection();
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
	
	public Auto getAutoByName(String name) {
    	if (name.equals("")) {
            return null;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                connection = Database.getDBConnection();
                ps = connection.prepareStatement("SELECT * FROM auto WHERE name=?");
                ps.setString(1, name);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Auto(rs.getString(1), name, rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
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
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM auto WHERE auto_id=?");
            ps.setString(1, auto_id);
            rs = ps.executeQuery();
            rs.next();
            if (autoExists(auto_id)){
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
	
	public boolean autoExists(String auto_id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
		try {
        	Class.forName("org.postgresql.Driver");
			connection.setAutoCommit(false);
            ps = connection.prepareStatement("SELECT * FROM auto WHERE auto_id=?");
            
            ps.setString(1, auto_id);
            rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
    public ObservableList<Auto> getAutoName(String auto_name){
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM auto WHERE name=?");
            return getAutos(auto_name, autos);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    private ObservableList<Auto> getAutos(String name, ObservableList<Auto> Autos) throws SQLException {
    	ps.setString(1,name);
        rs = ps.executeQuery();
        while (rs.next()){
            Auto auto = new Auto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12));
            Autos.add(auto);
        }
        return Autos;
    }
    
    public ObservableList<Auto> getAuto1(){
        ObservableList<Auto> autos = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
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
    
    public boolean createTermin(String termin_id, String kunde_id, LocalDate date) {
    	
    	Connection connection = null;
    	
        try {
        	Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM termin WHERE termin_id=?");
            ps.setString(1, termin_id);
            rs = ps.executeQuery();
            rs.next();
            if (terminExists(termin_id)){
                return false;
            } else {
                ps = connection.prepareStatement("INSERT INTO termin VALUES (?,?,?)");
                ps.setString(1,termin_id);
                ps.setString(2,kunde_id);
                ps.setDate(3, java.sql.Date.valueOf(date));
                ps.executeUpdate();
                return true;
            
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ObservableList<Termin> getTermin(String id){
    	
        ObservableList<Termin> termin = FXCollections.observableArrayList();
        
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM termin WHERE kunde_id=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Termin t = new Termin(rs.getString(2), rs.getDate(3).toString(), rs.getString(1));
                termin.add(t);
            }
            return termin;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ObservableList<Termin> getTermine(){
        ObservableList<Termin> termine = FXCollections.observableArrayList();
        try{
            Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT * FROM termin");
            rs = ps.executeQuery();
            while (rs.next()){
                Termin t = new Termin(rs.getString(2), rs.getDate(3).toString(), rs.getString(1));
                termine.add(t);
            }
            return termine;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

	public boolean terminExists(String termin_id) {
    	
    	Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
        try {
        	Class.forName("org.postgresql.Driver");
			connection.setAutoCommit(false);
            ps = connection.prepareStatement("SELECT * FROM termin WHERE termin_id=?");
            
            ps.setString(1, termin_id);
            rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public boolean löscheTermin(String termin_id) {
    	
    	Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
        try {
        	Class.forName("org.postgresql.Driver");
        	connection = Database.getDBConnection();
			String query = "DELETE FROM termin WHERE termin_id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, termin_id);
			statement.executeUpdate();
			return true;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean createService(String service_id, String kunde_id, String info) {
    	
    	Connection connection = null;
    	
        try {
        	Class.forName("org.postgresql.Driver");
            connection = Database.getDBConnection();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM service WHERE service_id=?");
            ps.setString(1, service_id);
            rs = ps.executeQuery();
            rs.next();
            
            if (serviceExists(service_id)){
                return false;
            } else {
                ps = connection.prepareStatement("INSERT INTO service VALUES (?,?,?)");
                ps.setString(1,service_id);
                ps.setString(2,kunde_id);
                ps.setString(3, info);
                ps.executeUpdate();
                if(!serviceExists(service_id)) {
                	return false;
                }
                return true;
            
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
    
     public boolean serviceExists(String service_id) {
    	
    	Connection connection = null;
		PreparedStatement statement = null;
		connection = Database.getDBConnection();
		
        try {
        	Class.forName("org.postgresql.Driver");
			connection.setAutoCommit(false);
            ps = connection.prepareStatement("SELECT * FROM service WHERE service_id=?");
            
            ps.setString(1, service_id);
            rs = ps.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
     
     public ObservableList<Service> getService(String id){
         ObservableList<Service> service = FXCollections.observableArrayList();
         try{
             Class.forName("org.postgresql.Driver");
             connection = Database.getDBConnection();
             ps = connection.prepareStatement("SELECT * FROM service WHERE kunde_id=?");
             ps.setString(1, id);
             rs = ps.executeQuery();
             while (rs.next()){
                 Service s = new Service(rs.getString(1),rs.getString(2), rs.getString(3));
                 service.add(s);
             }
             return service;
         } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException(e);
         }
     }
     
     public ObservableList<Service> getService1(){
         ObservableList<Service> service = FXCollections.observableArrayList();
         try{
             Class.forName("org.postgresql.Driver");
             connection = Database.getDBConnection();
             ps = connection.prepareStatement("SELECT * FROM service ");
             rs = ps.executeQuery();
             while (rs.next()){
                 Service s = new Service(rs.getString(1),rs.getString(2), rs.getString(3));
                 service.add(s);
             }
             return service;
         } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException(e);
         }
     }
     
     public boolean löscheService(String service_id) {
     	
     	Connection connection = null;
 		PreparedStatement statement = null;
 		connection = Database.getDBConnection();
 		
         try {
         	Class.forName("org.postgresql.Driver");
         	connection = Database.getDBConnection();
 			String query = "DELETE FROM service WHERE service_id = ?";
 			statement = connection.prepareStatement(query);
 			statement.setString(1, service_id);
 			statement.executeUpdate();
 			return true;
         } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException(e);
         }
     }
     
     
	
	public void ShowError(SQLException exception) {
        System.out.printf("Error: " + exception.getMessage());
        System.out.printf("Error Code: " + exception.getErrorCode());
    }
}
