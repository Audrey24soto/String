package com.qa.ims.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	
	
	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	private String Name;

	@Test
	void testOrderController() {
		fail("Not yet implemented");
	}

	@Test
	public List<Order> testviewAll() {
		List<Order> orders = orderDAO.viewAll();
		for (int i = 0; i < orders.size(); i ++) {
			LOGGER.info(orders.get(i));
	}	
		return orders;
	
	}

	@Test
	public Order testcreate() {
		LOGGER.info("Enter the Customer ID:");
		int cust_ID = utils.getInt();
		LOGGER.info("Enter the Date the Order was placed (YYYY-MM-DD):");
		String date = utils.getString();
		Order order = orderDAO.create(new Order(0, cust_ID, date, 0, 0, 0));
		create_item();
		LOGGER.info("Order Created");
		return order;
	}

	@Test
	public int testdelete() {
		int id = delete_order();
		return orderDAO.delete(id);
	}

	@Test
	public Order testgetcustomer_Id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public Order testupdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public Order testcreate_item() {
		// TODO Auto-generated method stub
		//Ask for order_id, product_id, quantity_ordered
		LOGGER.info("Enter the Order Number");
		int order_num = utils.getInt();
		LOGGER.info("Enter the item number being ordered");
		int product_ID = utils.getInt();
		LOGGER.info("Enter how many are being ordered");
		int orderquantaty = utils.getInt();
		Order order = orderDAO.addItem(new Order(order_num, 0, null, orderquantaty, product_ID, 0));
		LOGGER.info("Item Added");
		return order;
	}

	@Test
	public int testdelete_item() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int id = utils.getInt();
		LOGGER.info("Please enter the Order ID");
		int orderID = utils.getInt();
		return orderDAO.deleteItem(id, orderID);
	}

	@Test
	public int testdelete_order() {
		LOGGER.info("Please enter the Order ID");
		int orderID = utils.getInt();
		orderDAO.deleteOrder(orderID);
		return orderID;
	}

}
