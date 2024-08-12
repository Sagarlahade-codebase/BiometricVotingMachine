<%@page import="com.project.daoImplementation.UserImpl"%>
<%@page import="com.project.daoInterface.UserInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*" %> 
<%@ page trimDirectiveWhitespaces="true" %>
<%

		 String path=request.getParameter("id");
//String path="C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg";

System.out.println("path:"+path);
        // String name=request.getParameter("name");
		
        UserInterface ui=new UserImpl();
        InputStream readImg=ui.getImageFile(Integer.parseInt(path));
		
		
		
		
			int len=readImg.available();
			
			byte [] rb = new byte[len];
			
			
			
			int index=readImg.read(rb, 0, len);  
			System.out.println("(rb.length="+len);
			
			response.reset();
			response.setContentType("image/jpg");
			response.setHeader("Content-disposition","attachment; filename=" );
			response.getOutputStream().write(rb,0,len); 
			response.getOutputStream().flush();  
		
%>
