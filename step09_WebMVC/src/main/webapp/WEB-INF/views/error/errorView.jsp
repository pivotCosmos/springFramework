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

	<h3>
		예외클래스 : ${errClass}<p>
		예외메시지 : ${errMsg}
	</h3>

	<a href="${pageContext.request.contextPath}/ex05_exception.html">폼으로 이동</a>

</body>
</html>