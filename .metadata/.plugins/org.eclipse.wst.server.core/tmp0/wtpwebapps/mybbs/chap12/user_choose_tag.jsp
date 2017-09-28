<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<c:choose>
			<c:when test="${param.name=='bk' }">
				<li>당신의 이름은 ${param.name }입니다.</li>
			</c:when>
			<c:when test="${param.age>20 }">
				<li>당신은 성인입니다.
			</c:when>
			<c:otherwise>
				<li> 당신은 항상 옳군요!
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>