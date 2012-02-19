package rule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rule.filter.CountryCriteriaFilter;
import rule.filter.CriteriaFilter;
import rule.filter.OrganizationCriteriaFilter;

public class RuleTest {

	@Test
	public void testFilter() {
		List<CriteriaFilter> criteriaFilters = new ArrayList<CriteriaFilter>();
		criteriaFilters.add(new CountryCriteriaFilter());
		criteriaFilters.add(new OrganizationCriteriaFilter());
		
		Rule rule = new Rule(criteriaFilters);
		rule.setRuleId("rule 1");
		
		List<Item> excludedItems = new ArrayList<Item>();
		List<Item> includedItems = new ArrayList<Item>();
		
		excludedItems.add(new Item("USA", "rangers"));
		excludedItems.add(new Item("UK", "caps"));
		excludedItems.add(new Item("CAN", "rangers"));
		excludedItems.add(new Item("USA", "caps"));
		excludedItems.add(new Item("MEX", "rangers"));
		
		rule.filter(excludedItems, includedItems);
		rule.updateRuleMatches(excludedItems, includedItems);
		
		assertEquals(1, excludedItems.size());
		assertEquals(4, includedItems.size());
		assertTrue(excludedItems.get(0).getRuleIds().contains("rule 1"));
		assertFalse(includedItems.get(0).getRuleIds().contains("rule 1"));
		
		
	}

}
