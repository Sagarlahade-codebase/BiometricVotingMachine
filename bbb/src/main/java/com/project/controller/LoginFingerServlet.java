package com.project.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;
import com.project.utility.Sendmail;
import com.project.utility.Util;

import processing.FR;


/**
 * Servlet implementation class LoginFingerServlet
 */
@WebServlet("/LoginFingerServlet")
@MultipartConfig(maxFileSize=1024*1024*50)
public class LoginFingerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFingerServlet() {
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
	
	String path;
	InputStream is=null;
	String name="";
	String exten="";
	File uploadPath=null;
	BufferedImage bi=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession loginSession=request.getSession();
		int id=(Integer)loginSession.getAttribute("userID");
		path=request.getServletContext().getRealPath("/output");
		//path="D://Register";
		
		
		
		Part part=request.getPart("file");
		if(part!=null);
		{
			is=part.getInputStream();
			name=getFileName(part);
			File ff=new File(path+"/"+id+"/"+name);
			
			
			if(!ff.isDirectory())
			{
				ff.mkdirs();
			}
			
			 int extensionIndex = name.lastIndexOf(".");
		     exten = name.substring(extensionIndex + 1);
			bi=ImageIO.read(is);
			uploadPath=new File(ff.getAbsolutePath()+"/"+name);
			ImageIO.write(bi, exten,uploadPath );
		}
		
		UserInterface ui=new UserImpl();
		ArrayList<String> al=ui.getAllFingerprint(id);
		FR fr=new FR();
		 int i;
		 
		 BufferedImage bufferedImage = ImageIO.read(uploadPath);
		 
		 int[][] binarizing = FR.binarizing(bufferedImage);
		 
		 int[][] fastParallelAlgoSkeleton = FR.getFastParallelAlgoSkeleton(binarizing);
		 int[][] cn = FR.getCN(fastParallelAlgoSkeleton);  
		 FR[] graph1=FR.genGraph(cn);
		 
		 boolean loginSuccessful = false;

	       
	        
	        for(String s:al)
	        {
	               int k= FR.compare(graph1, 
	                		 FR.genGraph( 
	                				 FR.getCN(
	                						 FR.getFastParallelAlgoSkeleton(
	                								 FR.binarizing(
	                                    ImageIO.read(new File(s)))))) );
	               System.out.println("k::"+k);
	               
	               if( k<100000 )
	               {
	            	   String mail=ui.getEmail(id);
	            	   Util u=new Util();
	            	   String otp=u.getOTP();
	            	   
	            	   Sendmail.SendOTPEmail(mail, otp, "Verification OTP");
	            	   HttpSession otpsession=request.getSession();
	            	   otpsession.setAttribute("otp", otp);
	            	   otpsession.setAttribute("time", System.currentTimeMillis());
	            	  // request.getRequestDispatcher("matchOtp.jsp").forward(request, response);
	            	   response.sendRedirect("matchOtp.jsp");
	            	   loginSuccessful=true;
	            	   break;
	               }
	               
	        }
	        
	        if (!loginSuccessful) {
	            // Redirect to the login page with a failure message
	            response.sendRedirect("login.jsp?message=Login+failed. Please try again.");
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
