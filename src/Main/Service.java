package Main;

public class Service {
	
	private String service_id;
	private String kunde_id;
	private String info;
	
	public Service(String service_id, String kunde_id, String info) {
		super();
		this.service_id = service_id;
		this.kunde_id = kunde_id;
		this.info = info;
	}

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getKunde_id() {
		return kunde_id;
	}

	public void setKunde_id(String kunde_id) {
		this.kunde_id = kunde_id;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
