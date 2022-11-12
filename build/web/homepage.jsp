<%-- 
    Document   : homepage
    Created on : Jul 6, 2021, 4:15:04 PM
    Author     : Hanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Homepage</title>
	<link rel="stylesheet" type="text/css" href="styleHome.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@500&display=swap" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="navbar">
			<img src="imageHome/logo.png" class="logo">
			<nav>
				<ul>
					<li><a href="#homepage">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="tips.jsp">Tips</li>
					<li>
					<div class="dropdown"><a>Login</a>
				    <div class="dropdown-content">
				      <a href="loginAdmin.jsp">Admin</a>
				      <a href="loginOrg.jsp">Organization</a>
				      <a href="loginDonor.jsp">Donor</a>
				    </div>
					</div></li>
				</ul>
			</nav>
			<img src="imageHome/menu.png" class="menu-icon">
		</div>
<a id="homepage">
		<div class="row">
			<div class="col">
				<h1>Donate Your Blood</h1>
				<h5>Be a hero to someone. You can make a difference in the lives of others. </h5>
			    <button><a href="about.html" class="card-link">Read More</a></button>
			</div>

			<div class="col">
				<a href="#tips"><div class="card card1"></div></a>
				<a href="#misconception"><div class="card card2"></div></a>
			</div>
		</div>
		<a id="about">
		<div class="row" >
			<div class="image">
                    <img src="imageHome/logo.png" width="400" height="500">
                  </div>
                  <div class="text">
                    <p>MERCY is a registered body, to promote the interest and welfare of society throughout the nation, irrespective on their race, religion, gender or political inclination.

                    We believe there are a good numbers blood donors in the country and hoped that many will sign in as donor.

                    We will also negotiate with public and private sectors for the granting of special privileges to the donors as their token of appreciation for what they contribute to the community and as an incentives for them to continue to be blood donors.</p>
                  </div>
		</div>
	</a>
</body>
</html>