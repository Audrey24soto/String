package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {
	

	public static final Logger LOGGER = LogManager.getLogger();
	private OrderDAO orderDAO;
	private Utils utils;
	/*
	public CustomerController(CustomerDAO customerDAO, Utils utils) {
		super();
		this.customerDAO = customerDAO;
		this.utils = utils;
	}
	*/
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	private String Name;
	
	@Override
	public List<Order> viewAll() {
		List<Order> orders = orderDAO.viewAll();
		for (int i = 0; i < orders.size(); i ++) {
			LOGGER.info(orders.get(i));
	}	
		return orders;
	
	}

	/**
	 * Creates a Items by taking in user input
	 */
	/*
	public Item getProduct_Id() {
		
	}
*/
	@Override
	public Order create() {
			LOGGER.info("Enter the Customer ID:");
			int cust_ID = utils.getInt();
			LOGGER.info("Enter the Date the Order was placed (YYYY-MM-DD):");
			String date = utils.getString();
			Order order = orderDAO.create(new Order(0, cust_ID, date, 0, 0, 0));
			create_item();
			LOGGER.info("Order Created");
			return order;
		
			
			
		
		//LOGGER.info("The Price entered is: " + Price + ". The Quantity entered is: " + quantity + ". The Description entered is: " + desc + ". The Name entered is: " + name + ".");
		
	}
/**
	
	
	 * Updates an existing customer by taking in user input
	 * 
	 * 
	 * 
	 */
	
	/*
	@Override
	public Order update() {
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
		Order order = orderDAO.update(new order(id, name, desc, quantity, Price));
		LOGGER.info("Product Updated"); 
		return null;
	}
	*/
	/**
	 * Deletes an existing Items by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		int id = delete_order();
		return orderDAO.delete(id);
	}

	@Override
	public Order getcustomer_Id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create_item() {
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

	@Override
	public int delete_item() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int id = utils.getInt();
		LOGGER.info("Please enter the Order ID");
		int orderID = utils.getInt();
		return orderDAO.deleteItem(id, orderID);
	}

	@Override
	public int delete_order() {
		LOGGER.info("Please enter the Order ID");
		int orderID = utils.getInt();
		orderDAO.deleteOrder(orderID);
		return orderID;
	}

}
	