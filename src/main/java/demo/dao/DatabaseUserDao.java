package demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseUserDao implements UserDao {
	
	Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection; 
	}	

	public boolean checkUser(String user, String pin) {
		try {
			PreparedStatement preparedStatement 
			= connection.prepareStatement("select user, pin from user where user=? and pin=?");
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
