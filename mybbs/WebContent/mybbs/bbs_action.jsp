<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bbs.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String bbs_no = request.getParameter("bbs_no");
		String delete=request.getParameter("delete");
		User user = new User();
		user.setUser_id(session.getAttribute("memberid").toString()); //user_id
		user.setBbs_title(title); //bbs_title
		user.setUser_data(content); //user_data
		Userbbs_db bbs_db = new Userbbs_db();
		if (bbs_no.equals("null")) { //게시판 글쓰기로 들어오면
			bbs_db.insert(user);
		} 
		else { //수정으로 넘어오면
			user.setBbs_no(Integer.parseInt(bbs_no));
			bbs_db.update(user);
		}
		response.sendRedirect("bbs_list.jsp");
	%>
</body>
</html>