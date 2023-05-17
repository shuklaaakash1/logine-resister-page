package com.demo.service;

import com.demo.ban.LoginBean;

public interface Loginsevice {
	LoginBean validateUser(String usernm,String pass);
	LoginBean adduser(String usernm,String pass,String role);
	
}
