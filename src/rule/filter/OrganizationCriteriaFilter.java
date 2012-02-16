package rule.filter;

import java.util.Iterator;
import java.util.List;

import rule.Item;

public class OrganizationCriteriaFilter implements CriteriaFilter {

	private static final String ORG_CRITERIA = "caps";

	@Override
	public void filter(List<Item> excludedItems, List<Item> includedItems) {

		Iterator<Item> i = excludedItems.iterator();
		Item item = null;
		
		while (i.hasNext()) {
			item = i.next();
			if (!item.getOrganization().contains(ORG_CRITERIA)) {
				i.remove();
				includedItems.add(item);
			}
		}

	}

}
