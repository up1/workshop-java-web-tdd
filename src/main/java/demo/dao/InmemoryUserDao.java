package demo.dao;

import java.sql.Connection;

public class InmemoryUserDao implements UserDao {

	public boolean checkUser(String user, String pin) {
		if( "demo".equals(user) &&
			"pass".equals(pin)) {
			return true;
		}
		return false;
	}

	public void setConnection(Connection connection) {

	}

}
