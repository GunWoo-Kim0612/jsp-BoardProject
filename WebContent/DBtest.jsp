<%@page import="com.board.dao.BoardDAO"%>
<%@page import="com.board.util.DBmanager"%>
<%@page import="java.sql.Connection"%>
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
	Connection conn = DBmanager.getConnection();
	//싱큰톤 호출
	BoardDAO mDao = BoardDAO.getInstance();
	out.println("연결");
%>
</body>
</html>