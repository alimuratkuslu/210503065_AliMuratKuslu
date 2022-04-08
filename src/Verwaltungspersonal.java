
public class Verwaltungspersonal extends Person{
	
	private int personal_id;
	private String position;
	private int sozialVersicherungsNummer;
	private String benutzerKonto;
	private String passwort;
	
	public Verwaltungspersonal(String name, String vorname, int telefonNummer, int ausweisNummer, String email,
			int personal_id, String position, int sozialVersicherungsNummer, String benutzerKonto, String passwort) {
		super(name, vorname, telefonNummer, ausweisNummer, email);
		this.personal_id = personal_id;
		this.position = position;
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
		this.benutzerKonto = benutzerKonto;
		this.passwort = passwort;
	}

	public int getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(int personal_id) {
		this.personal_id = personal_id;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public int getSozialVersicherungsNummer() {
		return sozialVersicherungsNummer;
	}
	public void setSozialVersicherungsNummer(int sozialVersicherungsNummer) {
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
	}

	public String getBenutzerKonto() {
		return benutzerKonto;
	}
	public void setBenutzerKonto(String benutzerKonto) {
		this.benutzerKonto = benutzerKonto;
	}

	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
