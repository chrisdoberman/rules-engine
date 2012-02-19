package rule;

import java.util.HashSet;
import java.util.Set;

public class Item {

	private String country;
	private String organization;
	private Set<String> ruleIds = new HashSet<String>();
	

	public Item(String country, String organization) {
		this.country = country;
		this.organization = organization;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Set<String> getRuleIds() {
		return ruleIds;
	}

	public void setRuleIds(Set<String> ruleIds) {
		this.ruleIds = ruleIds;
	}


	
}
