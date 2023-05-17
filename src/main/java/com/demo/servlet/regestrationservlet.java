package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.ban.LoginBean;
import com.demo.service.Loginserviceimpl;
import com.demo.service.Loginsevice;

/**
 * Servlet implementation class regestrationservlet
 */
public class regestrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regestrationservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernm=request.getParameter("usernm");
		String pass=request.getParameter("pass");
		String role=request.getParameter("role");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd;
		Loginsevice ls=new Loginserviceimpl();
		LoginBean lb=ls.adduser(usernm, pass, role);
		if(lb!=null) {
			out.println("<h2 style='color:green' > regestration sussesfull!!!...</h2>");
			rd=request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
			
		}
		else {
			out.println("<h2 style='color:red' > regestration faild!!!...</h2>");
			rd=request.getRequestDispatcher("regestration.html");
			rd.include(request, response);
		}
		
	}

}
