package Main;

public class Mitarbeiter extends Person {

	private String mitarbeiter_id;
	private String sozialVersicherungsNummer;
	private String position;

	public Mitarbeiter(String name, String vorname, String telefonNummer, String ausweisNummer, String email,
			String mitarbeiter_id, String sozialVersicherungsNummer, String position) {
		super(name, vorname, telefonNummer, ausweisNummer, email);
		this.mitarbeiter_id = mitarbeiter_id;
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
		this.position = position;
	}

	public String getMitarbeiter_id() {
		return mitarbeiter_id;
	}

	public void setMitarbeiter_id(String mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

	public String getSozialVersicherungsNummer() {
		return sozialVersicherungsNummer;
	}

	public void setSozialVersicherungsNummer(String sozialVersicherungsNummer) {
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
