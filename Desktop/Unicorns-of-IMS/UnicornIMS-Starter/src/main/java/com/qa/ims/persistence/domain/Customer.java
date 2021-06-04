package com.qa.ims.persistence.domain;

public class Customer {

	private int customer_id;
	private String firstName;
	

	//public Customer(String firstName) {
		//this.setFirstName(firstName);
		
	

	public Customer(int customer_id, String firstName) {
		this.setId(customer_id);
		this.setFirstName(firstName);
		
	}

	public int getCustomer_Id() {
		return customer_id;
	}

	public void setId(int id) {
		this.customer_id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "id:" + customer_id + " first name:" + firstName ;
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == 0) ? 0 : id.hashCode());
		return result;
	}
*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (customer_id == 0) {
			if (customer_id != 0)
				return false;
		} else if (customer_id != (other.customer_id))
			return false;
		return true;
	}

}
