package rule;

import java.util.List;

import rule.filter.CriteriaFilter;

public class Rule {

	private List<CriteriaFilter> criteriaFilters;
	private String ruleId;

	public Rule(List<CriteriaFilter> criteriaFilters) {
		this.criteriaFilters = criteriaFilters;
	}

	public void filter(List<Item> excludedItems, List<Item> includedItems) {
		for (CriteriaFilter criteriaFilter : criteriaFilters) {
			criteriaFilter.filter(excludedItems, includedItems);
		}
	}

	public void updateRuleMatches(List<Item> excludedItems, List<Item> includedItems) {
		for (Item item : excludedItems) {
			item.getRuleIds().add(ruleId);
		}
		//remove old rule matches
		for (Item item : includedItems) {
			item.getRuleIds().remove(ruleId);
		}
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

}
