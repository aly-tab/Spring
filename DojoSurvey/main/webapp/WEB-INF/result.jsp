<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Survey</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div id="container">
        <div>
            <h1>Submitted Info</h1>

            <table>
                <tr>
                    <td>Name</td>
                    <td><c:out value="${name}"/></td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td><c:out value="${location}"/></td>
                </tr>
                <tr>
                    <td>Favorite Language</td>
                    <td><c:out value="${language}"/></td>
                </tr>
                <tr>
                    <td>Comment</td>
                    <td><div class="formattd"><c:out value="${comment}"/></div></td>
                </tr>
            </table>
        </div>
        <div>
            <form action='/'>
                <input type="submit" value="Go Back" name="submit_button" class="btn">
            </form>
        </div>
    </div>
</body>
</html>