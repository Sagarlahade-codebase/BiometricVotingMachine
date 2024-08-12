<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Election Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> 
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } 
</script>
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
        <div class="panel panel-primary" style="margin-top: 10%; width: 50%; margin-left: 20%;">
            <div class="panel-heading"><center>Login Form</center></div>
            
            <form method="post" action="LoginServlet">
                <div class="panel-body">
                    <!-- Display message if present -->
                    <c:if test="${param.message != null}">
                        <div class="alert alert-danger">
                            ${param.message}
                        </div>
                    </c:if>
                    
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="email" type="text" name="username" class="form-control" placeholder="UserName" pattern="[a-zA-Z0-9]{3,12}" required>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" name="password" class="form-control" maxlength="8" placeholder="Password" pattern="[a-zA-Z0-9]{8,8}" required>
                    </div>
                </div>
                <div class="panel-footer">
                    <center>
                        <input type="submit" class="btn btn-success" value="Submit" style="width:25%;"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" class="btn btn-danger" value="Reset" style="width:25%;">
                        <br> <br><a href="register.jsp">New User? Register</a>
                    </center>
                </div>
            </form>
        </div>
    </div>      
</div>
</body>
</html>
