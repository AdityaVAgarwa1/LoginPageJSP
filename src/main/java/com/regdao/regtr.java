package com.regdao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.regdao;

@WebServlet("/regtr")
public class regtr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Connection con = register.regdao();
		 PreparedStatement st = con.prepareStatement("insert into users values(?, ?)");
		String uname=request.getParameter("unm");
		String pass=request.getParameter("ps");
		//try {
		if(uname!="" && pass!="") {
		st.setString(1,uname);
		st.setString(2,pass);
		st.executeUpdate();
		st.close();
		con.close();
		PrintWriter out = response.getWriter();
        out.println("<html><body text=\"green\"><b>Successfully Inserted</b><br> <a href=\"login.jsp\">Back to Login</a>"+ "</body></html>");	
		}
		else {
			PrintWriter out = response.getWriter();
	        out.println("<html><body text=\"red\"><b>Enter valid Username and Password</b>"+ "</body></html>");
	        response.setHeader("Refresh","3;http://localhost:8080/loginpage/adduser.jsp");
			//throw new RuntimeException();
		}
//		}catch(Exception e) {
//			e.printStackTrace();
			
//			request.setAttribute("errorMessage", "Invalid username or password"); 
//		    RequestDispatcher dispatcher = request.getRequestDispatcher("/adduser.jsp");
//		    dispatcher.forward( request, response);
		//}
		
	}catch(Exception e){
		e.printStackTrace();
		PrintWriter out = response.getWriter();
		  out.println("<html><body text=\"red\"><b>Username or Password already exists</b><br> <a href=\"adduser.jsp\">Back to Registration</a>"+ "</body></html>");
	}

	}
}