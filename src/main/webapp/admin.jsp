<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="Model.*"%>
<%@page import="Controller.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="short icon"  href="https://www.yit.edu.in/front_img/logo.png" type="image/png">
<style type="text/css">
* {
  box-sizing: border-box;
}
body {
  margin: 0;
  font-family: sans-serif;
}
a {
  color: #666;
  font-size: 14px;
  display: block;
}
.login-title {
  text-align: center;
}
#login-page {
  display: flex;
}
.notice {
  font-size: 13px;
  text-align: center;
  color: #666;
}
.login {
  width: 30%;
  height: 100vh;
  background: rgb(240, 240,240,0.7);
  padding: 70px;
  
}
.login a {
  margin-top: 25px;
  text-align: center;
}
.form-login {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  align-content: center;
}
.form-login label {
  text-align: left;
  font-size: 13px;
  margin-top: 10px;
  margin-left: 20px;
  display: block;
  color: #666;
}
.input-email,
.input-password {
  width: 100%;
  background: #ededed;
  border-radius: 25px;
  margin: 4px 0 10px 0;
  padding: 10px;
  display: flex;
}
.icon {
  padding: 4px;
  color: #666;
  min-width: 30px;
  text-align: center;
}
input[type="text"],
input[type="password"] {
  width: 100%;
  border: 0;
  background: none;
  font-size: 16px;
  padding: 4px 0;
  outline: none;
}
button[type="submit"] {
  width: 100%;
  border: 0;
  border-radius: 25px;
  padding: 14px;
  background: #008552;
  color: #FFF;
  display: inline-block;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  margin-top: 10px;
  transition: ease all 0.3s;
}
button[type="submit"]:hover {
  opacity: 0.9;
}
.background {
  width: 70%;
  padding: 40px;
  height: 100vh;
  background: linear-gradient(60deg, rgba(158, 189, 19, 0.2), rgba(0, 133, 82, 0.2)), url('images/yit.jpg') center no-repeat;
  background-size: cover;
  display: flex;
  flex-wrap: wrap;
  align-items: flex-end;
  justify-content: flex-end;
  align-content: center;
  flex-direction: row;
}
.background h1 {
	position:absolute;
  color: #FFF;
  text-align: center;
  margin-bottom:34%;
  padding: 0;
  font-size:50px;
}
.background p {
  max-width: 650px;
  color: #1a1a1a;
  font-size: 15px;
  text-align: right;
  padding: 0;
  margin: 15px 0 0 0;
}
.created {
  margin-top: 40px;
  text-align: center;
}
.created p {
  font-size: 13px;
  font-weight: bold;
  color: #008552;
}
.created a {
  color: #666;
  font-weight: normal;
  text-decoration: none;
  margin-top: 0;
}
.checkbox label {
  display: inline;
  margin: 0;
}
.msg{
	padding:5%;
	color:white;
	text-align: center;
	background-color:red;
}
</style>
</head>
<body>
  <div id="login-page">
  <div class="login">
  <%
  	if(request.getAttribute("msg")!=null)
  	{
  %>
  		<p class="msg"><%=request.getAttribute("msg")%></p>
  <%} %>
    <h2 class="login-title"> Admin Login</h2>
    <p class="notice">Please login to access the system</p>
    <form class="form-login" method="post" action="Login">
      <label for="username">User Name</label>
      <div class="input-email">
        <i class="fas fa-envelope icon"></i>
        <input type="text" name="username" placeholder="Enter your username" required>
      </div>
      <label for="password">Password</label>
      <div class="input-password">
        <i class="fas fa-lock icon"></i>
        <input type="password" name="password" placeholder="Enter your password" required>
      </div>
      <button type="submit" name="admin"><i class="fas fa-door-open"></i> Sign in</button>
    </form>
     
  </div>
  <div class="background">
    <h1>YENEPOYA INSTITUTE OF TECHNOLOGY</h1>
  </div>
</div>
  
</body>
</html>