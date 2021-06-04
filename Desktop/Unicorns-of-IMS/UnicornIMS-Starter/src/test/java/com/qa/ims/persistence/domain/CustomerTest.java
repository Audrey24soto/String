package com.qa.ims.persistence.domain;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	
	private int customer_id;
	private String firstName;
	
	@Test
	public testCustomer(int customer_id, String firstName) {
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

	@Test
	public String testtoString() {
		return "id:" + customer_id + " first name:" + firstName ;
	}

	@Test
	public boolean testequals(Object obj) {
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

