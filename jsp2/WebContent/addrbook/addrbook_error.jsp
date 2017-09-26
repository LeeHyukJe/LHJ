<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>에러페이지</title>
</head>
<body>
	<div align="center">
		<h2>주수록 에러</h2>
		<hr>
		<table cellpadding=5 width=400>
			<tr style="bgcolor:pink";><td>
			주수록 처리중 에러가 발생 했습니다.<br>
			관리자에게 문의해주시기 바랍니다.
			죄송합니다....
			<hr>
			에러내용:<%=new Exception() %>
			<hr>
			</td>
			</tr>
		</table>
	</div>
</body>
</html>