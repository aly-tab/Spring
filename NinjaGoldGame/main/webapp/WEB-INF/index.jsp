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
			<p><span>Your Gold: </span><span class="count"><c:out value="${count}"/></span></p>
			<div id="row">
				<div class="box">
					<p>Farm</p>
					<p>(earns 10-20 gold)</p>
					<form method='POST' action="/add">
						<input type="hidden" name="num1" value="10">
						<input type="hidden" name="num2" value="20">
						<input type="hidden" name="location" value="farm">
						<button>Find Gold</button>
					</form>
				</div>
				<div class="box">
					<p>Cave</p>
					<p>(earns 5-10 gold)</p>
					<form method='POST' action="/add">
						<input type="hidden" name="num1" value="5">
						<input type="hidden" name="num2" value="10">
						<input type="hidden" name="location" value="cave">
						<button>Find Gold</button>
					</form>
				</div>
				<div class="box">
					<p>House</p>
					<p>(earns 2-5 gold)</p>
					<form method='POST' action="/add">
						<input type="hidden" name="num1" value="2">
						<input type="hidden" name="num2" value="5">
						<input type="hidden" name="location" value="house">
						<button>Find Gold</button>
					</form>
				</div>
				<div class="box">
					<p>House</p>
					<p>(earns 0-50 gold)</p>
					<form method='POST' action="/add">
						<input type="hidden" name="num1" value="0">
						<input type="hidden" name="num2" value="50">
						<input type="hidden" name="location" value="casion">
						<button>Find Gold</button>
					</form>
				</div>
			</div>
			<p>Activities:</p>
			<div class="notifications">
				<c:forEach var="notify" items="${controllerNoifications}">
            		<p><c:out value="${notify}"></c:out></p>
        		</c:forEach>
			</div>
		</div>
	</body>
</html>