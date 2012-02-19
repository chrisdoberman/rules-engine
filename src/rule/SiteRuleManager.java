package rule;

import java.util.List;

public class SiteRuleManager {

	private List<Rule> rules;
	private String siteName;
	
	public SiteRuleManager(String siteName, List<Rule> rules) {
		this.siteName = siteName;
		this.rules = rules;
	}
	
	public void apply(List<Item> excludedItems, List<Item> includedItems) {
		//update the items with the rules that they matched.
		//the items could match on multiple rules, so we need
		//to run each rule against all items first.
		for (Rule rule : rules) {
			rule.filter(excludedItems, includedItems);
			rule.updateRuleMatches(excludedItems, includedItems);
			//empty the includedItems list back to excludedItems
			excludedItems.addAll(includedItems);
			includedItems.clear();
		}
		// now that we've updated all possible rule matches, filter against all rules
		for (Rule rule : rules) {
			rule.filter(excludedItems, includedItems);
		}
	}
}
