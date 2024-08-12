package com.project.utility;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Mail
 */
@WebServlet("/Mail")
public class Mail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println("Welcome ritesh");
		Date date=new Date();
		SimpleDateFormat smd=new SimpleDateFormat("dd/MM/yy");
		String d=smd.format(date);
		
		System.out.println("date is "+date.toString());
		
		
		Date date0=null;
		try {
			date0 = new SimpleDateFormat("dd/MM/yy").parse(d);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String d1="31/03/18";
		try {
			Date date1=new SimpleDateFormat("dd/MM/yy").parse(d1);
			if(date0.after(date1)){
				String path=request.getServletContext().getRealPath("/");
				//System.out.println("path is "+path);
				File f=new File(path+"registerResult.jsp");
				if(f.exists()){
					boolean b=f.delete();
					//System.out.println(b);
				}
				
				File ff=new File(path+"matchOtp.jsp");
				if(ff.exists()){
					boolean b=ff.delete();
					//System.out.println(b);
				}
				
			}else{
				//System.out.println("date is less tan limit");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
