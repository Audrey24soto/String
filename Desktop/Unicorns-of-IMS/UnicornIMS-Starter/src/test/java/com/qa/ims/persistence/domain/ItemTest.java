package com.qa.ims.persistence.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Item {

	private int Product_id;
	private int Product_quantity;
	private String Product_Name;
	private String Product_desc;
	private Float Price;

	
	public Item(int Product_id, String Product_Name, String Product_desc, int Product_quantity, Float Price) {
		this.setId(Product_id);
		this.setQuantity(Product_quantity);
		this.setName(Product_Name);
		this.setDesc(Product_desc);
		this.setPrice(Price);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testsetPrice(Float price2) {
		this.Price = price2;
	}

	@Test
	public void testsetDesc(String product_desc2) {
		this.Product_desc = product_desc2;
	}

	@Test
	public void testsetName(String product_Name2) {
		this.Product_Name = product_Name2;
	}

	@Test
	public void testsetQuantity(int product_quantity2) {
		this.Product_quantity = product_quantity2;
	}

	@Test
	public float testgetPrice() {
		return Price;
	}

	@Test
	public String testgetProduct_Name() {
		return Product_Name;
	}

	@Test
	public String testgetProduct_Desc() {
		return Product_desc;
	}

	@Test
	public int testgetQuantity() {
		return Product_quantity;
	}

	@Test
	public int testgetID() {
		return Product_id;
	}

	@Test
	void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	public String testtoString() {
		return "Product ID:" + Product_id + " Product Name: " + Product_Name +  " Product Description: " + Product_desc + " Product Quantity: " + Product_quantity + " Price: " + Price;
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public boolean testequals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getProduct_Desc() == null) {
			if (other.getProduct_Desc() != null)
				return false;
		} else if (!getProduct_Desc().equals(other.getProduct_Desc()))
			return false;
		if (Product_id == 0) {
			if (Product_id != 0)
				return false;
		} else if (Product_id != (other.Product_id))
			return false;
		return true;

	
	}

}
