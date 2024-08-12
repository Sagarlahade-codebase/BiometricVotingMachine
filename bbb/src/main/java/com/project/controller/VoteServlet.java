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
 * Servlet implementation class VoteServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hello");
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		UserInterface ui=new UserImpl();
		int check=ui.checkCandidateVote(id);
		System.out.println("check::"+check);
		if(check>0)
		{
			int update=ui.updateVote(id);
			System.out.println("update::"+update);
			if(update>0)
			{
				request.setAttribute("msg", " Vote successfull" );	
				request.getRequestDispatcher("LogoutServlet").forward(request, response);
			}else{
				
				request.setAttribute("msg", " Vote UN..Successfull" );	
				request.getRequestDispatcher("vote.jsp").forward(request, response);
			}
		}else{
			int insert=ui.insertVote(id);
			System.out.println("insert::"+insert);
			if(insert>0)
			{
				request.setAttribute("msg", " Vote successfull" );	
				request.getRequestDispatcher("LogoutServlet").forward(request, response);
			}else{
				
				request.setAttribute("msg", " Vote UN..Successfull" );	
				request.getRequestDispatcher("vote.jsp").forward(request, response);
			}
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
