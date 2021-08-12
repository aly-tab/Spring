<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
</head>
<body>
	<form:form action="/ninjas" method="post" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Dojos</form:label>
			<form:select path="dojo">
			<c:forEach items="${dojos}" var="dojo">			
				<form:option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></form:option>
		    </c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">First Name</form:label>
		    <form:errors path="firstName"/>
		    <form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
		    <form:errors path="lastName"/>
		    <form:textarea path="lastName"/>
		</p>
		<p>
			<form:label path="age">Age</form:label>
		    <form:errors path="age"/>
		    <form:input path="age"/>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>