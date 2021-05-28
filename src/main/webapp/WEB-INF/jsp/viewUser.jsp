<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User Data</title>
</head>
<body>

<table>
<tr> <td>UserName </td> <td> Password </td> <td> FirstName</td> <td> LastName</td> </tr>

<c:forEach var="user" items="${list}"> 
    <tr>
    <td>${user.username}</td>
    <td>${user.password}</td>
    <td>${user.firstname}</td>
    <td>${user.lastname}</td>   
    </tr>
    </c:forEach>

</table>

</body>
</html>