<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="chap11.*"%>
	<%
		Thermomether thermo=new Thermomether();
		request.setAttribute("t",thermo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${t.setCelsius('서울',27.3) }
	서울 온도: 섭씨 ${t.getCelsius('서울') } 도/ 화씨 ${ t.getFahrenheit('서울') }</br>
	
	정보: ${t.getInfo() }
</body>
</html>