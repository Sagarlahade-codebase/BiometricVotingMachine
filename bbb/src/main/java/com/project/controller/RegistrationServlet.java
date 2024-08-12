package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Register;
import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
	
	String  fname, lname, username, password, email, mobile, addharcard,birthdate;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Register reg = new Register();
		
		PrintWriter out = response.getWriter();
		 fname=request.getParameter("fname");
		 lname=request.getParameter("lname");
		 username=request.getParameter("uname");
		 password=request.getParameter("regpwd");
		 email=request.getParameter("regemail");
		 mobile=request.getParameter("regmobile");
		 addharcard=request.getParameter("regadhar");
		 birthdate=request.getParameter("birthdate");
		 
		 System.out.println("birthdate::"+birthdate);
		 
	//	 Date birth=new Date(birthdate);
		 
		 
		reg.setfName(fname);
		reg.setlName(lname);
		reg.setUsername(username);
		reg.setPassword(password);
		reg.setMobile(mobile);
		reg.setEmail(email);
		reg.setAddhar(addharcard);
		//reg.setBirthdate(birth);
		reg.setBirthdate1(birthdate);
		
		System.out.println(request.getParameter("regadhar"));
		UserInterface ui=new UserImpl();
		int j=ui.checkUser(username, email, mobile);
				System.out.println("jj:"+j);
		
		if(j==0)
		{
			int i=ui.registerUser(reg);
			if(i>0) {
				
				int k=ui.getRegisterUserId();
				HttpSession session=request.getSession();
				session.setAttribute("id", k);
				
				out.println("<script>alert(\"Registration done!\");</script>");
				request.getRequestDispatcher("/registerThumb.jsp").forward(request, response);
				
			}
			else {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				
				out.println("<script>alert(\"Registration Unsuccessful!!\");</script>");
				
			}
		}else if(j==1)
		{
			request.setAttribute("msg", "Username already exist");
			System.out.println("username");
			//out.println("<script>alert(\"username!\");</script>");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if(j==2)
		{
			request.setAttribute("msg", "Email already exist");
			System.out.println("email");
			//out.println("<script>alert(\"email!\");</script>");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}else if(j==3)
		{
			request.setAttribute("msg", "Mobile already exist");
			System.out.println("mobile");
			//out.println("<script>alert(\"Mobile!\");</script>");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
		
		
	}
		
		
	}


