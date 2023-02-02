package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;



/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginDao dao=new LoginDao();
		
		
			try {
				if(dao.check(uname, pass)) {
					HttpSession session=request.getSession();
					session.setAttribute("username", uname);
					response.sendRedirect("welcome.jsp");
				}
				else {
					PrintWriter out = response.getWriter();
					//response.sendRedirect("login.jsp");
					out.println("<html><body text=\"red\"><b>Invalid Credentials</b>"+ "</body></html>");
					response.setHeader("Refresh", "2; URL=http://localhost:8080/loginpage/login.jsp");
					//String element=.getElementById("mylabel");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
}