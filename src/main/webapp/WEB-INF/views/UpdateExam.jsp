<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Exam Details</title>
</head>
<body>
<h2>Insert Exam Details</h2>
<table>
<f:form action="../updateexam" method="post" commandName="bean">
<tr><td><f:hidden path="examId"/></td></tr>
<tr>
<td>Exam Title: </td>
<td><f:input path="title"/></td>
</tr>
<tr>
<td>Total Marks: </td>
<td><f:input path="tmarks"/></td>
</tr>
<tr>
<td>Exam Duration: </td>
<td><f:input path="duration"/></td>
</tr>
<tr>
<td>Exam Date:</td>
<td><f:input path="edate" type="date"/></td>
</tr>
<tr>
<td>Exam Code: </td>
<td><f:input path="ecode"/></td>
</tr>
<tr>
<td><input type="submit" value="Update"></td>
</tr>
</f:form>

</table>
</body>
</html>