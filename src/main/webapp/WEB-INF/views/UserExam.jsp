<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Exam</title>
</head>
<body>
<h2>ABC University</h2>
Exam Title:${userexams.listuserexam[0].ebean.title}
Total Marks:${userexams.listuserexam[0].ebean.tmarks}
<br>
<hr>
<f:form action="submitexam" modelAttribute="userexams" method="post">
<table>
	<c:forEach items="${userexams.listuserexam}" var="exam" varStatus="status">
	<tr>
		<td>Q${status.index+1}</td>
		<input type="hidden" name="listuserexam[${status.index}].qbean.questionId" value="${exam.qbean.questionId}"/>
		<input type="hidden" name="listuserexam[${status.index}].ubean.userId" value="${exam.ubean.userId}"/>
		<input type="hidden" name="listuserexam[${status.index}].ebean.examId" value="${exam.ebean.examId}"/>
		<input type="hidden" name="listuserexam[${status.index}].ebean.ecode" value="${exam.ebean.ecode}"/>
		
		<td>${exam.qbean.que}</td>
	</tr>
	<tr>
		
		<td><input type="radio" name="listuserexam[${status.index}].useranswer" value="op1">${exam.qbean.op1}</td>
		<td><input type="radio" name="listuserexam[${status.index}].useranswer" value="op2">${exam.qbean.op2}</td>
		<td><input type="radio" name="listuserexam[${status.index}].useranswer" value="op3">${exam.qbean.op3}</td>
		<td><input type="radio" name="listuserexam[${status.index}].useranswer" value="op4">${exam.qbean.op4}</td>
	</tr>
	</c:forEach>
	<tr>
		<td><input type="submit" value="SubmitExam"></td>
	</tr>
</table>

</f:form>
</body>
</html>