<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en-AU">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<head>
<title>School Note</title>

<meta http-equiv="content-type"
	content="application/xhtml+xml; charset=UTF-8" />
<meta name="author" content="design.awardspace.us" />
<meta name="description" content="Make Notes." />

<link href="style.css" rel="stylesheet" type="text/css" />
<style type="text/css">a {text-decoration: none}</style>
</head>

<body>
	<div class="wrapper" style="height: 846px;">

		<div class="header">
			<h1>
				<u>School Note</u>
			</h1>
		</div>

		<div class="left" style="height: 690px;">
			<div class="nav">
				<ul>
					<form name="navigateMenu" action="navigate" method="get">

						<li><a href="success.jsp" id="Home">Write Notes</a></li>
						<li><a
							href="http://localhost:8080/SchoolNoteJPA/UserProfileServlet?userProfile"
							id="UserProfile" title="Profile">Profile</a></li>
						<li><a href="http://localhost:8080/SchoolNoteJPA/ReadData"
							id="readData">Notes</a></li>
						<li><a
							href="http://localhost:8080/SchoolNoteJPA/GetUsersServlet"
							id="getUser">Users</a></li>
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
		<div class="right" style="overflow: auto; width: 70%; height: 690px;">
			<h2>Read Notes</h2>
			<p></p>
			<center> <c:if test="${ empty listNoteObject}">
			Currently no notes</c:if> </center>
			
		<%-- 	<c:forEach items="${listNoteObject}" var="item">

				<c:set var="subString" value="${fn:substring(item.note, 0, 40)}" />
				<a
					href="http://localhost:8080/SchoolNoteJPA/UserNotesServlet?userNotes=${item.id}"
					id="${item.id}" name="userNotes">Note:</a> ${subString}      <a
					href="http://localhost:8080/SchoolNoteJPA/DeleteUserNotesServlet?userNotes=${item.id}"
					id="${item.id}" name="deleteUserNotes"> Delete Note</a>
				<br>
			</c:forEach>

			</form>
		</div>
</body> --%>



<left>
<c:forEach items="${listNoteObject}" var="item">

			
			<c:set var="subString" value="${fn:substring(item.note, 0, 35)}" />
				<div class="lefty">
				<a
					href="http://localhost:8080/SchoolNoteJPA/UserNotesServlet?userNotes=${item.id}"
					id="${item.id}" name="userNotes">Note:</a> ${subString}</div>     </a></left>
					<p id="delete">
					 
					<a
					href="http://localhost:8080/SchoolNoteJPA/DeleteUserNotesServlet?userNotes=${item.id}"
					id="${itemVar}" name="deleteUserNotes"><font color="red">  Delete Note</font></a></p>
			</c:forEach>

		

</form> </div></body>


</div>

<div class="clear"></div>

</div>

<div class="footer">

	<p>
		designed by School Note group</a> | Copyright 2016
	</p>

</div>


</body>
</html>