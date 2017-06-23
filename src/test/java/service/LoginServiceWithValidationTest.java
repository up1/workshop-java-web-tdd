package service;

import static org.junit.Assert.*;

import org.junit.Test;

import demo.service.InputInvalidException;
import demo.service.LoginService;

public class LoginServiceWithValidationTest {
	LoginService loginService = new LoginService();
	
	@Test(expected=InputInvalidException.class)
	public void user_is_null() {
		loginService.checkUser(null, "pass");
	}
	
	@Test(expected=InputInvalidException.class)
	public void user_is_empty() {
		loginService.checkUser("   ", "pass");
	}
	
	@Test(expected=InputInvalidException.class)
	public void pin_is_null() {
		loginService.checkUser("demo", null);
	}
	
	@Test(expected=InputInvalidException.class)
	public void pin_is_empty() {
		loginService.checkUser("demo", "  ");
	}
	

}
