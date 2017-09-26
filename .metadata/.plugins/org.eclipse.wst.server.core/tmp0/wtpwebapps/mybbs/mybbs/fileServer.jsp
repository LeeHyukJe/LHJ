<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String savePath=application.getRealPath("//upload");
		String saveDir = "C:Program Files//Apache Software Foundation//Tomcat 8.5//webapps//ROOT//upload";
		int maxSize = 1024 * 1024 * 100;
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, enctype,
				new DefaultFileRenamePolicy());
	%>
</body>
</html>