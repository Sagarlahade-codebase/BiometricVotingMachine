package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;

/**
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String id=request.getParameter("id");
		
		UserInterface ui=new UserImpl();
		int remove=ui.removeCandidate(id);
		if(remove>0)
		{
			request.setAttribute("msg", " candidate delete successfull" );	
			request.getRequestDispatcher("candidateRemove.jsp").forward(request, response);
		}else{
			
			request.setAttribute("msg", " candidate delete UN..Successfull" );	
			request.getRequestDispatcher("candidateRemove.jsp").forward(request, response);
		}
		
		
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}	

}
