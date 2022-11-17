<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
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
<title>admin home</title>
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
h4{
	margin-left:0%;
	margin-top:1% ;
  padding: 0;
  color: green;
  font-size: 20px;
  text-align: center;
}
</style>
</head>
<body>
	<header class="header">
		<img src="images/logo.png" alt="logo" width=80 height=auto>
      <ul class="main-nav">
          <li><a href="adminhome.jsp">Home</a></li>
          <li><a id="active" href="#">New Registrations</a></li>
          <li><a href="Logics?unblockRequests=true">Unblock Requests</a></li>
          <li><a href="createDrives.jsp">create drives</a></li>
          <li><a href="Logics?view=true">view drives</a></li>
          <li><a href="Logics?viewApplications=true">applications</a></li>
          <li><a href="Logics?getReport=true">get report</a></li>
          <li><a href="Logics?viewStudents=true">view students</a></li>
          <li><a href="aboutus.jsp">About US</a></li>
		  <li><a href="Logout">LOGOUT</a></li>
      </ul>
</header>
<h4><% if(request.getAttribute("msg")!=null) {out.println(request.getAttribute("msg"));}%></h4>
<%
	if(request.getAttribute("requests")==null)
	{ %>
		<div class="heading"><center>There is no Registration Requests</center></div>
	<%}else{ArrayList<Students> requests=(ArrayList<Students>) request.getAttribute("requests");
%>
	<div class="heading"><center>REQUESTS</center></div>
	<form method=post action="Logics">
		<table>
  			<tr class="thead">
    			<th>USN</th><th>NAME</th><th>EMAIL</th><th>PHONE</th><th>DEPT NAME</th><th>CGPA</th><th class="b">ACCEPT</th><th class="b">REJECT</th>
  			</tr>
  			<%for(Students s : requests) {%>
  			<tr>
    			<td><%= s.getUsn() %></td>
    			<td><%= s.getName() %></td>
    			<td><%= s.getEmail() %></td>
    			<td><%= s.getPhone() %></td>
    			<td><%= s.getDept_name() %></td>
    			<td><%= s.getCgpa() %></td>
    			<td class="b"><button class="button" name="accept" id="acc" value="<%= s.getUsn() %>"></button></td>
    			<td class="b"><button class="button" name="reject" id="rej" value="<%= s.getUsn() %>"></button></td>
  			</tr>
  			<%} %>
		</table>
		<button class="all" id="accept" name="acceptall" >ACCEPT ALL</button>
		<button class="all" id="reject" name="rejectall" >REJECT ALL</button>	
	</form>
	<%} %>
</body>
</html>