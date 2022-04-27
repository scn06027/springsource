<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
	<div>
	<%--이름을 지정하지 않았을땐 어케함? --%>
		<!--  만약 NumDTO에 값이 담겨져 있다면 불러와라 ㅇㅇ 없음 안불러옴 --> 
<%-- 		<input type="text" name="num1" id="num1" size="5" value="${numDTO.num1}"/>+ 
		<input type="text" name="num2" id="num2" size="5" value="${numDTO.num2}"/>= --%>
		<input type="text" name="num1" id="num1" size="5" value="${dto.num1}"/>+ 
		<input type="text" name="num2" id="num2" size="5" value="${dto.num2}"/>=
		<input type="text" name="result" id="result" size="5" value="${result}"/>
		<button type="submit">전송</button>
	</div>
</form>
</body>
</html>