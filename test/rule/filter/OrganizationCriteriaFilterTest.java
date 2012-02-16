package rule.filter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rule.Item;

public class OrganizationCriteriaFilterTest {

	@Test
	public void testFilter() {

		List<Item> excludedItems = new ArrayList<Item>();
		List<Item> includedItems = new ArrayList<Item>();
		
		excludedItems.add(new Item("USA", "rangers"));
		excludedItems.add(new Item("UK", "caps"));
		excludedItems.add(new Item("CAN", "blackhawks"));
		excludedItems.add(new Item("USA", "rangers"));
		excludedItems.add(new Item("MEX", "caps"));
		
		OrganizationCriteriaFilter filter = new OrganizationCriteriaFilter();
		filter.filter(excludedItems, includedItems);
		
		assertEquals(2, excludedItems.size());
		assertEquals(3, includedItems.size());
		
	}

}
