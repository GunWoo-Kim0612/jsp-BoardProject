<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="warp" align="center">
<h1> 비밀번호 확인 </h1>
<!-- get? -->
<form action="BoardServlet" name="frm" method="get">
	<input type="hidden" name="command" value="board_check_pass">
	<input type="hidden" name="num" value="${param.num }">
	<table style="width: 80%">
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pass" size="20">
			</td>
		</tr>
	</table>	
	<br>
	<input type="submit" value=" 확 인 " onclick="return passCheck()">
	<br><br>${message }
	
</form>
</div>
<script>
frm.pass.focus();
</script>
</body>
</html>