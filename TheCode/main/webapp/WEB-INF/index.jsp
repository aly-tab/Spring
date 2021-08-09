<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>The Code</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<p class="red">${error}</p>
		<form method="POST" action="/check">
			<p>What is the code?"</p>
			<input type="text" name="code"/>
			<div>
				<button>Submit</button>
			</div>
		</form>
	</div>
</body>
</html>