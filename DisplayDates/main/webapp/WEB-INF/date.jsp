<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Display Date</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body onload="alertDate()">
	<div id="container">
		<p class="blue">
    		<c:out value="${day}"/>, the <c:out value="${dayNum}"/> of <c:out value="${month}"/>, <c:out value="${year}"/>
   		</p>
   	</div>
</body>
</html>