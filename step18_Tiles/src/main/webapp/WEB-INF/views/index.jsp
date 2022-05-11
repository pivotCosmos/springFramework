<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> Spring Tiles TEST </h1>
	
	<h3>
		<a href="${pageContext.request.contextPath}/test1">board/list.jsp이동</a> <p>
		<a href="${pageContext.request.contextPath}/test2">board/read.jsp이동</a> <p>
		
		<a href="${pageContext.request.contextPath}/test3">board/join.jsp이동</a> <p>
		<a href="${pageContext.request.contextPath}/test4">board/login.jsp이동</a> <p>
		
		<a href="${pageContext.request.contextPath}/test5">board/test.jsp이동</a> <p>
		
		<a href="${pageContext.request.contextPath}/test6">board/qa/list.jsp이동</a> <p>
		<a href="${pageContext.request.contextPath}/test7">board/free/write.jsp이동</a> <p>
	</h3>
	
	
</body>
</html>