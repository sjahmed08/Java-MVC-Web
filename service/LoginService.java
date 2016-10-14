package com.tcs.ilp.infinity.service;

import com.tcs.ilp.infinity.dao.LoginDAO;
import com.tcs.ilp.infinity.model.User;

public class LoginService {
	public User validateUserLogin (String username, String password){
		LoginDAO loginDAO = new LoginDAO();
		return loginDAO.validateUserLogin(username, password);
	}
}
