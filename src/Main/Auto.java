package Main;

public class Auto {

	private String auto_id;
	private String name;
	private String preis;
	private String model;
	private String fahrzeugTyp;
	private String jahr;
	private String treibstoffArt;
	private String getriebeTyp;
	private String motorLeistung;
	private String co2Emission;
	private String beschleunigung;
	private String systemLeistung;

	public Auto(String auto_id, String name, String preis, String model, String fahrzeugTyp, String jahr,
			String treibstoffArt, String getriebeTyp, String motorLeistung, String co2Emission, String beschleunigung,
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

	public String getAuto_id() {
		return auto_id;
	}

	public void setAuto_id(String auto_id) {
		this.auto_id = auto_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreis() {
		return preis;
	}

	public void setPreis(String preis) {
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

	public String getJahr() {
		return jahr;
	}

	public void setJahr(String jahr) {
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

	public String getMotorLeistung() {
		return motorLeistung;
	}

	public void setMotorLeistung(String motorLeistung) {
		this.motorLeistung = motorLeistung;
	}

	public String getCo2Emission() {
		return co2Emission;
	}

	public void setCo2Emission(String co2Emission) {
		this.co2Emission = co2Emission;
	}

	public String getBeschleunigung() {
		return beschleunigung;
	}

	public void setBeschleunigung(String beschleunigung) {
		this.beschleunigung = beschleunigung;
	}

	public String getSystemLeistung() {
		return systemLeistung;
	}

	public void setSystemLeistung(String systemLeistung) {
		this.systemLeistung = systemLeistung;
	}
}
