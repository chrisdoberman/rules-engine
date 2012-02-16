package rule.filter;

import java.util.Iterator;
import java.util.List;

import rule.Item;

public class CountryCriteriaFilter implements CriteriaFilter {

	private static final String COUNTRY_CRITERIA = "USA";
	@Override
	public void filter(List<Item> excludedItems, List<Item> includedItems) {

		Iterator<Item> i = excludedItems.iterator();
		Item item = null;
		
		while (i.hasNext()) {
			item = i.next(); 
			if (!item.getCountry().contains(COUNTRY_CRITERIA)) {
				i.remove();
				includedItems.add(item);
			}
		}
	}

}
