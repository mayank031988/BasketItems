package com.rbc.basket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.rbc.basket.exceptions.ItemNotFoundException;

public class BasketCalculateTest {

		
		@Test
		public void testAddingItemsInBasket() {
			Basket b = new BasketImpl();
			
			b.addItem("Bananas");
			String actual = Double.toString(b.calculateCost());
			
			assertEquals("10.0", actual);
			
		}
		
		@Test
		public void testGetAllItemsFromBasket() {
			Basket b = new BasketImpl();
			
			b.addItem("Bananas");
			b.addItem("Oranges");
			b.addItem("Bananas");
			b.addItem("Apples");
			
			final Map<String, Integer> allItems = b.getAllItem();
			assertEquals(3, allItems.size());
			assertEquals(2, allItems.get("Bananas").intValue());
			
		}
		
		@Test
		public void testAddingWrongItemsInBasket() {
			Basket b = new BasketImpl();
			
			b.addItem("Watermelon");
			String actual = Double.toString(b.calculateCost());
			
			assertEquals("10.0", actual);
			
		}
		@Test
		public void testFooThrowsIndexOutOfBoundsException() throws ItemNotFoundException {
		  boolean thrown = false;
		  Basket b = new BasketImpl();

		  b.addItem("Watermelon");

		  assertTrue(thrown);
		}

}
