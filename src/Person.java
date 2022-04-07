
public class Person {
	
	private String name;
	private String vorname;
	private int telefonNummer;
	private int ausweisNummer;
	private String email;
	
	public Person(String name, String vorname, int telefonNummer, int ausweisNummer, String email) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telefonNummer = telefonNummer;
		this.ausweisNummer = ausweisNummer;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public int getTelefonNummer() {
		return telefonNummer;
	}
	public void setTelefonNummer(int telefonNummer) {
		this.telefonNummer = telefonNummer;
	}
	
	public int getAusweisNummer() {
		return ausweisNummer;
	}
	public void setAusweisNummer(int ausweisNummer) {
		this.ausweisNummer = ausweisNummer;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
