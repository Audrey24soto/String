package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CrudController;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = LogManager.getLogger();
	
	@Mock
	private Utils utils;

	@Mock
	private CustomerDAO dao;

	@InjectMocks
	private CustomerController controller;

	@Test
	public Customer testcreate() {
		LOGGER.info("Please enter a Name for the Customer");
		String firstName = utils.getString();
		Customer customer = customerDAO.create(new Customer(0, firstName));
		LOGGER.info("Customer created");
		return customer;
	}

	@Test
	public List<Customer> testviewAll() {
		List<Customer> customers = customerDAO.viewAll();
		for (int i = 0; i < customers.size(); i ++) {
			LOGGER.info(customers.get(i));
		}	
		return customers;
	}
	

	@Test
	public Customer testupdate() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		int id = utils.getInt();
		LOGGER.info("Please enter the updated Name for the customer");
		String Name = utils.getString();
		String newFirstname = customerDAO.update(Name, id);
		LOGGER.info("Customer Updated"); 
		return null;
	}

	@Test
	public int testdelete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		int id = utils.getInt();
		return customerDAO.delete(id);
	}

}
