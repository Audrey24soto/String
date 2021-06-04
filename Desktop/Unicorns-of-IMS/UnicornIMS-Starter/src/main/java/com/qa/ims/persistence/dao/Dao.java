package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	List<T> viewAll();
	
	T view(int id);

	T create(T t);

	T update(T t);

	int delete(int id);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;
}