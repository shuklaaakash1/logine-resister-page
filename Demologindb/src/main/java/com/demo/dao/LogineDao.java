package com.demo.dao;

import com.demo.ban.LoginBean;

public interface LogineDao {
	LoginBean validateUser(String usernm,String pass);
	LoginBean adduser(String usernm,String pass,String role);

}
