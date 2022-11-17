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

.login-box .user-box {
  position: relative;
}
.login-box .user-box select{
width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: black;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid grey;
  outline: none;
  background: transparent;
}
.login-box .user-box option{
color:black;
}
.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  color: black;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid grey;
  outline: none;
  background: transparent;
}
#cse{
	width:87%;
	position:absolute;
	margin-top:.5%;
	border-bottom: 1px solid grey;
}
#cse input{
	margin-right:4%;
}
.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  color: black;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box select:focus ~ label,
.login-box .user-box select:valid ~ label {
  top: -20px;
  left: 0;
  color: blue;
  font-size: 12px;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  color:blue;
  font-size: 12px;
}
.login-box .user-box input:nth-child(1)~ label{
  top: -20px;
  left: 0;
  color: #03e9f4;
  color:blue;
  font-size: 12px;
}
.login-box .user-box label{
  top: -20px;
  left: 0;
  color: #03e9f4;
  color:blue;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  margin-top: 40px;
  letter-spacing: 4px
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
.login-box .user-box textarea{
	font-family: 'Montserrat', sans-serif;
	border:none;
	resize:none;
	width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  color: black;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid grey;
  outline: none;
  background: transparent;
}
#forgot{
	position: relative;
  display: inline-block;
  padding: 8px 16px;
  color: #BE5504;
  font-size: 12px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 10%;
  letter-spacing: 3px;
  margin-left:4%;
  font-weight:bold;
}

#forgot:hover{
	background: grey;
  color: black;
  background: green;
  border-radius: 5px;
}
#forgo{
	position: relative;
  display: inline-block;
  padding: 8px 16px;
  color: #BE5504;
  font-size: 12px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 10%;
  letter-spacing: 3px;
  margin-left:32%;
  font-weight:bold;
}
#forgo:hover{
	background: grey;
  color: black;
  background: green;
  border-radius: 5px;
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
<script type="text/javascript">
	function checkInput(){
		var value=document.forms["checkingInput"]["ctc"].value;
		var cgpa=document.forms["checkingInput"]["cgpa"].value;
		if(isNaN(value))
		{
			alert("CTC should be a number");
			return false;
		}
		if(isNaN(cgpa))
		{
			alert("CGPA should be a number");
			return false;
		}
	}
</script>
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
<div class="back"><a href="Logics?view=true">PREVIOUS</a></div>
	<div class="drive">
		<div class="login-box">
		<%Jobs job=(Jobs)request.getAttribute("job"); %>
		<h4><% if(request.getAttribute("msg")!=null) out.println(request.getAttribute("msg")); %></h4>
		<h3><% if(request.getAttribute("errormsg")!=null) out.println(request.getAttribute("errormsg")); %></h3>
	<h3><%if(request.getAttribute("job")==null){ out.println("ERROR!");}else{  %></h3>	
  <h2>Drive Details</h2>
  <form method="post" name="checkingInput" action="Logics" onsubmit="return checkInput()">
  	<div class="user-box">
      <input style=color:green; type="text" name="jobid" value=<%=job.getJobid()%> readonly>
      <label>JOB ID</label>
    </div>
    <div class="user-box">
      <input type="text" name="title" value="<%= job.getJob_title()%>" required>
      <label>JOB TITLE (DESIGNATION)</label>
    </div>
    <div class="user-box">
      <input type="text" name="companyName" value="<%= job.getCompany_name()%>" required>
      <label>COMPANY NAME</label>
    </div>
	<div class="user-box">
		<textarea rows="4" cols="65" name="jobDesc" maxlength=250><%= job.getJob_description()%></textarea>
      <label>JOB DESCRIPTION</label>
    </div>
    <div class="user-box">
		<textarea rows="4" cols="65" name="campusDesc" maxlength=250><%= job.getCampus_description()%></textarea>
      <label>CAMPUS DESCRIPTION</label>
    </div>
    <div class="user-box">
      <input type="text" name="location" value="<%= job.getLocation()%>" required>
      <label>JOB LOCATION</label>
    </div>
    <div class="user-box">
      <input type="text" name="ctc" value="<%= job.getCtc()%>" maxlength="8" required>
      <label>CTC</label>
    </div>
    <div class="user-box">
      <input type="text" name="cgpa" value="<%= job.getMin_cgpa()%>" required>
      <label>MINIMUM CGPA</label>
    </div><%if(job.getRemarks()!=null){ %>
    <div class="user-box">
		<textarea rows="4" cols="65" name="remarks" maxlength=100 readonly><%= job.getRemarks()%></textarea>
      <label>REMARKS</label>
    </div><%} %>
    <div id="cse">
    	<label>ELIGIBLE STREAMS: </label>
    	<%String streams=job.getDepts_eligible();
    	if(streams.contains("CSE")|| streams.contains("cse")){ %>
      CSE<input type="checkbox"  name="cse" value="CSE" checked><%}else{ %>
      CSE<input type="checkbox"  name="cse" value="CSE" >
      <%}if(streams.contains("ISE") || streams.contains("ise")) {%>
      ISE<input type="checkbox" name="ise" value="ISE" checked><%}else{ %>
      ISE<input type="checkbox" name="ise" value="ISE">
      <%}if(streams.contains("EEE") || streams.contains("eee")) {%>
      EEE<input type="checkbox"  name="eee" value="EEE" checked><%}else{ %>
      EEE<input type="checkbox"  name="eee" value="EEE">
      <%}if(streams.contains("ECE") || streams.contains("ece")) {%>
      ECE<input type="checkbox" name="ece" value="ECE" checked><%}else{ %>
      ECE<input type="checkbox" name="ece" value="ECE">
      <%}if(streams.contains("ME") || streams.contains("me")) {%>
      ME<input type="checkbox" name="me" value="ME" checked><%}else{ %>
      ME<input type="checkbox" name="me" value="ME"><%}%>
    </div>
    <%if(job.getRemarks()==null){ %>
    <input id=forgot type="submit" name=update value="update">
	<input id=forgot type="submit" name=close value="close">
    <input id=forgot type="submit" name=cancel value="cancel">
    <input id=forgot type="submit" name=delete value="delete">
    <%} else{%>
    <input id=forgo type="submit" name=open value="open">
    <input id=forgot type="submit" name=delete value="delete">
  </form>
  <%}} %>
</div>
	</div>
</body>
</html>