<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Candidate Registration</title>
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
<%
		HttpSession adminSession =request.getSession();
		String login=(String)adminSession.getAttribute("username");
		//System.out.println("login:::"+login);
		if(login!=null && login!="")
			
		{
		}else{
			request.setAttribute("msg", "Login First");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		%>
	<div class="header_bg">
		<div class="container">
			<!-----start-header----->
			<div class="header">
				<div class="logo">
					<a href="index.html"><img src="images/logo1.png" alt=" " /></a>
				</div>
				<nav class="navbar navbar-default">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					  </button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="act"><a href="adminwelcome.jsp">Home</a></li>
							
							
							<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown">Candidate<b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-3">
									<div class="row">
										<div class="party">
											<ul class="multi-column-dropdown">
												<li><a href="candidate.jsp">Register Candidate</a></li>
												<li class="divider"></li>
												<li><a href="candidateRemove.jsp">Remove Candidate</a></li>
												
											</ul>
										</div>
									</div>
								</ul>
							</li>
							
							
							<li><a href="electionResult.jsp"> Result</a></li>
							<li><a href="graph.jsp">Graph</a></li>
							<li><a href="LogoutServlet">LogOut</a></li>
							
						</ul>
					</div><!-- /.navbar-collapse -->	
					
				</nav>
			</div>
		</div>
	</div>
	<div class="header_bottom">
	</div>
	
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
<div class="banner">
		<div class="container">
		
			<div class="panel panel-primary" style="margin-top: 10%; width: 50%; margin-left: 20%;">
					 <div class="panel-heading"><center>Election  Form</center></div>
					 
					 <form method="post" action="CandidateServlet" enctype="multipart/form-data">
					 <div class="panel-body">
					 
					 	<div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input id="cname" type="text" name="FullName"  class="form-control"  placeholder="Full Name" required>
						  </div>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						   <select  class="form-control" name="party">
						   <option>Select Party</option>
						   <option value="BJP">BJP</option>
						   <option value="Congres">Congres</option>
						   <option value="Shivsena">Shivsena</option>
						   <option value="NCP">NCP</option>
						   </select>
						  </div>
						  
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input id="cname" type="file" name="imgfile"  class="form-control"  placeholder="Select your Photo File" required>
						  </div>
					 </div>
 					 <div class="panel-footer">
 					 <center>
 					 	<input type="submit" class="btn btn-success" value="Submit" style="width:25%;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 					 <input type="reset" class="btn btn-danger" value="Reset" style="width:25%;">
 				
 					 </center>
 					
 					 </div>
			

  
 
</form> 

</div>
		
		</div>		
</div>


  <!-- scroll_top_btn -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
	    <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		 <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
		<!--end scroll_top_btn -->
<!-- for bootstrap working -->
	 <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //for bootstrap working -->

</body>
</html>