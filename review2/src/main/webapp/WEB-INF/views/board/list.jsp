<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="<%=request.getContextPath()%>" scope="application" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<c:forEach var="b" items="${boards}" varStatus="boardNum">
		#번호: ${b.boardNo}&nbsp;
		#작성자:${b.userId}&nbsp;
		#제목:  <a href="${path}/board/show?boardNo=${b.boardNo}">${b.title}</a>&nbsp;
		<a href="${path}/board/delete?boardNo=${b.boardNo}">삭제</a><br>
	</c:forEach>
	
	<form action="${path}/board/searchList" method="get">
		검색: <input type="text" name="keyword">
		<button>전송</button>
	</form>
	
	
	
</body>
</html>