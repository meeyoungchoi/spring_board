<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="path" value="<%=request.getContextPath() %>" scope="application"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 개별 조회</h1>
	
	#번호: ${boardNum}<br>
	#작성자: ${board.userId}<br>
	#제목: ${board.title}<br>
	#내용: ${board.content}<br>

	<a href="${path}/board/modify?boardNum=${boardNum}">수정하기</a>
	
	
	
	
</body>
</html>