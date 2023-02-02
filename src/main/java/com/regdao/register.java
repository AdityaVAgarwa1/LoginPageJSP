package com.regdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class register {
	public static Connection regdao() throws SQLException,ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya?autoReconnect=true&useSSL=false","root","mysql");
		
    return con;
}

}
