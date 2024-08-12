package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;

/**
 * Servlet implementation class CandidateServlet
 */
@WebServlet("/CandidateServlet")
@MultipartConfig(maxFileSize=1024*1024*1024*5)
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateServlet() {
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
		InputStream is=null;
		String name="";
		String fullname="";
		String party="";
		Part part=request.getPart("imgfile");
		if(part!=null);
		{
			is=part.getInputStream();
			name=getFileName(part);
					
		}
		fullname=request.getParameter("FullName");
		party=request.getParameter("party");
		
		System.out.println("fullname:  "+fullname+"  party:"+party+"  name:"+name);
		
		
		UserInterface ui=new UserImpl();
		int i=ui.checkParty(party);
		System.out.println("check party:"+i);
		if(i==0)
		{
			
			int k=ui.insertcandidate(is, fullname, party);
			System.out.println("insert candidate::"+k);
			if(k>0)
			{
				request.setAttribute("msg", " candidate upload successfull" );	
				request.getRequestDispatcher("adminwelcome.jsp").forward(request, response);
			}
			
		}else{
			
			request.setAttribute("msg", party+" candidate all ready available" );	
			request.getRequestDispatcher("adminwelcome.jsp").forward(request, response);
		
		}
		
	}
	
	private String getFileName(Part part)
	{
		String name1=part.getHeader("content-disposition");
		System.out.println(part.getHeaderNames().toString());
		System.out.println("name:"+name1);
		name1=name1.substring(name1.lastIndexOf("filename")+10, name1.length()-1);
		return name1;
	}


}
