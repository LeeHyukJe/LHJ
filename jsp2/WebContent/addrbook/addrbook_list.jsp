<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="addrbook_error.jsp"%>
<%@ page import="java.util.*,jspbook.addrbook.*"%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<jsp:useBean id="list" class="jspbook.addrbook.AddrBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="addrbook.css" type="text/css"
	media="screen" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 목록 화면</title>
<script>
	function check(ab_id) {
		pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
		document.location.href = "addrbook_control.jsp?action=edit&ab_id="
				+ ab_id + "&upasswd=" + pwd;
	}
</script>


</head>
<body>
	<%
		String memberId = (String) session.getAttribute("memberid");
	
		if (memberId==null) {
	%>
	<script>
		//alert("로그인 하세요!!!");
		
	</script>
	<%
		response.sendRedirect("login_form.jsp");
		}
	%>
	<div>
		<a href="index2.jsp" style="display: inline-block;"><img
			src="homeIcon.png" height="48" width="48" /></a>
	</div>
	<div align="center">
		<h2>주소록:목록화면</h2>
		<hr>
		<form>


			<table class="type09">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>name</th>
					<th>email</th>
					<th>학과</th>
					<th>전화번호</th>
					<th>생일</th>
					<th>메모</th>
				</tr>
				<%
					datas = list.getDBList();
					for (AddrBook ab : (ArrayList<AddrBook>) datas) {
				%>
				<tr>
					<!--  <td><a href="javascript:check(<%=ab.getAb_id()%>)"><%=ab.getAb_id()%></a></td>-->
					<td><%=ab.getAb_id()%></td>
					<td><%=ab.getAb_name()%></td>
					<td><%=ab.getAb_email()%></td>
					<td><%=ab.getAb_comdept()%></td>
					<td><%=ab.getAb_tel()%></td>
					<td><%=ab.getAb_birth()%></td>
					<td><%=ab.getAb_memo()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<a style="float: right;" href="addrbook_form.jsp">주소록 등록</a>
		</form>
	</div>
</body>
</html>