<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
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
.drives{
	width:100%;
}
.heading{
	margin-top:2%;
	margin-bottom:1%;
	color: #BE5504;
	font-size:35px;
	font-weight:bold;
}
.head{
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
table{
	border-collapse:collapse;
	width:50%;
	height:80px;
	margin-bottom:2%;
	margin-left:25%;
	box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.40);
	-webkit-border-radius: 5px;
}
table:hover{
	margin-left:26%;
	width:48%;
	cursor:pointer;
	box-shadow: 0px 0px 14px 0px rgba(0,0,0,0.75);
	-webkit-border-radius: 5px;
}
td{
	width:50%;
	padding:10px;
}
td:nth-child(1)
{
	font-size:20px;
	font-weight:bold;
	text-align:center;
	background-color:rgba(100,0,50,0.1);
	color:#BE5504;
	text-shadow: 1px 0 0 orange;
	
}
td:nth-child(2)
{
	background-color:rgba(100,50,0,0.3);
}
.drives h4 {
	margin: 0 0 30px;
  padding: 0;
  color: green;
  text-align: center;
}
.drives h3 {
	margin: 0 0 30px;
  padding: 0;
  color: red;
  text-align: center;
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
          <li><a href="aboutus.jsp">About us</a></li>
		  <li><a href="Logout">LOGOUT</a></li>
      </ul>
</header> 
<div class="drives">
	<h4><% if(request.getAttribute("msg")!=null) out.println(request.getAttribute("msg")); %></h4>
	<h3><% if(request.getAttribute("errormsg")!=null) out.println(request.getAttribute("errormsg")); %></h3>
	<%
	if((request.getAttribute("drives")==null)||(request.getAttribute("closedDrives")==null)||(request.getAttribute("cancelledDrives")==null)){%>
		<div class="head"><center>There is no drives</center></div>
	<%}else{ 
		if(request.getAttribute("drives")!=null){%>
		<div class="heading"><center>OPEN DRIVES</center></div>
	<%ArrayList drives;
	drives=(ArrayList)request.getAttribute("drives");
	for(Object obj : drives){
		String[] drive=(String[])obj;%>
		<a href="Logics?company=<%= drive[0]%>&title=<%= drive[1] %>&indetail=true"><table>
			<tr><td><%= drive[0]%></td><td><%= drive[1] %></td></tr>
		</table></a>
	<%}}
	if(request.getAttribute("closedDrives")!=null)
	{%>
	<div class="heading"><center>CLOSED DRIVES</center></div>
		<%ArrayList closedDrives;
		closedDrives=(ArrayList)request.getAttribute("closedDrives");
		for(Object obj : closedDrives){
			String[] closedDrive=(String[])obj;%>
			<a href="Logics?company=<%= closedDrive[0]%>&title=<%= closedDrive[1] %>&indetail=true"><table>
				<tr><td><%= closedDrive[0]%></td><td><%= closedDrive[1] %></td></tr>
			</table></a>
		<%
	}}
	if(request.getAttribute("cancelledDrives")!=null)
	{%>
	<div class="heading"><center>CANCELLED DRIVES</center></div>
		<%ArrayList cancelledDrives;
		cancelledDrives=(ArrayList)request.getAttribute("cancelledDrives");
		for(Object obj : cancelledDrives){
			String[] cancelledDrive=(String[])obj;%>
			<a href="Logics?company=<%= cancelledDrive[0]%>&title=<%= cancelledDrive[1] %>&indetail=true"><table>
				<tr><td><%= cancelledDrive[0]%></td><td><%= cancelledDrive[1] %></td></tr>
			</table></a>
		<%
	}}
	}%>
</div>
</body>
</html>