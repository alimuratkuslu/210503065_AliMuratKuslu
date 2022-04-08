
public class Auto {
	
	private int auto_id;
	private String name;
	private double preis;
	private String model;
	private String fahrzeugTyp;
	private int jahr;
	private String treibstoffArt;
	private String getriebeTyp;
	private int motorLeistung;
	private int co2Emission;
	private int beschleunigung;
	private String systemLeistung;
	
	public Auto(int auto_id, String name, double preis, String model, String fahrzeugTyp, int jahr,
			String treibstoffArt, String getriebeTyp, int motorLeistung, int co2Emission, int beschleunigung,
			String systemLeistung) {
		super();
		this.auto_id = auto_id;
		this.name = name;
		this.preis = preis;
		this.model = model;
		this.fahrzeugTyp = fahrzeugTyp;
		this.jahr = jahr;
		this.treibstoffArt = treibstoffArt;
		this.getriebeTyp = getriebeTyp;
		this.motorLeistung = motorLeistung;
		this.co2Emission = co2Emission;
		this.beschleunigung = beschleunigung;
		this.systemLeistung = systemLeistung;
	}

	public int getAuto_id() {
		return auto_id;
	}
	public void setAuto_id(int auto_id) {
		this.auto_id = auto_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getFahrzeugTyp() {
		return fahrzeugTyp;
	}
	public void setFahrzeugTyp(String fahrzeugTyp) {
		this.fahrzeugTyp = fahrzeugTyp;
	}

	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public String getTreibstoffArt() {
		return treibstoffArt;
	}
	public void setTreibstoffArt(String treibstoffArt) {
		this.treibstoffArt = treibstoffArt;
	}

	public String getGetriebeTyp() {
		return getriebeTyp;
	}
	public void setGetriebeTyp(String getriebeTyp) {
		this.getriebeTyp = getriebeTyp;
	}

	public int getMotorLeistung() {
		return motorLeistung;
	}
	public void setMotorLeistung(int motorLeistung) {
		this.motorLeistung = motorLeistung;
	}

	public int getCo2Emission() {
		return co2Emission;
	}
	public void setCo2Emission(int co2Emission) {
		this.co2Emission = co2Emission;
	}

	public int getBeschleunigung() {
		return beschleunigung;
	}
	public void setBeschleunigung(int beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public String getSystemLeistung() {
		return systemLeistung;
	}
	public void setSystemLeistung(String systemLeistung) {
		this.systemLeistung = systemLeistung;
	}
}
