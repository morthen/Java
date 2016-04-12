<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="Design.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    <button onclick="history.back()" class="loginbutton">Back to Previous Page</button>
    <h1>Something bad happened. Ops. </h1>
    <br />
    <p><b>Error code:</b> ${pageContext.errorData.statusCode}</p>
    <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
    <br />
    
    <td><b>Stack trace:</b></td>
<td>
<center>
<div style="font-size: 70%; background: white; color: #00b8fd; width: 540px; height: 80px; overflow: auto; padding: 5px">
      <c:forEach var="trace" 
         items="${pageContext.exception.stackTrace}">
<p>${trace}</p>
</c:forEach>
   </div></center>

</td>
</body>
</html>