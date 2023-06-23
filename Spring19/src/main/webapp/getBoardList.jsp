<%@page import="com.mycompany.biz.user.impl.UserDAO"%>
<%@page import="com.mycompany.biz.user.UserVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@page import="com.mycompany.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	th{background-color: lightgray;}
	div{text-align: center;}
	table{margin: 50px auto;}
</style>
</head>
<body>
	<div>
		<h1>글 목록</h1>
		<h3><%=session.getAttribute("name") %>님, 환영합니다...<a href="logout.do">LogOut</a></h3>
		<form action="getBoardList.do" method="post">
			<table border="1">
				<tr>
					<td align="right">
						<select name="search">
							<option value="TITLE">제목
							<option value="CONTENT">내용
						</select>
						<input name="searchKeyword" type="text">&nbsp;
						<input type="submit" value="검색">
					</td>
				</tr>
			</table>
		</form>
		<table border="1" width="700px">
			<tr>
				<th width="100">번호</th>
				<th width="250">제목</th>
				<th width="150">작성자</th>
				<th width="450">내용</th>
				<th width="150">등록일</th>
				<th width="100">조회수</th>
			</tr>

			<c:forEach items="${boardList }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="getBoard.do?seq=${board.seq }">
					${board.title }</a>
				</td>
				<td>${board.writer }</td>
				<td>${board.content }</td>
				<td>${board.regDate }</td>
				<td>${board.cnt}</td>
			</tr>		
			</c:forEach>
		</table><br>
		<a href="insertBoard.jsp">새글등록</a>
	</div>
</body>
</html>