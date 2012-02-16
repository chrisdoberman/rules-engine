package rule;

import java.util.List;

import rule.filter.CriteriaFilter;

public class Rule {

	private List<CriteriaFilter> criteriaFilters;

	public Rule(List<CriteriaFilter> criteriaFilters) {
		this.criteriaFilters = criteriaFilters;
	}

	public void filter(List<Item> excludedItems, List<Item> includedItems) {
		for (CriteriaFilter criteriaFilter : criteriaFilters) {
			criteriaFilter.filter(excludedItems, includedItems);
		}
	}

	public List<CriteriaFilter> getCriteriaFilters() {
		return criteriaFilters;
	}

	public void setCriteriaFilters(List<CriteriaFilter> criteriaFilters) {
		this.criteriaFilters = criteriaFilters;
	}

}
