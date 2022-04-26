
public class Verwaltungspersonal extends Person{
	
	private String personal_id;
	private String position;
	private String sozialVersicherungsNummer;
	private String benutzerKonto;
	private String passwort;
	
	public Verwaltungspersonal(String name, String vorname, String telefonNummer, String ausweisNummer, String email,
			String personal_id, String position, String sozialVersicherungsNummer, String benutzerKonto, String passwort) {
		super(name, vorname, telefonNummer, ausweisNummer, email);
		this.personal_id = personal_id;
		this.position = position;
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
		this.benutzerKonto = benutzerKonto;
		this.passwort = passwort;
	}

	public String getPersonal_id() {
		return personal_id;
	}
	public void setPersonal_id(String personal_id) {
		this.personal_id = personal_id;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getSozialVersicherungsNummer() {
		return sozialVersicherungsNummer;
	}
	public void setSozialVersicherungsNummer(String sozialVersicherungsNummer) {
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
	
	public static FilterTyp addFilterTyp(String id, String name) {
		FilterTyp f = new FilterTyp(id, name);
		
		return f;
	}
}
