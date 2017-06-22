package demo.service;

import demo.dao.UserDao;

public class LoginService {

	public boolean checkUser(String user, String pin) {
		if(user == null || "".equals(user.trim())) {
			throw new InputInvalidException("User invalid");
		}
		if(pin == null || "".equals(pin.trim())) {
			throw new InputInvalidException("Pin invalid");
		}
		UserDao userDao = new UserDao();
		return userDao.checkUser(user, pin);
	}

}
