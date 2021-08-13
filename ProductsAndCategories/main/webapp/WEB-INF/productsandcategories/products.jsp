<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Products and Categories</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
	<body>
		<div id="container">
			<h1><c:out value="${product.name}"/></h1>
			<div id="row">
				<div class="col">
					<h3>Categories</h3>
					<c:forEach items="${inCategories}" var="categories">			
						<p><c:out value="${categories.name}"></c:out></p>
		    		</c:forEach>
				</div>
				<div class="col">
					<form action="/products/add" method="post">
					<p>
						<label>Add Category</label>
						<select name="categoryId">
						<c:forEach items="${outCategories}" var="category">			
							<option value="${category.id}"><c:out value="${category.name}"></c:out></option>
					    </c:forEach>
						</select>
					</p>
					<input type="hidden" value="${product.id}" name="productId"/>
					<input type="submit" value="Add"/>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>