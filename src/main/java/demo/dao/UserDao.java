package demo.dao;

import java.sql.Connection;

public interface UserDao {
	boolean checkUser(String user, String pin);
	void setConnection(Connection connection);
}
