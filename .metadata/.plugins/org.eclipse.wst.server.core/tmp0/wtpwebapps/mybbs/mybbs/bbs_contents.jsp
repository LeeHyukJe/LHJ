<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="bbs.*" %>
	<%@page import="java.util.*" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bbs.css">
<title>Insert title here</title>
</head>
<body>
	<%	
		Userbbs_db db=new Userbbs_db();
		String bbs_no=request.getParameter("user");
		User user=db.get_db(Integer.parseInt(bbs_no));
		System.out.print(bbs_no);
		//getBbs_no()
		//getUser_id()
		//getUser_data()
	%>
	<h4>번호 : <%=bbs_no %></h4>
	<h4>작성자 : <%=user.getUser_id() %></h4>
	<h4>작성일자 : <%=user.getBbs_date() %></h4>
	<hr>
	<h4>내용 : <%=user.getUser_data() %></h4>
</body>
</html>