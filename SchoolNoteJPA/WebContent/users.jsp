<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en-AU">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<head>
<title>School Note</title>

  <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
  <meta name="author" content="design.awardspace.us" />
  <meta name="description" content="Make Notes." />

<link href="style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<div class="wrapper" style="height: 846px; ">

<div class="header">
<img src="pictures/Logo.png" size="40%" padding="20px" /> <br><br>

</div>

<div class="left" style="height: 690px; ">
<div class="nav">
<ul>
<form name="navigateMenu" action="navigate" method="get">

			<li><a href="success.jsp" id="Home">Write Notes</a></li>
		<li><a href="http://localhost:8080/SchoolNoteJPA/UserProfileServlet?userProfile" id="UserProfile" title="Profile">Profile</a></li>
		<li><a href="http://localhost:8080/SchoolNoteJPA/ReadNotes" id="readData">Notes</a></li>
		<li><a href="http://localhost:8080/SchoolNoteJPA/GetUsersServlet" id="getUser">Users</a></li>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		<br></br>
		
		<li><a href="login.jsp" id="logOut">Logout</a></li>
</form>		
</ul>
</div>

</div>

<div class="right" style="overflow:auto; width: 70%; height:690px;">

<h2>Users on the site</h2>
<p>
</p>
<form action="navigate" method="get">
	  
  		  
  		  
  		  <c:set var="count" value="1"/>
<c:forEach var="item" items="${users}" step="1" begin="0">
 
<c:forEach items="${item.value}" var="itemVar">
 <c:if test="${count==4}">
   <c:set var="count" value="1"/>
 </c:if>

 <div id="col${count}">
   
        <a href="http://localhost:8080/SchoolNoteJPA/OtherUserProfileServlet?userProfile=${itemVar}" id="${itemVar}" name="userProfile"> ${itemVar}  </a>
     		
     	
 </div>
 <c:set var="count" value="${count+1}"/>
  
 	  </c:forEach>
 	
</c:forEach>
  		  
  		  
  		  

</form> </div></body>

</div>

<div class="clear"></div>

</div>

<div class="footer">

<p>Designed by School Note group</a>  |  Copyright 2016 </p>

</div>


</body>
</html>