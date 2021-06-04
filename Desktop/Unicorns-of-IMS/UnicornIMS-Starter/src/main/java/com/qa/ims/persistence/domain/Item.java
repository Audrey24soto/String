package com.qa.ims.persistence.domain;

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
	
	public void setPrice(Float price2) {
		this.Price = price2;
	}
	public void setDesc(String product_desc2) {
		this.Product_desc = product_desc2;
	}
	public void setName(String product_Name2) {
		this.Product_Name = product_Name2;
	}
	public void setQuantity(int product_quantity2) {
		this.Product_quantity = product_quantity2;
	}
	public float getPrice() {
		return Price;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public String getProduct_Desc() {
		return Product_desc;
	}
	public int getQuantity() {
		return Product_quantity;
	}
	public void setId(int Id) {
		this.Product_id = Id;
	}
	public int getID() {
		return Product_id;
	}
	@Override
	public String toString() {
		return "Product ID:" + Product_id + " Product Name: " + Product_Name +  " Product Description: " + Product_desc + " Product Quantity: " + Product_quantity + " Price: " + Price;
	}
	@Override
	public boolean equals(Object obj) {
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