
public class Mitarbeiter extends Person{
	
	private int mitarbeiter_id;
	private int sozialVersicherungsNummer;
	private String position;
	
	public Mitarbeiter(String name, String vorname, int telefonNummer, int ausweisNummer, String email,
			int mitarbeiter_id, int sozialVersicherungsNummer, String position) {
		super(name, vorname, telefonNummer, ausweisNummer, email);
		this.mitarbeiter_id = mitarbeiter_id;
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
		this.position = position;
	}

	public int getMitarbeiter_id() {
		return mitarbeiter_id;
	}
	public void setMitarbeiter_id(int mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

	public int getSozialVersicherungsNummer() {
		return sozialVersicherungsNummer;
	}
	public void setSozialVersicherungsNummer(int sozialVersicherungsNummer) {
		this.sozialVersicherungsNummer = sozialVersicherungsNummer;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
