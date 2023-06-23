<%@page import="com.mycompany.biz.board.impl.BoardDAO"%>
<%@page import="com.mycompany.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

</style>
</head>
<body>
	<div>
		<h1>글 상세</h1>
		<a href="logout.do">로그아웃</a>
		<hr>
		<form action="updateBoard.do" method="post">
		<c:set var="board" value="${board }"/>
			<input type="hidden" name="seq" value="${board.seq}">
			<table border="1">
				<tr>
					<td bgcolor="lightgray" width="70px">제목</td>
					<td align="left"><input type="text" name="title" value="${board.title}"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray">작성자</td>
					<td align="left"><input type="text" name="writer" value="${board.writer}"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >등록일</td>
					<td align="left">${board.regDate}</td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >조회수</td>
					<td align="left">${board.cnt}</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="글 수정"></td>
				</tr>
			</table>		
		</form>
		<hr>
		<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글 목록</a>
	</div>
</body>
</html>