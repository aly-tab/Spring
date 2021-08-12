<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
</head>
<body>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<form:form action="/dojos" method="post" modelAttribute="dojo">
		<p>
			<form:label path="name">Dojo</form:label>
		    <form:errors path="name"/>
		    <form:input path="name"/>
		</p>

		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>