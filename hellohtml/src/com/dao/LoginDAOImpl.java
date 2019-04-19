package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b = false;
		String sql ="select id from player_login where id=? and password=?";
		try (Connection connection = OracleDbConnection.getConnection();){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				b=true;
			} else {
				throw new BusinessException("Invalid Logon Credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error" + e);
		} 
		return b;
	}
	
	public User registerUser(User user) throws BusinessException {
		String sql = "insert into player_login values(?,?)";
		try (Connection connection = OracleDbConnection.getConnection();){
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.executeQuery();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal Error" + e);
		} 
		return user;
		
	}

}
