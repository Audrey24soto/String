package com.qa.ims.persistence.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Order {

	private int order_id;
	private int customer_id;
	private String order_placed;
	private int product_id;
	private int quantity_ordered;
	private float price;

	
	public Order(int order_id, int customer_id, String order_placed, int quantity_ordered, int product_id, float price) {
		this.setOrderId(order_id); //order and sub order
		this.setDate(order_placed); //order
		this.setCustomerID(customer_id); //order
		this.setPrice(price); //view all
		this.setQuantity(quantity_ordered); //sub order
		this.setID(product_id); //sub order
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testsetOrderId(int Id) {
		this.order_id = Id;
	}

	@Test
	public int testgetOrderID() {
		return order_id;
	}

	@Test
	public void testsetDate(String order_placed2) {
		this.order_placed = order_placed2;
	}

	@Test
	public void testsetQuantity(int product_quantity2) {
		this.quantity_ordered = product_quantity2;
	}

	@Test
	public String testgetDate() {
		return order_placed;
	}

	@Test
	public int testgetQuantity() {
		return quantity_ordered;
	}

	@Test
	public void testsetID(int Id) //product id for sub order table
	{ 
		this.product_id = Id;
	}

	@Test
	public int testgetID() //product id for sub order table
	{ 
		return product_id;
	}

	@Test
	void testGetCustomerID() {
		fail("Not yet implemented");
	}

	@Test
	public int testgetCustomerID()
	{
		return customer_id;
	}

	@Test
	void testSetPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testsetCustomerID(int customer_ID)
	{
		this.customer_id = customer_ID;
	}

	@Test
	public void testsetPrice(float price)
	{
		this.price = price;
	}

	@Test
	public float testgetPrice()
	{
		return price;
	}

	@Test
	public String testtoString() {
		return "Order ID: " + order_id + " Customer ID: " + customer_id + " Date Place: " + order_placed + " Quantity Ordered: " + quantity_ordered + " Product Ordered: " + product_id + " Price: " + price;
	}

	@Test
	public boolean testequals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getDate() == null) {
			if (other.getDate() != null)
				return false;
		} else if (!getDate().equals(other.getDate()))
			return false;
		if (product_id == 0) {
			if (product_id != 0)
				return false;
		} else if (product_id != (other.product_id))
			return false;
		return true;
	}
}
