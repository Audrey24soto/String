package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();

	private CustomerDAO customerDAO;
	private Utils utils;

	private String Name;
	


	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	
	@Override
	public List<Customer> viewAll() {
		List<Customer> customers = customerDAO.viewAll();
		for (int i = 0; i < customers.size(); i ++) {
			LOGGER.info(customers.get(i));
		}	
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Customer create() {
		LOGGER.info("Please enter a Name for the Customer");
		String firstName = utils.getString();
		Customer customer = customerDAO.create(new Customer(0, firstName));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Customer update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		int id = utils.getInt();
		LOGGER.info("Please enter the updated Name for the customer");
		String Name = utils.getString();
		String newFirstname = customerDAO.update(Name, id);
		LOGGER.info("Customer Updated"); 
		return null;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		int id = utils.getInt();
		return customerDAO.delete(id);
	}

	@Override
	public Customer getcustomer_Id() {
		// TODO Auto-generated method stub
		return null;
	}

}
