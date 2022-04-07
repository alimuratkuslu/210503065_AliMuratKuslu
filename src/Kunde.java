
public class Kunde extends Person{

	private int kunde_id;
	private String versicherungsTyp;
	private String Adresse;
	private String benutzerKonto;
	private String passwort;

	public Kunde(String name, String vorname, int telefonNummer, int ausweisNummer, String email, int kunde_id,
			String versicherungsTyp, String adresse, String benutzerKonto, String passwort) {
		super(name, vorname, telefonNummer, ausweisNummer, email);
		this.kunde_id = kunde_id;
		this.versicherungsTyp = versicherungsTyp;
		Adresse = adresse;
		this.benutzerKonto = benutzerKonto;
		this.passwort = passwort;
	}

	public int getKunde_id() {
		return kunde_id;
	}
	public void setKunde_id(int kunde_id) {
		this.kunde_id = kunde_id;
	}

	public String getVersicherungsTyp() {
		return versicherungsTyp;
	}
	public void setVersicherungsTyp(String versicherungsTyp) {
		this.versicherungsTyp = versicherungsTyp;
	}

	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
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
