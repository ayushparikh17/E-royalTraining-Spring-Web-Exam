<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<table>
<f:form action="login" commandName="bean" method="post">
<tr>
<f:hidden path="userId"/>
<td>Email: </td>
<td><f:input path="email"/></td>
</tr>
<tr>
<td>Password: </td>
<td><f:password path="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
</f:form>
</table>
</body>
</html>