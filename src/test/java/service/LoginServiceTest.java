package service;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import demo.dao.UserDao;
import demo.service.LoginService;

public class LoginServiceTest {

	@Test
	public void success4() {
		LoginService loginService = new LoginService();
		loginService.setUserDao(new UserDaoWithSuccess());
		assertTrue(loginService.checkUser("demo", "pass"));
	}

	@Test
	public void success2() {
		LoginService loginService = new LoginService();
		loginService.setUserDao(new UserDaoWithSuccess());
		assertTrue(loginService.checkUser("demo", "pass"));
	}

	@Test
	public void success3() {
		LoginService loginService = new LoginService();
		loginService.setUserDao(new UserDaoWithSuccess());
		assertTrue(loginService.checkUser("demo", "pass"));
	}

	@Test
	public void success() {
		LoginService loginService = new LoginService();
		loginService.setUserDao(new UserDaoWithSuccess());
		assertTrue(loginService.checkUser("demo", "pass"));
	}

	@Test
	public void failure() {
		LoginService loginService = new LoginService();
		loginService.setUserDao(new UserDaoWithFailure());
		assertFalse(loginService.checkUser("demo", "pass"));
	}

}

class UserDaoWithFailure implements UserDao {

	public boolean checkUser(String user, String pin) {
		return false;
	}

	public void setConnection(Connection connection) {
	}

}

class UserDaoWithSuccess implements UserDao {

	public boolean checkUser(String user, String pin) {
		return false;
	}

	public void setConnection(Connection connection) {
	}

}
