package com.rbc.basket;

import java.util.Map;

public interface Basket {
	
	public void addItem(String item);
	public Double calculateCost();
	public Map<String, Integer> getAllItem();

}
