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

.back{
	position:absolute;
	margin-left:15.5%;
	margin-top:-1.8%;
	border:1px solid black;
	padding:5px;
	position:fixed;
	border-radius:5px;
	background-color:rgba(0,100,250,.2);
	font-size: 12px;
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
	width:15%;
	position:absolute;
	margin-left:3%;
	margin-top:6%;
}
.filter select{
	color:black;
	font-family: 'Montserrat', sans-serif;
	display:block;
	width:100%;
	margin-top:4%;
	padding:5px;
	border-radius:10px;
}
.filter select:hover{
	color: #BE5504;
}
</style>
<script type="text/javascript">
	function checkDesignation(){
		var designation=document.forms["checkingInput"]["designation"].value;
		if(designation=="Filter by Designation")
		{
			alert("Please select a designation");
			return false;
		}
	}
	function checkLocation(){
		var location=document.forms["checkingLocation"]["location"].value;
		if(location=="Filter by Job Location")
		{
			alert("Please select a Location");
			return false;
		}
	}
	function checkCtc(){
		var ctc=document.forms["checkingCtc"]["ctc"].value;
		if(ctc=="Filter by CTC")
		{
			alert("Please select a CTC");
			return false;
		}
	}
</script>
</head>
<body>
<header class="header">
		<img src="images/logo.png" alt="logo" width=80 height=auto>
      <ul class="main-nav">
          <li><a href="studenthome.jsp">Home</a></li>
          <li><a id="active" href="Logics?viewDrives=true">drives</a></li>
          <li><a href="Logics?usn=<%=session.getAttribute("username") %>&viewApplicationHistory=true">history</a></li>
          <li><a href="Logics?usn=<%=session.getAttribute("username") %>&studentProfile=true">profile</a></li>
          <li><a href="aboutusStudent.jsp">About Us</a></li>
		  <li><a href="Logout">LOGOUT</a></li>
      </ul>
</header>
<% if((request.getAttribute("msg")==null)&&(request.getAttribute("errormsg")==null)&&(request.getAttribute("drives")!=null)&&(request.getAttribute("designation")!=null)&&(request.getAttribute("location")!=null)&&(request.getAttribute("ctc")!=null)){
	ArrayList<String> designation, location;
	ArrayList<Float> ctc;
	designation=(ArrayList<String>)request.getAttribute("designation");
	location=(ArrayList<String>)request.getAttribute("location");
	ctc=(ArrayList<Float>)request.getAttribute("ctc");
%>
<div class="filter">
	<form action="Logics" method=post name="checkingInput" onsubmit="return checkDesignation()">
	<input type=text name=branch value="<%=request.getAttribute("branch")%>" hidden>
	<select name="designation">
		<option >Filter by Designation</option>
		<%if(request.getAttribute("desig")!=null){
		for(String desig : designation){ 
			if(desig.equals(request.getAttribute("desig")))
			{%>
				<option value="<%=desig%>" selected><%=desig %></option>
			<%}else{%>
			<option value="<%=desig%>"><%=desig %></option><%
		%>
		<option value="<%=desig%>"><%=desig %></option>
		<%} }}else{
			for(String desig : designation){ %>
			<option value="<%=desig%>"><%=desig %></option>
		<%} }%>
		
		
	</select>
	<input class=back type="submit" name="filterDesignation" value="FILTER">
	</form>
	<form action="Logics" method=post name="checkingCtc" onsubmit="return checkCtc()">
		<input type=text name=branch value="<%=request.getAttribute("branch")%>" hidden>
	<select name="ctc">
		<option >Filter by CTC</option>
		<%if(request.getAttribute("c")!=null){
		for(Float c : ctc){			
			if(c==(Float.parseFloat((String)request.getAttribute("c"))))
			{%>
				<option value="<%=c%>" selected><%=c %></option>
			<%}else{%>
			<option value="<%=c%>"><%=c %></option><%
		%>
		<option value="<%=c%>"><%=c %></option>
		<%} }}else{
			for(Float c : ctc){ %>
			<option value="<%=c%>"><%=c %></option>
		<%} }%>
		
	</select>
		<input class=back type="submit" name="filterCtc" value="FILTER">
	</form>
	<form action="Logics" method=post name="checkingLocation" onsubmit="return checkLocation()">
		<input type=text name=branch value="<%=request.getAttribute("branch")%>" hidden>
	<select name="location">
		<option >Filter by Job Location</option>
		<%if(request.getAttribute("loc")!=null){
		for(String loc : location){ 
			if(loc.equals(request.getAttribute("loc")))
			{%>
				<option value="<%=loc%>" selected><%=loc %></option>
			<%}else{%>
			<option value="<%=loc%>"><%=loc %></option><%
		%>
		<option value="<%=loc%>"><%=loc %></option>
		<%} }}else{
			for(String loc : location){ %>
			<option value="<%=loc%>"><%=loc %></option>
		<%} }%>
	</select>
	<input class=back type="submit" name="filterLocation" value="FILTER">
	</form>
	</div>
<%}%>
<div class="drives">
	<h4><% if(request.getAttribute("msg")!=null) out.println(request.getAttribute("msg")); %></h4>
	<h3><% if(request.getAttribute("errormsg")!=null) out.println(request.getAttribute("errormsg")); %></h3>
	<%
	if((request.getAttribute("drives")==null)){%>
		<div class="head"><center>There is no drives</center></div>
	<%}else{ %>
		<div class="heading"><center>DRIVES</center></div>
	<%ArrayList drives;
	drives=(ArrayList)request.getAttribute("drives");
	for(Object obj : drives){
		String[] drive=(String[])obj;%>
		<a href="Logics?company=<%= drive[0]%>&title=<%= drive[1] %>&viewDetailedDrive=true"><table>
			<tr><td><%= drive[0]%></td><td><%= drive[1] %></td></tr>
		</table></a>
	<%}
	}%>
</div>
</body>
</html>