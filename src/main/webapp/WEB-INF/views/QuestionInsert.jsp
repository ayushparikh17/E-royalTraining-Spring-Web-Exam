<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Questions</title>
</head>
<body>
<h2>Insert Papers</h2>
<f:form action="insertquestion" method="post" commandName="bean">

<table>
<tr>
<td></td>
<td><f:select path="examId">
	<f:options items="${examlist}" itemLabel="title" itemValue="examId"/>
</f:select>
</td>
</tr>
<tr>
<td>Question Name:</td>
<td><f:input path="qname"/></td>
</tr>
<tr>
<td>Question:</td>
<td><f:input path="que"/></td>
</tr>
<tr>
<td>Option1:</td>
<td><f:input path="op1"/></td>
</tr>
<tr>
<td>Option2:</td>
<td><f:input path="op2"/></td>
</tr>
<tr>
<td>Option3:</td>
<td><f:input path="op3"/></td>
</tr>
<tr>
<td>Option4:</td>
<td><f:input path="op4"/></td>
</tr>
<tr>
<td>Answer:</td>
<td><f:input path="ans"/></td>
</tr>
<tr>
<td><input type="submit" value="Submit"></td>
</tr>
</table>
</f:form>
</body>
</html>