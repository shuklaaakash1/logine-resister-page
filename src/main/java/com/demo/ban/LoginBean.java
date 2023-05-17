package com.demo.ban;

public class LoginBean {
String usernm,pass,role;

public LoginBean(String usernm, String pass, String role) {
	super();
	this.usernm = usernm;
	this.pass = pass;
	this.role = role;
}

public LoginBean() {
	
}

public String getUsernm() {
	return usernm;
}

public void setUsernm(String usernm) {
	this.usernm = usernm;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

@Override
public String toString() {
	return "LoginBean [usernm=" + usernm + ", pass=" + pass + ", role=" + role + "]";
}
}
