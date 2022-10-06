<%@page import="ddit.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileList.jsp</title>
<%
	// 서블릿에서 보내온 파일 목록 받기
	List<FileInfoVO> fileinfoList = (List<FileInfoVO>)request.getAttribute("fileinfoList");
%>
</head>
<body>
<h2>전체 파일 목록</h2><br><hr><br>

<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>

<table border="1">
	<tr>
		<td>번호</td><td>작성자</td><td>저장 파일명</td><td>기존 파일명</td>
		<td>파일크기</td><td>날짜</td><td>비고</td>
	</tr>
	<%
	if(fileinfoList==null||fileinfoList.size()==0){	
	%>
		<tr>
			<td colspan="7">파일 목록이 하나도 없습니다.</td>
		</tr>
	<%}else{ 
		for(FileInfoVO fileinfoVo : fileinfoList){%>
		<tr>
			<td><%=fileinfoVo.getFile_no() %></td>
			<td><%=fileinfoVo.getFile_writer() %></td>
			<td><%=fileinfoVo.getSave_file_name() %></td>
			<td><%=fileinfoVo.getOrigin_file_name() %></td>
			<td><%=fileinfoVo.getFile_size() %></td>
			<td><%=fileinfoVo.getFile_data() %></td>
			<td>-</td>
		</tr>
	
	<%	}
	}%>

</table>


</body>
</html>