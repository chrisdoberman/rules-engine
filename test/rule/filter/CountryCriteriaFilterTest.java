package rule.filter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import rule.Item;

public class CountryCriteriaFilterTest {

	@Test
	public void testFilter() {

		List<Item> excludedItems = new ArrayList<Item>();
		List<Item> includedItems = new ArrayList<Item>();
		
		excludedItems.add(new Item("USA", "rangers"));
		excludedItems.add(new Item("UK", "rangers"));
		excludedItems.add(new Item("CAN", "rangers"));
		excludedItems.add(new Item("USA", "rangers"));
		excludedItems.add(new Item("MEX", "rangers"));
		
		CountryCriteriaFilter filter = new CountryCriteriaFilter();
		filter.filter(excludedItems, includedItems);
		
		assertEquals(2, excludedItems.size());
		assertEquals(3, includedItems.size());
		
	}

}
