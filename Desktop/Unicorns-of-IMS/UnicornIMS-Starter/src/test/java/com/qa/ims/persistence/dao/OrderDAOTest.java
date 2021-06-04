package com.qa.ims.persistence.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@BeforeEach
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		String order_placed = resultSet.getString("date_placed");
		int product_id = resultSet.getInt("product_ordered");
		int quantity_ordered = resultSet.getInt("quantity_ordered");
		int order_id = resultSet.getInt("Order_ID"); 
		int customer_id = resultSet.getInt("Customer_ID");
		Float price = resultSet.getFloat("Total Cost");
		return new Order(order_id, customer_id, order_placed, quantity_ordered, product_id, price);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testModelFromResultSet() {
		fail("Not yet implemented");
	}

	@Test
	public List<Order> testviewAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select orders.order_id, orders.customer_id, orders.date_placed, sub_orders.product_ordered, sub_orders.quantity_ordered, sum(sub_orders.quantity_ordered*product.Price) AS 'Total Cost' FROM orders INNER JOIN sub_orders ON(orders.order_id=sub_orders.order_id) INNER JOIN product ON(sub_orders.product_ordered=product.product_id) GROUP BY order_id");) {
			List<Order> Orders = new ArrayList<>();
			while (resultSet.next()) {
				Orders.add(modelFromResultSet(resultSet));
	}
			return Orders;		
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Test
	public Order testreadLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Test
	public Order testcreate(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(customer_id, date_placed) VALUES (?, Date?)");) {
			statement.setInt(1, order.getCustomerID());
			statement.setString(2, order.getDate());
			statement.executeUpdate();
			return null;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Test
	public Item testupdate(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE product SET Price = ?, Product_quantity = ?, Product_desc = ?, Product_Name = ? WHERE product_id = (?)");) {
			statement.setFloat(1, item.getPrice());
			statement.setInt(2, item.getQuantity());
			statement.setString(3, item.getProduct_Desc());
			statement.setString(4, item.getProduct_Name());
			statement.setInt(5, item.getID());
			statement.executeUpdate();
		}  catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Test
	public int testdelete(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}

	@Test
	public Order testaddItem(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO sub_orders(order_id, product_ordered, quantity_ordered) VALUES (?,?,?)");) {
			statement.setInt(1, order.getOrderID());
			statement.setInt(2, order.getID());
			statement.setInt(3, order.getQuantity());
			statement.executeUpdate();
			return null;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Test
	public int testdeleteItem(int id, int orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM sub_orders WHERE product_ordered = ? AND order_id = ?");) {
			statement.setLong(1, id);
			statement.setLong(2, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}

	@Test
	public int testdeleteOrder(int orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM sub_orders WHERE order_id = ?");) {
			statement.setLong(1, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}

}
