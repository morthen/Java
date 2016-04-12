<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" type="text/css" href="Design.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>
<h1>Register Page</h1>


<form action="RegisterUser" method="GET">

<input type="text" maxlength="35" class="input" name="name" placeholder="Name"/>
<br>
<br/>
<input type="text" maxlength="15" class="input" name="login" placeholder="Username"/>
<br>
<br/>
<input type="password" maxlength="15" class="input" name="password" placeholder="Password"/>
<br>
<br/>	
<input type="submit" class="loginbutton" value="Register" /></form>
</form>
 



<br>
<br>

</body>



</html>