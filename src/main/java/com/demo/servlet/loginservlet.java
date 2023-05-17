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
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usernm=request.getParameter("usernm");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher rd;
		Loginsevice ls=new Loginserviceimpl();
		LoginBean lb=ls.validateUser(usernm, pass);
		if(lb!=null) {
			if(lb.getRole().equals("user")) {
				rd=request.getRequestDispatcher("userservlet");
			}
			else {
				rd=request.getRequestDispatcher("Adminservlet");
			}
			rd.forward(request, response);
		}else {
			out.println("<h2 style='color:red' > wrong id or password</h2>");
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
				/*if(user.equals("seed")&&pass.equals("infotech")) {
					rd=request.getRequestDispatcher("userservlet");//servlet collaboration 
					rd.forward(request, response);
					
				}
				else {
					out.println("<h2 style='color:red' > wrong id or password</h2>");
					rd=request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}*/
	}

}
