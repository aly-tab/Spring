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
			<h1><c:out value="${category.name}"/></h1>
			<div id="row">
				<div class="col">
					<h3>Products</h3>
					<c:forEach items="${inProducts}" var="product">			
						<p><c:out value="${product.name}"></c:out></p>
		    		</c:forEach>
				</div>
				<div class="col">
					<form action="/categories/add" method="post">
						<p>
							<label>Add Product</label>
							<select name="productId">
							<c:forEach items="${outProducts}" var="product">			
								<option value="${product.id}"><c:out value="${product.name}"></c:out></option>
						    </c:forEach>
							</select>
						</p>
						<input type="hidden" value="${category.id}" name="categoryId"/>
						<input type="submit" value="Add"/>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>