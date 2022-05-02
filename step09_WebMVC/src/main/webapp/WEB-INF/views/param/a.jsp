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

<h1>param/a.do 요청되었습니다.</h1>
<h3>
  메시지 : ${requestScope.message}<br>
  취미 : ${hobbys}<br>
</h3>

<hr>
addr : ${addr} <br>
menus : ${menus} <br>


</body>
</html>