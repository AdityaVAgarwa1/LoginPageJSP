package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public boolean check(String uname, String pass) throws SQLException {
		String sql="Select * from users where username=? and pass=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya?autoReconnect=true&useSSL=false","root","mysql");
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,pass);
			ResultSet rs=st.executeQuery(); 
			if(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return false;
	}

}
