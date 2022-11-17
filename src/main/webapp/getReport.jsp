<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="Model.*" %>
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
<title>View drives</title>
<style type="text/css">
h1{
	color: #BE5504;
	font-size:30px;
	background-color: rgba(0,0,0,.1);
	width:100%;
	text-align:center;
	margin-bottom:1%;
}
h2{
	color:black;
	font-size:25px;
	display:inline-block;
	margin-right:.5%;
	margin-left:2.5%;
}
a:hover{cursor:pointer; }

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

h3 {
	margin-top:1% ;
	margin-bottom:0;
  padding: 0;
  color: red;
  font-size: 30px;
  text-align: center;
}
h4{
	margin-top:1% ;
  padding: 0;
  color: green;
  font-size: 20px;
  text-align: center;
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
table {
  border-collapse: collapse;
  width: 80%;
  margin-left:10%;
}

th, td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #DDD;
}

tr:hover {background-color: #D6EEEE;}
.thead:hover{background-color: white;}
.heading{
	width:80%;
	margin-left:10%;
	margin-top:3%;
	font-family: 'Montserrat', sans-serif;
	font-size:2em;
	color:#BE5504;
	text-shadow: 2px 2px 8px white;
	border-bottom: 1px solid #DDD;
	background-color: rgb(211,211,211,.7);
	font-weight: bold;
}
.button {
  background-color: white;
  border-color:black;
  color: white;
  padding: 5px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 2px;
  margin: 4px 2px;
  border-radius: 50%;
  cursor: pointer;
}
#acc:hover{
	background-color:rgba(0,100,0,.6);
	border-color:grey;
}
#rej:hover{
	background-color:rgba(100,0,0,.6);
	border-color:grey;
}
.b{
	text-align: center;
}
.all{
	text-align: center;
	padding: 10px;
	color:blue;
	border-radius:8px;
	cursor: pointer;
	font-family: 'Montserrat', sans-serif;
	font-weight: bold;
}

#accept{
	margin-left:41%;
	margin-top:2%;
}
#reject{
	margin-left:4%;
}
#accept:hover{
	background-color:rgba(0,100,0,.6);
	border-color:grey;
	color:black;
}
#reject:hover{
	background-color:rgba(100,0,0,.6);
	border-color:grey;
	color:black;
}
.back{
	display:inline-block;
	border:1px solid black;
	padding:3px;
	border-radius:5px;
	font-size: 12px;
	color:black;
}
.goback{
	position:absolute;
	margin-left:3%;
	margin-top:3%;
	border:1px solid black;
	padding:5px;
	position:fixed;
	border-radius:5px;
	background-color:rgba(0,100,250,.2);
	font-size: 12px;
}
.goback a{
	width:100%;
	color: black;
}

.goback a:hover{
	color: #BE5504;
	font-size: 13px;
}
.back input{
	width:100%;
	color: black;
}

.back:hover{
	color: #BE5504;
	font-size: 13px;
	cursor:pointer;
}
.filter{
	margin-top:5%;
	background-color:rgba(0,0,0,.1);
	width:35%;
	margin-left:33%;
}
.filter select{
	color:black;
	font-family: 'Montserrat', sans-serif;
	display:inline-block;
	padding:5px;
	border-radius:10px;
	font-size:18px;
	margin-left:8%;
	width:80%;
	margin-right:.5%;
	margin-bottom:5%;
}
.filter select:hover{
	color: #BE5504;
}
</style>
<script type="text/javascript">
	function checkBranch(){
		var branch=document.forms["checkingBranch"]["branch"].value;
		if(branch=="generate report by branch")
		{
			alert("Please select a branch");
			return false;
		}
	}
	function checkCompany(){
		var company=document.forms["checkingCompany"]["company"].value;
		if(company=="generate report by company")
		{
			alert("Please select a company name");
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
          <li><a href="Logics?view=true">view drives</a></li>
		  <li><a href="Logics?viewApplications=true">applications</a></li>
          <li><a id="active" href="Logics?getReport=true">get report</a></li>
          <li><a href="Logics?viewStudents=true">view students</a></li>
          <li><a href="aboutus.jsp">About us</a></li>
		  <li><a href="Logout">LOGOUT</a></li>
      </ul>
</header>
	<%if(request.getAttribute("errormsg")!=null){ %>
	<h3><center>There is no reports</center></h3><%} %>
	<% if(request.getAttribute("students")==null){ %>
	<div class="filter">
	<h1>Placed Students</h1>
	<form action="Logics" method=post>
	<h2>Generate report of all placed students-</h2>
	<input class=back type="submit" name="allStudentReport" value="GET">
	</form>
	<form action="Logics" method=post name="checkingBranch" onsubmit="return checkBranch()">
	<select name="branch">
		<option >generate report by branch</option>
		<option value="cse">CSE</option>
		<option value="ise">ISE</option>
		<option value="ece">ECE</option>
		<option value="eee">EEE</option>
		<option value="me">ME</option>
	</select>
	<input class=back type="submit" name="branchReport" value="GET">
	</form>
	<%ArrayList<String> companies=(ArrayList<String>)request.getAttribute("companies"); 
		if(companies!=null){%>
			<form action="Logics" method=post name="checkingCompany" onsubmit="return checkCompany()">
			<select name="company">
				<option >generate report by company</option><%
			for(String c: companies)
			{%>
				<option value="<%=c%>"><%=c %></option>
			<%}%>
			</select>
			<input class=back type="submit" name="companyReport" value="GET">
			</form>	
		<%}%>
	</div>
	<%}else{
		ArrayList students=(ArrayList) request.getAttribute("students");%>
		<div class="goback"><a href="Logics?getReport=true">PREVIOUS</a></div>
	<div class="heading"><center>All Placed Students Details</center></div>
		<table>
  			<tr class="thead">
    			<th>USN</th><th>NAME</th><th>Company Name</th><th>CTC</th>
  			</tr>
  			<%for(Object stu : students) {
  				String[] a=(String[])stu;
  			%>
  			<tr>
    			<td><%=a[0] %></td>
    			<td><%=a[1] %></td>
    			<td><%=a[2] %></td>
    			<td><%=a[3] %></td>		
  			</tr>
  			<%}%>
		</table>
	<%} %>
</body>
</html>