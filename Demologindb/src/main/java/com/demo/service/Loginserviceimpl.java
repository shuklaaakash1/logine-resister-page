package com.demo.service;

import com.demo.ban.LoginBean;
import com.demo.dao.LoginDaoimpl;
import com.demo.dao.LogineDao;

public class Loginserviceimpl implements Loginsevice {
		LogineDao logindao=new LoginDaoimpl();
		
	@Override
	public LoginBean validateUser(String usernm, String pass) {
		
		return logindao.validateUser(usernm, pass);
		
	}

	@Override
	public LoginBean adduser(String usernm, String pass, String role) {
		return logindao.adduser(usernm, pass,role);
	}

}
