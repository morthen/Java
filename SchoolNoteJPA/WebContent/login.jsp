<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%--     <%@ page errorPage="error.jsp" %>
       <%@ page errorPage="errorPageNotFound.jsp" %> --%>
<link rel="stylesheet" type="text/css" href="Design.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body><center>
<img src="pictures/Logo.png" size="60%" padding="20px" /> <br><br><br> <br></center>
<b>Login Page for School Note</b>

<%-- <%
   // Throw an exception to invoke the error page
   int x = 1;
   if (x == 1)
   {
      throw new RuntimeException("Error condition!!!");
   }
%> --%>
<form action="LoginServlet" method="POST">

<input type="text" class="input" name="username" placeholder="Username"/>
<br>
<br/>
<input type="password" class="input" name="password" placeholder="Password"/>
<br>
<br/>	
<input type="submit" class="loginbutton" value="SIGN IN" /></form>
</form>
 



<br>
<br>
<a href="http://localhost:8080/SchoolNoteJPA/register.jsp"  name="userProfile">Not an member yet? register here</a>
</body>
</body>



</html>