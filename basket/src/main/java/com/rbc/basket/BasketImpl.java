package com.rbc.basket;

import java.util.HashMap;
import java.util.Map;

import com.rbc.basket.exceptions.ItemNotFoundException;

public class BasketImpl implements Basket {
	private Map<String,Integer> basket=null;
	
	private Double cost=0.0;
	
	public void addItem(String item) {
		try {
			if(Utility.itemMap.containsKey(item)) {
				if(basket == null) {
					basket=new HashMap<String,Integer>();
				}
				
				if(basket.containsKey(item)) {
					int count=0;
					count=basket.get(item);
					basket.put(item, count+1);
				}else {
					basket.put(item, 1);
				}
			}else {
				throw new ItemNotFoundException("Incorrect item type");
			}
		}catch(Exception e) {
		}
		
	}
	
	public Map<String, Integer> getAllItem() {
		Map<String, Integer> allItems = new HashMap<String, Integer>();
		if(basket!=null)
		allItems.putAll(basket);
		return allItems;
	}
	
	
	public Double calculateCost() {
		if(basket!=null) {
			for (Map.Entry<String, Integer> item : basket.entrySet()) {
				cost = cost+((item.getValue())*(Utility.itemMap.get(item.getKey())));
			}
		}
		return cost;
	}
}
