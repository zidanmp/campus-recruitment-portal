<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.*"%>   
<!DOCTYPE html>
<%
	if(session.getAttribute("username")==null)
	{
		RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
		rd.forward(request, response);
	}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create drives</title>
<style type="text/css">
* {
	box-sizing: border-box;
}
body {
	font-family: 'Montserrat', sans-serif;
	line-height: 1.6;
	margin: 0;
	min-height: 100vh;
}
ul {
  margin: 0;
  padding: 0;
  list-style: none;
}

h2,
h3,
a {
	color: #34495e;
}

a {
	text-decoration: none;
}

.logo {
	margin: 0;
	font-size: 1.45em;
}

.main-nav {
	margin-top: 5px;
}
.logo a,
.main-nav a {
	padding: 10px 15px;
	text-transform: uppercase;
	text-align: center;
	display: block;
}

.main-nav a {
	color: #34495e;
	font-size: .99em;
}

.main-nav a:hover {
	color: #718daa;
}

.header {
 	position: sticky;
   	top: 0;
   	z-index: 100;
	padding-top: .5em;
	padding-bottom: .5em;
	border: 1px solid #a2a2a2;
	background-color: #f4f4f4;
	-webkit-box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.75);
	-moz-box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.75);
	box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.75);
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  padding: 10px 15px;
	text-transform: uppercase;
	text-align: left;
	display: block;
	color: #34495e;
	font-size: .99em;
}

.dropdown-content a:hover {
  background-color: #ddd;
  color: #718daa;
}

.dropdown:hover .dropdown-content {
  display: block;
}
.dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: #34495e;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}
.dropbtn:hover{
	color: #718daa;
}
#active{

text-decoration: underline rgb(0,100,0) 2px;
}
img
{
	margin-left:10px;
}
@media (min-width: 769px) {
	.header,
	.main-nav {
		display: flex;
	}
	.header {
		flex-direction: column;
		align-items: center;
    	.header{
		width: 80%;
		margin: 0 auto;
		max-width: 1150px;
	}
	}
}

@media (min-width: 1025px) {
	.header {
		flex-direction: row;
		justify-content: space-between;
	}
}
.drive{
	
	width:600px;
	margin-top:2%;
	margin-left:30%;
	margin-bottom:2%;
}
.login-box {
position:relative;
  padding: 40px;
  background:white;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}
.login-box h4 {
	margin: 0 0 30px;
  padding: 0;
  color: green;
  text-align: center;
}
.login-box h3 {
	margin: 0 0 30px;
  padding: 0;
  color: red;
  text-align: center;
}
.login-box h2 {
  padding: 0;
  color: #fff;
  color: #BE5504;
  text-shadow: 2px 2px 8px white;
  text-align: center;
}

.login-box a:hover {
  background: #03e9f4;
  color: #fff;
  color: black;
  border-radius: 5px;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
}
.back{
	
	position:absolute;
	margin-left:3%;
	margin-top:1%;
	border:1px solid black;
	padding:5px;
	position:fixed;
	border-radius:5px;
	background-color:rgba(0,100,250,.2);
	font-size: 12px;
}
.back a{
	width:100%;
	color: black;
}

.back a:hover{
	color: #BE5504;
	font-size: 13px;
}

</style>

</head>
<body>
	<header class="header">
		<img src="images/logo.png" alt="logo" width=80 height=auto>
      <ul class="main-nav">
          <li><a href="adminhome.jsp">Home</a></li>
          <li><a href="FetchRequests">New Registrations</a></li>
          <li><a href="Logics?unblockRequests=true">Unblock Requests</a></li>
          <li><a href="createDrives.jsp">create drives</a></li>
          <li><a id="active" href="Logics?view=true">view drives</a></li>
          <li><a href="Logics?viewApplications=true">applications</a></li>
          <li><a href="Logics?getReport=true">get report</a></li>
          <li><a href="Logics?viewStudents=true">view students</a></li>
          <li><a href="aboutus.jsp">About</a></li>
		  <li><a href="Logout">LOGOUT</a></li>
      </ul>
</header>
<div class="back"><a href="Logics?viewStudents=true">PREVIOUS</a></div>
	<div class="drive">
		<div class="login-box">
		<h4><% if(request.getAttribute("msg")!=null) {out.println(request.getAttribute("msg"));} else{ %></h4>
		<h3><% if(request.getAttribute("errormsg")!=null){out.println(request.getAttribute("errormsg"));} }%></h3>
</div>
</div>
</body>
</html>