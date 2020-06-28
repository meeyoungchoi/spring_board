<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	
	<form action="/review2/board/write" method="post">
		#작성자: <input type="text" name="userId">
		#제목:<input type="text" name="title">
		#내용:<input type="text" name="content">
		<button>제출</button>
	
	</form>
	
	
	
</body>
</html>