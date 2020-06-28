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
	<h1>게시글 수정</h1>
	
	<form method="post">
		#글번호:<input type="hidden" readonly="readonly" name="boardNum" value="${boardNum}"><br>	
		#작성자:<input type="text" readonly="readonly" name="userId" value="${board.userId}"><br>	
		#제목:<input type="text" name="title" value="${board.title}"><br>	
		#내용:<input type="text" name="content" value="${board.content}"><br>	
		<button>전송</button>
	
	</form>	
	
	
	
	
	
</body>
</html>