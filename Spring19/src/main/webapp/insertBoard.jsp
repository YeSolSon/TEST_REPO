<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{margin: 50px auto;}
	input {border: none;}
	textarea {border: none;}
</style>
</head>
<body>
	<div>
		<h1>글 등록</h1>
		<a href="logout.do">로그아웃</a>
		<hr>
		<form action="insertBoard.do" method="post">
			<table border="1">
				<tr>
					<td bgcolor="lightgray" width="70px">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray">작성자</td>
					<td align="left"><input type="text" name="writer" size="10"></td>
				</tr>
				<tr>
					<td bgcolor="lightgray" >내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="새글등록"></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="getBoardList.do">글 목록가기</a>
	</div>
</body>
</html>