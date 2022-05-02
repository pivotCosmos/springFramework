<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{width: 800px;border:5px green solid;}
  td,th{text-align: center; border: 1px gray solid;}
  a{text-decoration: none;}
</style>

${pageContext.request.contextPath}
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>



</head>
<body>
<table>
<caption>
  <h1>[ Product List Page ]</h1>
</caption>
 <tr>
   <th>번호</th>
   <th>상품코드</th>
   <th>상품이름</th>
   <th>상품가격</th>
   <th>상품설명</th>
   <th>삭제하기</th>
 </tr>
 <c:forEach items="${productList}" var="product" varStatus="state">
 <tr>
 	<td>${state.count}</td>
 	<td>${product.code}</td>
 	<td><a href="${pageContext.request.contextPath}/read.kosta?code=${product.code}">${product.name}</a></td>
 	<td><fmt:formatNumber value="${product.price}"/>원</td>
 	<td>${product.detail}</td>
 	<td><a href="${pageContext.request.contextPath}/del/${product.code}">삭제하기</a></td>
 </tr>
 </c:forEach>
  
  <tr>
    <th colspan="6"><a href="insertForm.kosta">상품등록하기</a></th>
   </tr>
 
</table>


</body>




</html>