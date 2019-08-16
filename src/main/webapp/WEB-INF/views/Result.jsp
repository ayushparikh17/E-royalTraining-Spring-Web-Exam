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
<table border="1" align="center" style=" background-color: #52ccb8;">
<tr><th colspan="3" style="color: #cc3227;">Result</th></tr>
<tr style="color: #c91067">
<th>Exam Code</th>
<th>User Answer</th>
<th>Status</th>
</tr>

<c:forEach items="${userexams.listuserexam}" var="i">
<tr>
<td>${i.ebean.ecode}</td>
<td>${i.useranswer}</td>
<td>${i.status}</td>
</tr>
</c:forEach>

<tr>
<td style="color: #c91067">Result</td>
<td colspan="2" style="color: green"><%=msg %></td>
</tr>
</table>
</body>
</html>