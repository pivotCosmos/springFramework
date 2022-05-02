<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{width: 500px; height:200px; border: 1px solid black; border-collapse: collapse;}
	td,th{border: 1px solid black; text-align: center;}
</style>
</head>
<body>

<h1> MemberList 등록 완료 </h1>
\${memberListDTO.list} = ${memberListDTO.list}<p>
<table>
	<tr>
		<th>이름</th><th>나이</th><th>주소</th>
	</tr>
	<c:forEach items="${memberListDTO.list}" var="m">
		<tr>
			<td>${m.name}</td>
			<td>${m.age}</td>
			<td>${m.addr}</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>