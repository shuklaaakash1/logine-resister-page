package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.ban.LoginBean;

public class LoginDaoimpl implements LogineDao{

	@Override
	public LoginBean validateUser(String usernm, String pass) {
		LoginBean l=null;
		Connection conn=DButile.getcon();
		String query="select * from user10may where usernm=? and pass=? ";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, usernm);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				l=new LoginBean();
				l.setUsernm(rs.getString(1));
				l.setPass(rs.getString(2));
				l.setRole(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public LoginBean adduser(String usernm, String pass, String role) {
		LoginBean l=null;
		Connection conn=DButile.getcon();
		String query="insert into user10may values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, usernm);
			ps.setString(2, pass);
			ps.setString(3, role);
			int rows=ps.executeUpdate();
			if(rows>0) {
				l=new LoginBean();
				l.setUsernm(usernm);
				l.setPass(pass);
				l.setRole(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

}
