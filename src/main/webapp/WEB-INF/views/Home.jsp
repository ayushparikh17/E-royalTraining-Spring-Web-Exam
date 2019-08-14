<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
</head>
<body>

<table>
<f:form action="exam" method="post" commandName="exam">
<tr>
<td>Exam Code:</td>
<td>
<f:input path="ecode"/>
</td>
</tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</f:form>
</table>

</body>
</html>