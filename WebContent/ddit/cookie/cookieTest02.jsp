<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
div{
	width:400px;
	height: 200px;
	padding:20px;
}
</style>

</head>
<body>
<div>
	<a href="<%=request.getContextPath() %>/cookieCountServlet.do">Cookie Count 증가 하기</a>
	<a href="<%=request.getContextPath() %>/cookieCountDelServlet.do">Cookie Count 초기화 하기</a>
</div>
</body>
</html>