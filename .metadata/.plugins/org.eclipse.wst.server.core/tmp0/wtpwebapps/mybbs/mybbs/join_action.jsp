<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="user.*"%>
<jsp:useBean id="user" scope="request" class="user.User" />
<jsp:useBean id="user_db" scope="request" class="user.User_db" />
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if (user_db.insert(user)) {
			%>
			<script>
				alert("정상적으로 등록되었습니다.")
			</script>
			<%
			response.sendRedirect("index.jsp");
		}else{
	%>
		<script>
			alert("데이터 베이스에 오류가 발생하였습니다.");
			history.go(-1);
		</script>
		<%
		}
		%>
</body>
</html>