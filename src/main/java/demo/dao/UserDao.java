package demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	public boolean checkUser(String user, String pin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection connection 
			= DriverManager.getConnection("jdbc:mysql://localhost/for_test?user=root&password=123456");
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
