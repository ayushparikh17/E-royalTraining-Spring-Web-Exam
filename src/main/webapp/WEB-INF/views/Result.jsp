<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<%
HttpSession s=request.getSession();
String msg=(String)s.getAttribute("msg");

%>
<table border="1">
<tr>
<th>User Answer</th>
<th>Status</th>
</tr>

<c:forEach items="${userexams.listuserexam}" var="i">
<tr>
<td>${i.useranswer}</td>
<td>${i.status}</td>
</tr>
</c:forEach>

<tr>
<td>Result</td>
<td><%=msg %></td>
</tr>
</table>
</body>
</html>