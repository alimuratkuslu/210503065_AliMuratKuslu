package Main;

import java.time.LocalDate;

public class Termin {
	
	private String termin_id;
	private String kunde_id;
	private LocalDate datum;
	private String date;
	
	public Termin(String kunde_id, LocalDate datum, String termin_id) {
		super();
		this.termin_id = termin_id;
		this.kunde_id = kunde_id;
		this.datum = datum;
	}
	
	public Termin(String kunde_id, String datum, String termin_id) {
		super();
		this.termin_id = termin_id;
		this.kunde_id = kunde_id;
		this.date = date;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getKunde_id() {
		return kunde_id;
	}
	public void setKunde_id(String kunde_id) {
		this.kunde_id = kunde_id;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public String getTermin_id() {
		return termin_id;
	}
	public void setTermin_id(String termin_id) {
		this.termin_id = termin_id;
	}
	
	
}
