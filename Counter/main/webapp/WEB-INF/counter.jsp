<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Counter</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
	<body>
		<div id="container">
			<p>You have visited <a href="/">http://localhost:8080/</a> <c:out value="${countToShow}"/> times</p>
			<p><a href="/">Test another visit?</a></p>
		</div>
	</body>
</html>