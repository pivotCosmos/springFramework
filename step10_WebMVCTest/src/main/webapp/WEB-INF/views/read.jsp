<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상세보기 Page</h3>
<table border="1">
 <tr>
   <th>상품코드</th>
   <td>${product.code}</td>
 </tr>
 <tr>
   <th>상품이름</th>
   <td>${product.name}</td>
 </tr>
 <tr>
   <th>상품가격</th>
   <td><fmt:formatNumber value="${product.price}"/></td>
 </tr>
 <tr>
   <th>상품설명</th>
   <td>${product.detail}</td>
 </tr>
 <tr>
   <th colspan="2">
     <a href="${pageContext.request.contextPath}/index.kosta">홈으로</a>
   </th>
 </tr>
</table>
</body>
</html>