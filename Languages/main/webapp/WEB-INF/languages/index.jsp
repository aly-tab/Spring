<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
	<body>
		<table>
			<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
				<tr>
					<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.currentVersion}"/></td>
					<td><a href="/languages/${language.id}/edit">edit</a> <a href="/languages/${language.id}/delete">delete</a></td>
				</tr>
		        </c:forEach>
			</tbody>
		</table>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
		<form:form action="/languages" method="post" modelAttribute="language">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:textarea path="creator"/>
		    </p>
		    <p>
		        <form:label path="currentVersion">Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </p> 
		    <input type="submit" value="Submit"/>
		</form:form> 
	</body>
</html>