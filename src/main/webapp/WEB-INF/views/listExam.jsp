<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam List</title>
</head>
<body>
<table border=1>
<tr>
<td>ExamId</td>
<td>Exam_Title</td>
<td>Exam_Date</td>
<td>Exam_Duration</td>
<td>Total_Marks</td>
<td>Exam_Code</td>
<td>Action</td>
</tr>
<c:forEach items="${list}" var="i">
<tr>
<td>${i.examId}</td>
<td>${i.title}</td>
<td>${i.edate}</td>
<td>${i.duration}</td>
<td>${i.tmarks}</td>
<td>${i.ecode}</td>
<td><a href="editexam/${i.examId}">Edit</a>|<a href="deleteexam/${i.examId}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>