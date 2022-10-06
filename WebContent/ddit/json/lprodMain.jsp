<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LprodList 출력</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#lprodBtn").on('click', function(){
		$.ajax({
			url :"<%=request.getContextPath()%>/lprodListController.do",
			type : "get",
			//data : 없음,
			success : function(res){
				/*
				[
					{"lprod_id" : 1, "lprod_gu" : "P101", "lprod_nm" : "컴퓨터제품"},
					{"lprod_id" : 2, "lprod_gu" : "P103", "lprod_nm" : "자전거제품"}
													:
				]
				*/
				let htmlCode="<table border='1'>";
				htmlCode += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>";
				$.each(res, function(i,v){
					htmlCode += "<tr><td>"+v.lprod_id+"</td><td>"+v.lprod_gu+"</td><td>"+v.lprod_nm+"</td></tr>";
				})
				htmlCode += "</table>";
				
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		});
	});
	
	
	$("#lprodBtn2").on('click', function(){
		location.href = "<%=request.getContextPath()%>/lprodListController2.do"
	});
	
});
</script>

</head>
<body>

	<form>
		<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax-비동기방식)">
		<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Non Ajax-동기방식)">
	</form>
	<hr>
	<h2>Lprod 자료 목록</h2>
	<div id="result"></div>

</body>
</html>