<%@page import="ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
div{
	border : 1px solid red;
	width : 300px;
	margin : auto;
	padding : 0px 20px 20px;
}
</style>

</head>
<body>
<%MemberVO loginMember = (MemberVO)session.getAttribute("loginMember"); %>
<%if(loginMember!=null) {%>
	<div>
		<h3><%=loginMember.getMem_name() %>님 반갑습니다.</h3> 
		<a href="<%=request.getContextPath()%>/dbsessionLogout.do">로그아웃</a>
	</div>
<%}else {%>
	<form action="<%=request.getContextPath()%>/dbsessionLogin.do" method="post">
		<table border="1" style="margin : 0 auto;">
		<tr>
			<td>ID :</td>
			<td><input type="text" name="id" value="" placeholder="ID를 입력하세요"></td>
		</tr>
		<tr>
			<td>PASS :</td>
			<td><input type="text" name="pass" value="" placeholder="PASSWORD를 입력하세요"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center;"><input type="submit" value="Login"></td>
		</tr>
		</table>
	</form>
<%} %>

</body>
</html>