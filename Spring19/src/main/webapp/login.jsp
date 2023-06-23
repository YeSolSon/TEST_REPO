<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--       
    1. 로그인 버튼을 클릭하면 login.do요청을 서버에 전달
	2. 서블릿컨테이너는 web.xml을 읽고 action이름으로 등록된 Dispatcher클래스 객체생성
	3. action-servlet.xml 스프링 설정파일을 찾아서 로딩
	4. 이때 DispatcherServlet이 사용할 HandlerMapping,Controller,ViewResolver클래스가 bean으로 등록된 객체들을 생성
	5. DispatcherServlet은 객체들 간 상호작용해서 스프링컨테이너가 구동하면서 서비스를 진행한다.
  
  -->   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
td{text-align: center;}
input{border: none;}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
	<div align="center">
	<h1>로 그 인</h1>
	<hr>
	<form action="login.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td bgcolor="lightgray">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td bgcolor="lightgray">패스워드</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	</div>
<%@include file="Footer.jsp" %>
</body>
</html>