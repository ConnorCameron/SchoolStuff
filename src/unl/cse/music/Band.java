package unl.cse.music;

import java.util.ArrayList;
import java.util.List;

public class Band {

	private Integer bandId;
	private String name;
	private List<String> members = new ArrayList<String>();
	
	public Integer getBandId() {
		return bandId;
	}
	public void setBandId(Integer bandId) {
		this.bandId = bandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getMembers() {
		return members;
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
}
