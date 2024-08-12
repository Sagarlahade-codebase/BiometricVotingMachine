<!DOCTYPE HTML>
<html>
<head>
<title>Biometric Voting Machine Instructions | w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Biometric Voting Machine, Instructions, Election Responsive Web Template" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Custom Styles for Instructions -->
<style>
/* Custom Styles for Instructions Page */
.instructions-section {
    padding: 40px;
    background-color: #f9f9f9;
    color: #333;
    border-radius: 5px;
    margin-top: 20px;
}

.instructions-section h2 {
    font-size: 28px;
    color: #007bff;
    margin-bottom: 20px;
}

.instructions-section h3 {
    font-size: 24px;
    color: #333;
    margin-bottom: 15px;
}

.instructions-section ul {
    list-style-type: disc;
    margin-left: 20px;
    line-height: 1.6;
}

.instructions-section ul li {
    margin-bottom: 10px;
}
</style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<!-- contact -->
<div class="contact">
    <div class="container">
        <h3>BioMetric Voting Machine.</h3>
        <p class="nihil">Identify Voter By Its FingerPrints</p>

        <!-- Instructions Section -->
        <div class="instructions-section">
            <h2>Biometric Voting Machine: How to Use</h2>

            <h3>Admin Instructions:</h3>
            <ul>
              <li>Download necessary resources and documentation from the <a href="https://drive.google.com/drive/folders/13RauvJ1W8dGDBrVouo59XpyvM-xYky7w?usp=sharing" target="_blank">Google Drive link</a>.</li>
            
                <li>Log in using username: admin and password: admin</li>
                <li>Add candidates by adding their party photo, name and party symbol.</li>
                <li>Admin can see result of election and graphs. </li>
                <li>Verify and register the voters' biometric data.</li>
                <li>Monitor the voting process and handle any issues that arise.</li>
            </ul>

            <h3>User Process:Registration</h3>
            <ul>
                <li>Approach the biometric voting machine and follow the on-screen instructions.</li>
                <li>Election officer register user by adding their name , email , password etc.</li>
                <li>In next step, Officer upload fingerprint of user. </li>
                <li>Web App capture all fingerprint details and stored to system , to identify voter by it's fingerprint in future</li>
            </ul>
              <h3>User Process:Voting Day</h3>
            <ul>
                <li>Voter Will log in by providing its username and password, generated while registration.</li>
                <li>After Successful login, user uploads his fingerprint.</li>
                <li>Manutia Fingerprint Algorithm takes input fingerprint and match with stored fingerprint features. </li>
                <li>Note- use same persons fingerprint that used while registration.</li>
                <li>If fingerprint match user get OTP on registered email.</li>
                <li>After OTP matching user is allow to cast vote</li>
            </ul>
        </div>
        <!-- End Instructions Section -->

        <div class="clearfix"></div>
    </div>
</div>
<!-- //footer -->
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
