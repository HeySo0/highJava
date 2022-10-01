<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
<style>
h2{
	border : 1px solid black;
	border-left: none;
	border-right: none;
	padding : 20px;
}
</style>
<script src="../../js/jquery-3.6.1.min.js"></script>
<script>
$(function(){
	$('#btn1').on('click',function(){
	if(($('#operator option').eq(3).prop('selected')==true)||($('#operator option').eq(4).prop('selected')==true)){
		if($('#num2').val()=='0'){
			alert("0으로 나눌 수 없습니다.");
			return false;
		}
	}		
	})
})
</script>

</head>
<body>
<h2>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h2>
<form action="/webTest/requestTest02.do" method="GET">
	<input type="text" size="10" name="num1">
	<select name="operator" id="operator">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		<option value="%">%</option>
	</select>
	<input type="text" size="10" name="num2" id="num2">
	<input type="submit" value="확인" id="btn1">
</form>

</body>
</html>