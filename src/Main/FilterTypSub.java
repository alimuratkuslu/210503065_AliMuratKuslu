package Main;

public class FilterTypSub extends FilterTyp {

	private String filterTypSub_id;
	private String filterTypSub_name;

	public FilterTypSub(String filterTyp_id, String filterTyp_name, String filterTypSub_id, String filterTypSub_name) {
		super(filterTyp_id, filterTyp_name);
		this.filterTypSub_id = filterTypSub_id;
		this.filterTypSub_name = filterTypSub_name;
	}

	public String getFilterTypSub_id() {
		return filterTypSub_id;
	}

	public void setFilterTypSub_id(String filterTypSub_id) {
		this.filterTypSub_id = filterTypSub_id;
	}

	public String getFilterTypSub_name() {
		return filterTypSub_name;
	}

	public void setFilterTypSub_name(String filterTypSub_name) {
		this.filterTypSub_name = filterTypSub_name;
	}

}
