<%@page import="com.project.bean.CandidateBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.daoImplementation.UserImpl"%>
<%@page import="com.project.daoInterface.UserInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Result</title>
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

  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
 
        <script src="js/highcharts.js"></script>


</head>
<body>

<%
		HttpSession adminSession =request.getSession();
		String login=(String)adminSession.getAttribute("username");
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
	
	 <%   
  UserInterface ui=new UserImpl();
	ArrayList<CandidateBean> al=ui.getResultList();
	String name="";
	String value="";
	  ArrayList arr1=new ArrayList();
      ArrayList arr2=new ArrayList();
	for(CandidateBean cb:al)
	{
		arr1.add(cb.getFullname());
		arr2.add(cb.getId());
	}
	
  
  
      
           
              ArrayList arr3=new ArrayList();
  
           
             
       
         
        String  CandidateName=arr1.toString().replace("[", "'").replace("]", "'")
            .replace(", ", "','");
         String  CandidateVote=arr2.toString().replace("[", "").replace("]", "")
            .replace(", "  ,   ",");
           
       
                
     %> 
    

<div class="banner">
		<div class="container">
		
			<div id="container1" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto; margin-top: 10%;">
			
			
			</div>
<!-- <div class="wrapper" style1="height:1000px;">
           <h2 class="style1"></h2>
            <div align="right"><a style="color:blue " href="student_home.jsp" class="list3" >Go Back</a></div>
        </div>    
		 -->
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

<script type="text/javascript">
$(function () {
    $('#container1').highcharts({
        title: {
            text: 'Election Result',
            x: -20 //center
        },
        subtitle: {
            text: 'Parameters: X-Axies: Candidate Name, Y-Axies: Voting Count  ',
            x: -20
        },
        xAxis: {
        	 title: {
                 text: 'Candidate Name'
             },
        	categories: [<%=CandidateName%>]
        },
        yAxis: {
            title: {
                text: 'Voting Count'
            },
            plotLines: [{
                value: 0,
                width: 0.5,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: ''
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: ' Result',
            data: [<%=CandidateVote%>]
        }
        
       
        ]
    });
});

</script>
</body>
</html>