package rule.filter;

import java.util.List;

import rule.Item;

public interface CriteriaFilter {

	public void filter(List<Item> excludedItems, List<Item> includedItems);
}
