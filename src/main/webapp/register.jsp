<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>

<style type="text/css">
html {
  height: 130%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(#141e30, #243b55);
}

.login-box {
	margin-top:100px;
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background:white;
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}
.login-box h4 {
	margin: 0 0 30px;
  padding: 0;
  color: red;
  text-align: center;
}
.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  color: black;
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
#email{
	color: #fff;
	color: black;
  text-align: center;
}
#forgot{
	position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: black;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 10px;
  letter-spacing: 4px;
  margin-left:30%;
}
#forgot span{
	position: absolute;
  display: block;
}
#forgot:hover{
	background: grey;
  color: blue;
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
</style>
<script type="text/javascript">
	function checkPasswordAndPhone(){
		var value=document.forms["checkingInput"]["phone"].value;
		var pwd=document.forms["checkingInput"]["pwd"].value;
		var password=document.forms["checkingInput"]["password"].value;
		var squestion=document.forms["checkingInput"]["squestion"].value;
		var dept=document.forms["checkingInput"]["dept"].value;
		var choose="choose";
		if(isNaN(value))
		{
			alert("Please Provide a proper phone number");
			return false;
		}
		if(value.length>13)
		{
			alert("maximum phone number length should be less than 13");
			return false;
		}
		if(!(pwd===password))
		{
			alert("Passwords are not matching");
			return false;
		}
		if(squestion===choose)
		{
			alert("Please select a security question");
			return false;
		}
		if(dept===choose)
		{
			alert("Please select a department");
			return false;
		}
	}
</script>
</head>
<body>
	<div class="login-box">
	<h4><% if(request.getAttribute("msg")!=null) out.println(request.getAttribute("msg")); %></h4>
  <h2>Register</h2>
  <form method="post" name="checkingInput" action="Login" onsubmit="return checkPasswordAndPhone()">
    <div class="user-box">
      <input type="text" name="usn" required>
      <label>USN</label>
    </div>
    <div class="user-box">
      <input type="text" name="name" required>
      <label>Name</label>
    </div>
	<div class="user-box">
      <input type="email" name="email" required>
      <label>Email</label>
    </div>
    <div class="user-box">
      <input type="text" name="phone" required>
      <label>Phone</label>
    </div>
    <div class="user-box">
      <select name="dept">
		<option>choose</option>
		<option value=cse>CSE</option>
		<option value=ise>ISE</option>
		<option value=ece>ECE</option>
		<option value=eee>EEE</option>
		<option value=me>ME</option>
	</select>
            <label>Department</label>
    </div>
    <div class="user-box">
      <input type="number" name="cgpa" min=0 max=10 required>
      <label>CGPA</label>
    </div>
    <div class="user-box">
      <input type="password" name="password" required>
      <label>Password</label>
    </div>
    <div class="user-box">
      <input type="password" name="pwd" required>
      <label>Confirm Password</label>
    </div>
    <div class="user-box">
      <select name="squestion">
		<option>choose</option>
		<option value=pet>what is your favorite pet name?</option>
		<option value=book>what is your favorite book?</option>
		<option value=place>what is your favorite place?</option>
		<option value="food">what is your favorite food?</option>
		<option value="mobile brand">what is your favorite mobile brand?</option>
	</select>
      <label>Security Question</label>
    </div>
    <div class="user-box">
      <input type="text" name="sanswer" required>
      <label>Security Answer</label>
    </div>
    <input id=forgot type="submit" name=register value="register">
  </form>
</div>
</body>
</html>