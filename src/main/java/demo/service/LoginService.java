package demo.service;

import demo.dao.UserDao;

public class LoginService { 
	
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean checkUser(String user, String pin) {
		if(user == null || "".equals(user.trim())) {
			throw new InputInvalidException("User invalid");
		}
		if(pin == null || "".equals(pin.trim())) {
			throw new InputInvalidException("Pin invalid");
		}
		
		return userDao.checkUser(user, pin);	
	}

}
