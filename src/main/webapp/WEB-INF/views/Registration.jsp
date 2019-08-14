<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User SignUp</title>
</head>
<body>
<h2>Register Here</h2>
<table>
<f:form action="insertuser" method="post" commandName="bean">
<tr>
<td>FirstName:</td>
<td><f:input path="firstName"/></td>
</tr>
<tr>
<td>LastName:</td>
<td><f:input path="lastName"/></td>
</tr>
<tr>
<td>Email:</td>
<td><f:input path="email"/></td>
</tr>
<tr>
<td>Password:</td>
<td><f:password path="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</f:form>
</table>
</body>
</html>