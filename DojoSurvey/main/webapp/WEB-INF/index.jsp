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
        <form method='POST' action="/process">
            <table>
                <tr>
                    <td><label>Name</label></td>
                    <td><input type="text" name="name" class="name"></td>
                </tr>
                <tr>
                    <td><label>Dojo Location:</label></td>
                    <td><select name="location">
                        <option>Dallas</option>
                        <option>Washington D.C.</option>
                        <option>San Jose</option>
                        <option>Chicago</option>
                    </select></td>
                </tr>
                <tr>
                    <td><label>Dojo Location:</label></td>
                    <td><select name="language">
                        <option>Python</option>
                        <option>Java</option>
                        <option>JavaScript</option>
                        <option>Ruby</option>
                        <option>C#</option>
                    </select></td>
                </tr>
            </table>
            <p>Comment (optional)</p>
            <textarea id="comment" name="comment"></textarea>
            <div>
                <input type="submit" value="Button" name="submit_button" class="btn">
            </div>
    	</form>
	</div>
</body>
</html>