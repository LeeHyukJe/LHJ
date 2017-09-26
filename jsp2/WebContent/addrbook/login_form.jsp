<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%
	Cookie[] cookies = request.getCookies();

	String id_cookie = "";

	if (cookies != null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("JSESSIONID")) {
				id_cookie = "";
			} else {
				id_cookie = cookies[i].getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<form action="login.jsp">
		<input name="ab_id" type="text"
			value="<%=id_cookie%>" placeholder="id입력">
		<input name="ab_password" type="password" placeholder="pwd입력">
		<input type="checkbox" name="is_store" value="Remember ME!!!!" checked>
		<button>Login</button>

	</form>

</body>
</html>