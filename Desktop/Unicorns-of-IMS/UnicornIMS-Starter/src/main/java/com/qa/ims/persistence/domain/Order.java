package com.qa.ims.persistence.domain;
import java.util.*;

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

	public void setOrderId(int Id) {
		this.order_id = Id;
	}
	public int getOrderID() {
		return order_id;
	}
	public void setDate(String order_placed2) {
		this.order_placed = order_placed2;
	}
	public void setQuantity(int product_quantity2) {
		this.quantity_ordered = product_quantity2;
	}
	public String getDate() {
		return order_placed;
	}
	public int getQuantity() {
		return quantity_ordered;
	}
	public void setID(int Id) //product id for sub order table
	{ 
		this.product_id = Id;
	}
	public int getID() //product id for sub order table
	{ 
		return product_id;
	}
	public int getCustomerID()
	{
		return customer_id;
	}
	public void setCustomerID(int customer_ID)
	{
		this.customer_id = customer_ID;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
	public float getPrice()
	{
		return price;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + order_id + " Customer ID: " + customer_id + " Date Place: " + order_placed + " Quantity Ordered: " + quantity_ordered + " Product Ordered: " + product_id + " Price: " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
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