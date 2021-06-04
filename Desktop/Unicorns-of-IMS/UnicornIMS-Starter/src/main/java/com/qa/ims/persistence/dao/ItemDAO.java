package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.SQLData;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {
		
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		String Product_Name = resultSet.getString("Product_Name");
		String Product_desc = resultSet.getNString("Product_desc");
		int Product_id = resultSet.getInt("Product_id");
		int  Product_quantity = resultSet.getInt("Product_quantity");
		Float  Price = resultSet.getFloat("Price");
		return new Item(Product_id, Product_Name, Product_desc, Product_quantity, Price);
	}
	
	
	/**
	 * Reads all items from the database
	 * 
	 * @return A list of Products
	 */
	@Override
	public List<Item> viewAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM product");) {
			List<Item> Items = new ArrayList<>();
			while (resultSet.next()) {
				Items.add(modelFromResultSet(resultSet));
	}
			return Items;		
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM product ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO product(Price, Product_quantity, Product_desc, Product_Name) VALUES (?,?,?,?)");) {
			statement.setFloat(1, item.getPrice());
			statement.setInt(2, item.getQuantity());
			statement.setString(3, item.getProduct_Desc());
			statement.setString(4, item.getProduct_Name());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
/*
	public Item view(int i) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE Product_id =" + i);) {
			statement.setLong(0, i);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
*/
	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	
	
	public Item update(Item item) {
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

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	public int delete(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM product WHERE product_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 1;
	}
}