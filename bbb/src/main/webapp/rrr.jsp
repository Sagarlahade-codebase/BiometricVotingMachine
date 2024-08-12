<%@page import="java.io.File"%>
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

<script type="text/javascript" language="javascript">
function changeTab(getTab){
	
	var chkTab;
	
	switch(getTab){
	
	case 'tab2':
		 document.getElementById('innerData').innerHTML=document.getElementById("gray").innerHTML; 	 
		break;
	case 'tab3':
		 document.getElementById('innerData').innerHTML=document.getElementById("binary").innerHTML; 	 
		break;
	case 'tab4':
		 document.getElementById('innerData').innerHTML=document.getElementById("thin").innerHTML; 	 
		break;
	case 'tab5':
		 document.getElementById('innerData').innerHTML=document.getElementById("refine").innerHTML; 	 
		break;
	
	} 
	
}


</script>



<jsp:include page="header.jsp"></jsp:include>

<%
       String path=(String)request.getAttribute("path");

       String filename=new File(path).getName();
       String dir=new File(path).getParent();
       %>

<div class="banner">
		<div class="container">
		
			<div class="row">            
		<div class="col-sm-12">
			 <div class="col-sm-4" style="height:500px; margin-top:10%;">
        <br>
         <a id="tab2" class="btn btn-primary" onclick="changeTab(this.id);" style="width:50%;">GrayScale Image</a><br><br>
         <a id="tab3" class="btn btn-primary" onclick="changeTab(this.id);" style="width:50%;">Binary</a><br><br>
       <a id="tab4" class="btn btn-primary" onclick="changeTab(this.id);" style="width:50%;">Thin</a><br><br>
       <a id="tab5" class="btn btn-primary" onclick="changeTab(this.id);" style="width:50%;">Refine</a><br><br>
         <a href="login.jsp" id="tab6" class="btn btn-primary" onclick="changeTab(this.id);" style="width:50%;">Login</a>
        </div>
        
       
        <div id="innerData" class="col-sm-8" style="margin-top:10%; height:500px;">
        
      
       
       
         <img src="Image.jsp?path=<%=path %>" width="50%"></img>
        
        
        </div>
       
        
        </div>
        </div>
        
        
        
        
        
        
               <div id="gray" style="display: none;">
  <%
        String grayPath=dir+"/"+"gray"+filename;
  //System.out.println("edgePath:"+grayPath);
        %>
        <img src="Image.jsp?path=<%=grayPath%>" width="40%"></img>
</div>	                    


<div id="binary" style="display: none;">
  <%
        String binaryPath=dir+"/"+"binary"+filename;
 // System.out.println("binaryPath:"+binaryPath);
        %>
        <img src="Image.jsp?path=<%=binaryPath%>" width="40%"></img>
</div>

<div id="thin" style="display: none;">
  <%
        String thinPath=dir+"/"+"thin"+filename;
 // System.out.println("thinPath:"+binaryPath);
        %>
        <img src="Image.jsp?path=<%=thinPath%>" width="40%"></img>
</div>	

 

<div id="refine" style="display: none;">
  <%
        String refinePath=dir+"/"+"refine"+filename;
  //System.out.println("refine:"+refinePath);
        %>
        <img src="Image.jsp?path=<%=refinePath%>" width="40%"></img>
</div>		                    
        
		
		</div>		
</div>


  

</body>
</html>