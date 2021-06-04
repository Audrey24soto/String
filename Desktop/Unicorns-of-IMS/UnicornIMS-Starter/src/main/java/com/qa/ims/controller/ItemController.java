package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item> {

	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;
	/*
	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}
	*/
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	private String Name;
	
	@Override
	public List<Item> viewAll() {
		List<Item> items = itemDAO.viewAll();
		for (int i = 0; i < items.size(); i ++) {
			LOGGER.info(items.get(i));
	}	
		return items;
	}

	/**
	 * Creates a Items by taking in user input
	 */
	/*
	public Item getProduct_Id() {
		
	}
*/
	@Override
	public Item create() {
		LOGGER.info("Enter the price for the Product:");
		float Price = Float.parseFloat(utils.getString());
		LOGGER.info("Enter the Quantity Available for the Product:");
		int quantity = utils.getInt();
		LOGGER.info("Enter the Description for the Product:");
		String desc = utils.getString();
		LOGGER.info("Enter the Name of the Product:");
		String name = utils.getString();
		//LOGGER.info("The Price entered is: " + Price + ". The Quantity entered is: " + quantity + ". The Description entered is: " + desc + ". The Name entered is: " + name + ".");
		Item item = itemDAO.create(new Item(0, name, desc, quantity, Price));
		LOGGER.info("Product added");
		return item;	
	}
	/**
	
	
	 * Updates an existing customer by taking in user input
	 * 
	 * 
	 * 
	 */
	
	
	@Override
	public Item update() {
		LOGGER.info("Enter the new price for the Product:");
		float Price = Float.parseFloat(utils.getString());
		LOGGER.info("Enter the new Quantity Available for the Product:");
		int quantity = utils.getInt();
		LOGGER.info("Enter the new Description for the Product:");
		String desc = utils.getString();
		LOGGER.info("Enter the new Name of the Product:");
		String name = utils.getString();
		LOGGER.info("Enter the ID of the Product being updated:");
		int id = utils.getInt();
		Item item = itemDAO.update(new Item(id, name, desc, quantity, Price));
		LOGGER.info("Product Updated"); 
		return null;
	}
	/**
	 * Deletes an existing Items by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int id = utils.getInt();
		return itemDAO.delete(id);
	}

	@Override
	public Item getcustomer_Id() {
		// TODO Auto-generated method stub
		return null;
	}

}