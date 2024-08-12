<%@page import="com.project.bean.CandidateBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.daoImplementation.UserImpl"%>
<%@page import="com.project.daoInterface.UserInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Election Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<!---strat-slider---->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!---//-slider---->

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="banner">
		<div class="container">
		
		<%
		HttpSession loginSession =request.getSession();
		int i=(Integer)loginSession.getAttribute("userID");
		if(i>0)
		{}else{
			request.setAttribute("msg", "Login First");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		%>
		
		
		<%
	
	String msg=(String)request.getAttribute("msg");
							if(msg!=null && msg!="")
							{
	%>
	<script type="text/javascript">
	alert('<%=msg%>');
	
	</script>
	<%
							}
	%>
		<div class="row">
			<div class="col-md-12">
			
			<%
			   UserInterface ui=new UserImpl();
			ArrayList<CandidateBean> al=ui.getCandidateList();
			if(al!=null)
			{
			for(CandidateBean cb:al)
			{
			%>
			
			<div class="panel panel-primary col-md-3" style="margin-top: 10%; width1: 50%; margin-left1: 20%;">
					 <div class="panel-heading"><center>Candidate </center></div>
					 
					
					 <div class="panel-body">
					 <center>
					 <img src="candidateImage.jsp?id=<%=cb.getId()%>" width="20%"></img>
					
					 </center>
					  	 
					 	<br>
					 	<label>Name:<%=cb.getFullname() %></label><br>
					 	<label>Party: <%=cb.getParty() %></label>
					 	 
					 </div>
 					 <div class="panel-footer">
 					<center>
			<a href="VoteServlet?id=<%=cb.getId()%>"  class="btn btn-success" >Vote</a>
 					 	
 					 </center>
 					
 					 </div>
			
			
</div>


					


<%
			}
			}else{
				
			
%>

<label>  Candidate Not Available</label>


<%} %>





			</div>
		</div>
		
			
		
		</div>		
</div>


  

</body>
</html>