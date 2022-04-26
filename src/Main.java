import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Kunde> kunden = new ArrayList<>();
		ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();
		ArrayList<Verwaltungspersonal> verwaltpersonal = new ArrayList<>();
		ArrayList<FilterTyp> filter = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int opt = 0;
		while(opt != 100) {
			System.out.println("Welche Operation möchten Sie durchführen ?");
		    System.out.println("  1- Mitarbeiter hinzufügen");
		    System.out.println("  2- Mitarbeiter auflisten");
		    System.out.println("  3- Kunde hinzufügen");
		    System.out.println("  4- Kunde auflisten");
		    System.out.println("  5- Verwaltungspersonal hinzufügen");
		    System.out.println("  6- Verwaltungspersonal auflisten");
		    System.out.println("  7- Filtertyp hinzufügen");
		    System.out.println("  8- Filtertyp auflisten");
		    System.out.println("  100 - Programm beenden");
		    
		    opt = sc.nextInt();
		    
		    switch(opt) {
		    case 1:
		    	System.out.println("Geben sie Mitarbeiter-ID ein ");
		    	String mit_id = sc.next();
		    	
		    	if(Mitarbeiter.isIdValid(mit_id) && Mitarbeiter.isIdDigit(mit_id)) {
		    		System.out.println("Geben Sie den Namen des Mitarbeiters ein");
	        		String mit_name = sc.next();
	        	
	        		System.out.println("Geben Sie den Vornamen ein");
	        		String mit_vorname = sc.next();
	        	
	        		System.out.println("Geben Sie die Telefonnummer ein");
	        		String nummer = sc.next();
	        	
	        		System.out.println("Geben Sie die ID-Nummer ein");
	        		String awnummer = sc.next();
	        	
	        		System.out.println("Geben Sie die E-Mail-Adresse ein");
	        		String email = sc.next();
	        	
	        		System.out.println("Geben Sie die Sozialversicherungsnummer ein");
	        		String svnummer = sc.next();
	        		
	        		System.out.println("Geben Sie die Stelle ein");
	        		String stellung = sc.next();
	        	
	        		Mitarbeiter m1 = new Mitarbeiter(mit_name, mit_vorname, nummer, awnummer, email, mit_id, svnummer, stellung);
	        		mitarbeiter.add(m1);
		    	}
		    	else {
		    		System.out.println("Geben sie eine korrekte ID ein");
		    	}
		    	
		    case 2:
		    	for(int i = 0; i < mitarbeiter.size(); i++) {
		    		Mitarbeiter m = (Mitarbeiter) mitarbeiter.get(i);
		    		System.out.println(m);
		    	}
		    	
		    case 3:
		    	System.out.println("Geben Sie die Kunden-ID ein");
	        	String kun_id = sc.next();

				if(Kunde.isIdValid(kun_id) && Kunde.isIdDigit(kun_id)){
					System.out.println("Geben Sie den Namen des Mitarbeiters ein");
	        		String kun_name = sc.next();
	        	
	        		System.out.println("Geben Sie den Vornamen ein");
	        		String kun_vorname = sc.next();
	        	
	        		System.out.println("Geben Sie die Telefonnummer ein");
	        		String nummer = sc.next();
	        	
	        		System.out.println("Geben Sie die ID-Nummer ein");
	        		String awnummer = sc.next();
	        		
	        		System.out.println("Geben Sie die E-Mail-Adresse ein");
	        		String email = sc.next();
	        		
	        		System.out.println("Geben Sie die Versicherungsart ein");
	        		String versicherungsTyp = sc.next();
	        		
	        		System.out.println("Geben Sie die Adresse ein");
	        		String adresse = sc.next();
	        		
	        		System.out.println("Geben Sie den Benutzernamen ein");
	        		String bkonto = sc.next();
	        		
	        		System.out.println("Geben Sie das Passwort ein");
	        		String passwort = sc.next();

					Kunde k1 = new Kunde(kun_name, kun_vorname, nummer, awnummer,email,kun_id, versicherungsTyp, adresse, bkonto, passwort);
					kunden.add(k1);
				}
				else{
					System.out.println("Geben Sie eine korrekte ID ein");
				}
				
		    case 4:
		    	for(int i = 0; i < kunden.size(); i++) {
		    		Kunde k = (Kunde) kunden.get(i);
		    		System.out.println(k);
		    	}
		    
		    case 5:
		    	System.out.println("Geben Sie die Verwaltungsmitarbeiter-ID ein ");
		    	String verwalt_id = sc.next();
		    	
		    	if(Kunde.isIdValid(verwalt_id) && Kunde.isIdDigit(verwalt_id)){
					System.out.println("Geben Sie den Namen des Verwaltungsmitarbeiters ein");
	        		String verwalt_name = sc.next();
	        	
	        		System.out.println("Geben Sie den Vornamen ein");
	        		String verwalt_vorname = sc.next();
	        	
	        		System.out.println("Geben Sie die Telefonnummer ein");
	        		String nummer = sc.next();
	        	
	        		System.out.println("Geben Sie die ID-Nummer ein");
	        		String awnummer = sc.next();
	        		
	        		System.out.println("Geben Sie die E-Mail-Adresse ein");
	        		String email = sc.next();
	        		
	        		System.out.println("Geben Sie die Versicherungsart ein");
	        		String position = sc.next();
	        		
	        		System.out.println("Geben Sie die Adresse ein");
	        		String svnummer = sc.next();
	        		
	        		System.out.println("Geben Sie den Benutzernamen ein");
	        		String bkonto = sc.next();
	        		
	        		System.out.println("Geben Sie das Passwort ein");
	        		String passwort = sc.next();

					Verwaltungspersonal v1 = new Verwaltungspersonal(verwalt_name, verwalt_vorname, nummer, awnummer, email, verwalt_id, position, svnummer, bkonto, passwort);
					verwaltpersonal.add(v1);
				}
		    	else {
		    		System.out.println("Geben Sie eine korrekte ID ein");
		    	}
		    	
		    case 6:
		    	for(int i = 0; i < verwaltpersonal.size(); i++) {
		    		Verwaltungspersonal v = (Verwaltungspersonal) verwaltpersonal.get(i);
		    		System.out.println(v);
		    	}
		    
		    case 7:
		    	System.out.println("Geben Sie die Filtertyp-ID ein ");
		    	String filter_id = sc.next();
		    	
		    	System.out.println("Geben Sie den Namen des Filtertyps ein ");
		    	String filter_name = sc.next();
		    	
		    	FilterTyp f = Verwaltungspersonal.addFilterTyp(filter_id, filter_name);
		    	
		    	filter.add(f);
		    	
		    	
		    	
		    case 8:
		    	for(int i = 0; i < filter.size(); i++) {
		    		FilterTyp fil = (FilterTyp) filter.get(i);
		    		System.out.println(fil); 
		    	}
		    	
		    }
		    
		    	
		}
		
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
