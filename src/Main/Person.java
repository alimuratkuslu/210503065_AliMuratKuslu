package Main;

public class Person {

	private String name;
	private String vorname;
	private String telefonNummer;
	private String ausweisNummer;
	private String email;

	public Person(String name, String vorname, String telefonNummer, String ausweisNummer, String email) {
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

	public String getTelefonNummer() {
		return telefonNummer;
	}

	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public String getAusweisNummer() {
		return ausweisNummer;
	}

	public void setAusweisNummer(String ausweisNummer) {
		this.ausweisNummer = ausweisNummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static boolean isIdValid(String s) {
		if (s.length() == 7) {
			return true;
		}
		return false;
	}

	public static boolean isIdDigit(String s) {
		if (s.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

}
