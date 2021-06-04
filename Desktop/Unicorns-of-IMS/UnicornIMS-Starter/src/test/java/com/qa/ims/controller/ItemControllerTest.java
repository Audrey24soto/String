package com.qa.ims.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemDAO itemDAO;
	private Utils utils;

	

	@Test
	public testItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	private String Name;

	@Test
	public List<Item> testviewAll() {
		List<Item> items = itemDAO.viewAll();
		for (int i = 0; i < items.size(); i ++) {
			LOGGER.info(items.get(i));
	}	
		return items;
	}

	@Test
	public Item testcreate() {
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

	@Test
	public Item testupdate() {
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

	@Test
	public int testdelete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int id = utils.getInt();
		return itemDAO.delete(id);
	}

	@Test
	public Item testgetcustomer_Id() {
		// TODO Auto-generated method stub
		return null;
	}

}