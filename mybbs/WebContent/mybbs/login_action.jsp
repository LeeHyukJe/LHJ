<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.*"%>
<jsp:useBean id="user" scope="request" class="user.User" />
<jsp:useBean id="user_db" scope="request" class="user.User_db" />
<jsp:setProperty name="user" property="*" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String target=request.getParameter("target");
		String user_id = request.getParameter("user_id");
		String is_store = request.getParameter("is_store");
		ArrayList<User> list = user_db.db_list();
		
		if(target.equals("null")){
			target="index.jsp";
		}
		
		for (int i = 0; i < list.size(); i++) {
			if (user_id.equals(list.get(i).getUser_id())) {
				session.setAttribute("memberid", user_id);
				if (is_store == null) {
					Cookie cookies[] = request.getCookies();
					if (cookies != null && cookies.length > 0) {
						for (int j = 0; j < cookies.length; j++) {
							if (cookies[j].getName().equals("memberid")) {
								cookies[j].setMaxAge(0);
								response.addCookie(cookies[j]);
							}
						}
					}
				} else {
					Cookie cookie = new Cookie("memberid", user_id);
					cookie.setMaxAge(60*60);
					response.addCookie(cookie);
				}
				response.sendRedirect(target);
			}

		}
		%>
			<script>
				alert("회원정보가 일치 하지 않습니다. 다시 확인하여 주시기 바랍니다.");
				history.go(-1);
			</script>
</body>
</html>