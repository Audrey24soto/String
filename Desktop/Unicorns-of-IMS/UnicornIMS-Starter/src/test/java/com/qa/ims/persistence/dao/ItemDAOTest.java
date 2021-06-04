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
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@BeforeEach
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		String Product_Name = resultSet.getString("Product_Name");
		String Product_desc = resultSet.getNString("Product_desc");
		int Product_id = resultSet.getInt("Product_id");
		int  Product_quantity = resultSet.getInt("Product_quantity");
		Float  Price = resultSet.getFloat("Price");
		return new Item(Product_id, Product_Name, Product_desc, Product_quantity, Price);
	}
	
	
	
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testModelFromResultSet() {
		fail("Not yet implemented");
	}

	@Test
	public List<Item> testviewAll() {
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

	@Test
	public Item testreadLatest() {
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

	@Test
	public Item testcreate(Item item) {
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
