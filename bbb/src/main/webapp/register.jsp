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
<%
	String msg=(String)request.getAttribute("msg");
if(msg!=null)
{
	

%>

<script type="text/javascript">
alert('<%=msg%>');

</script>
<%}%>
<div class="banner">
		<div class="container">
		
			<div class="panel panel-primary" style="margin-top: 8%; width: 50%; margin-left: 20%;">
					 <div class="panel-heading"><center>Registration Form</center></div>
					 
						<form method="post" action="RegistrationServlet">
					 <div class="panel-body">
					 
					 	<div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input type="text" id="fname" name="fname" class="form-control"  size="30" pattern="[a-zA-Z]{3,30}" required placeholder="First Name">
						  </div>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input type="text" id="lname" name="lname" size="30" class="form-control"  pattern="[a-zA-Z]{3,30}" required placeholder="Last Name">
						  </div>
						  
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input input type="text" id="uname" name="uname" size="30" class="form-control"  pattern="[a-zA-Z0-9]{3,30}" required placeholder="User Name">
						  </div>
						  
						   <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input  type="date" id="birthdate" title="Enter Birth Date" name="birthdate"  class="form-control"  required placeholder="Birth Date">
						  </div>
						  
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						    <input input type="password" id="regpwd" name="regpwd"
											size="30" pattern="[a-zA-Z0-9]{8,8}" maxlength="8" class="form-control"  required placeholder="Password">
						  </div>
						  
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
						   <input type="email" id="regpwd" name="regemail"
											size="30" required placeholder="Email" class="form-control"  >
						  </div>
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
						   <input type="text" id="regpwd" name="regmobile" class="form-control" 
											size="30" pattern="[7-9]{1}[0-9]{9,9}" maxlength="10" required placeholder="Mobile No">
						  </div>
						  
						  <div class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
						   <input type="text"  id="regpwd" name="regadhar" class="form-control" 
											size="30" pattern="[0-9]{12,12}" maxlength="12" placeholder="Addhar Card No">
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


<script type="text/javascript">

$('document').ready(function() {
	
	$('#birthdate').change(function(){
		var v=$('#birthdate').val();
		
		
		
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!

		var yyyy = today.getFullYear();
		if(dd<10){
		    dd='0'+dd;
		} 
		if(mm<10){
		    mm='0'+mm;
		} 
		var today = yyyy+'/'+mm+'/'+dd;
		
		
		var diff=new Date(today) - new Date(v);
		var years = Math.floor(diff/31536000000);
		
		if(years < 18)
			{
				$('#birthdate').val('');
			alert('Your age is :'+years);
			}
	});
	
});
</script>

  

</body>
</html>