<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bbs.css">
<title>Insert title here</title>
</head>
<body>
	<%
		String bbs_no=request.getParameter("bbs_no");
	%>
	<form action="bbs_action.jsp">
	<input type="hidden" name="bbs_no" value="<%=bbs_no%>">
	<input type="hidden" name="user_id">
		제목 : <input type="text" name="title" placeholder="제목을 입력하세요"><br><br>
		내용 : <textarea rows="80" cols="80" name="content">
			
		</textarea>
		<input type="file" value="파일 업로드">
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>