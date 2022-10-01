<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>forward, sendRedirect 연습</h3><hr>

<!-- <form method="post" action="/webTest/responseTest01.do"> -->
<form method="post" action="<%=request.getContextPath() %>/responseTest01.do">
forward 연습용 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>

<hr>

<!-- <form method="post" action="/webTest/responseTest02.do"> -->
<form method="post" action="<%=request.getContextPath() %>/responseTest02.do">
sendRedirect 연습용 : <input type="text" name="username">
	<input type="submit" value="확인">
</form>

</body>
</html>