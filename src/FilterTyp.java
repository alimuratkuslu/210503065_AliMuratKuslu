import java.util.ArrayList;

public class FilterTyp {
	private String filterTyp_id;
	private String filterTyp_name;
	
	ArrayList<FilterTyp> filterTyp = new ArrayList<>();
	
	
	public FilterTyp(String filterTyp_id, String filterTyp_name) {
		super();
		this.filterTyp_id = filterTyp_id;
		this.filterTyp_name = filterTyp_name;
	}


	public String getFilterTyp_id() {
		return filterTyp_id;
	}


	public void setFilterTyp_id(String filterTyp_id) {
		this.filterTyp_id = filterTyp_id;
	}


	public String getFilterTyp_name() {
		return filterTyp_name;
	}


	public void setFilterTyp_name(String filterTyp_name) {
		this.filterTyp_name = filterTyp_name;
	}
	
	
	
	
}
