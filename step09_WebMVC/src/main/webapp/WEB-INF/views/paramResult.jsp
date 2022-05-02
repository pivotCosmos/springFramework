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

<h1> Member 정보 확인하기 </h1>
\${member} = ${member}
<h3>
 아이디 : ${member.id} <br>
 이름 : ${member.name} <br>
 나이 : ${member.age} <br>
 주소 : ${member.addr} <br>
</h3>

<hr>
<h3> @ModelAttribute("m")를 이용한 경우 </h3>
\${m} = ${m}
<h3>
 아이디 : ${m.id} <br>
 이름 : ${m.name} <br>
 나이 : ${m.age} <br>
 주소 : ${m.addr} <br>
</h3>

<hr>
addr : ${addr} <br>
menus : ${menus} <br>

</body>
</html>