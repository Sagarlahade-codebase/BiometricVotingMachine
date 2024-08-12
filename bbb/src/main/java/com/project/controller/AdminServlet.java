package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		System.out.println(uname+"  "+pass);
		HttpSession adminSession =request.getSession();
		if(uname.equals("admin") && pass.equals("admin"))
		{
			adminSession.setAttribute("username", uname);
			request.setAttribute("msg", "Welcome "+ uname);
			request.getRequestDispatcher("adminwelcome.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "Enter correct uname and password!!! ");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		
		
	}

}
