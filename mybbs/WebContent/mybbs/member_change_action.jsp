<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="user.*" %>
    <jsp:useBean id="user" scope="request" class="user.User"/>
    <jsp:useBean id="user_db" scope="request" class="user.User_db"/>
    <jsp:setProperty name="user" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		user_db.update(user);
		response.sendRedirect("member_list.jsp");
	%>
</body>
</html>