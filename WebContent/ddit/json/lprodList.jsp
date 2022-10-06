<%@page import="ddit.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");
%>

<h2>Lprod 자료 목록</h2>
<table border="1">
	<tr>
		<td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td>
	</tr>
<%for(LprodVO lprodVo : lprodList){ %>
	<tr>
		<td><%=lprodVo.getLprod_id() %></td>
		<td><%=lprodVo.getLprod_gu() %></td>
		<td><%=lprodVo.getLprod_nm() %></td>
	</tr>
<%} %>
</table>

</body>
</html>