<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript" src="script/board.js"></script>

<%
	int nowpage = (Integer) (request.getAttribute("page"));
	int start = (Integer) (request.getAttribute("start"));
	int end = (Integer) (request.getAttribute("end"));
%>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 리스트</h1>

		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right;"><a
					href="BoardServlet?command=board_write_form">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<c:forEach var="board" items="${boardList }">
				<tr class="record" align="center">
					<td>${board.num }<!-- num 이란 이름으로 board.num 전달   command = boar_view 
					Factory 에서 BoardViewAction 생성     
					Action action = new BoardViewAction(); 
					return action;
					
					BoardServlet에 돌아와서 action.execute(); 제어권 가지고
					execute(기능수행)-->
					<td><a
						href="BoardServlet?command=board_view&num=${board.num }">${board.title }</a>
					</td>
					<td>${board.name }</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" timeStyle="short" value="${board.writedate }"></fmt:formatDate></td>
					<td>${board.readcount }</td>
				</tr>
			</c:forEach>



			<tr>
				<td colspan="5" align="center">
				
				<a href="BoardServlet?command=board_list&page=1">[맨 앞으로]</a>&nbsp;
				<a href="BoardServlet?command=board_list&page=<%if(nowpage<=1){%>1<%}else{%>${page-1 }<%}%>">[이전]</a>&nbsp;

					<c:forEach var="num" items="${list }" varStatus="index" begin="${start-1 }" end="${end-1 }" >
					<c:choose>
					 	<c:when test="${num eq nowpage}">
							[ <a href="BoardServlet?command=board_list&page=${num}" style="color: green;">${num}</a> ]	
						</c:when>
						<c:otherwise> 
							[ <a href="BoardServlet?command=board_list&page=${num}" >${num}</a> ]	
						</c:otherwise>	 					
					
					</c:choose>
					</c:forEach> 
				<a href="BoardServlet?command=board_list&page=<%if(nowpage>=end){%>${end}<%}else{%>${page+1 }<%}%>">[다음]</a>&nbsp;
				<a href="BoardServlet?command=board_list&page=${maxpage}">[맨 뒤로]</a>&nbsp;
				</td>
			</tr>
		</table>
<%= nowpage %><br>
${start } &nbsp; ${end }

	</div>
</body>
</html>