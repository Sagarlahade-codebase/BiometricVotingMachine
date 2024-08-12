package com.project.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OtpServlet
 */
@WebServlet("/OtpServlet")
public class OtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtpServlet() {
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
		
		String otpfinger=request.getParameter("otpfinger");
		 HttpSession otpsession=request.getSession();
  	   String otp=(String)otpsession.getAttribute("otp");
  	   long time=(Long)otpsession.getAttribute("time");
  	   long curr=System.currentTimeMillis();
  	   long diff=curr-time;
  	 
  	  
  	  if(diff<300000)
  	  {
  		  if(otpfinger.equals(otp))
  		  {
  			  System.out.println("Match OTP");
  			  request.setAttribute("msg", "OTP Match Successfully");
  			  request.getRequestDispatcher("vote.jsp").forward(request, response);
  		  }else{
  			 request.setAttribute("msg", "please enter correct OTP");
 			  request.getRequestDispatcher("matchOtp.jsp").forward(request, response);
  		  }
  	  }else{
  		  request.setAttribute("msg", "OTP Session time out");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
  	  }
  	  
	}

}
