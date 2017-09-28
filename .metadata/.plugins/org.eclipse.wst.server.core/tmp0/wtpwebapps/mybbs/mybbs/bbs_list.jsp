<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="bbs.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="bbs.css">
<title>Insert title here</title>
<script>
	function bbs_view(){
		var tr=document.createElement("tr");
		
		tr.innerHTML=document.getElementById("view_td").innerHTML;
		document.getElementById("stick_td").appendChild(tr);
	}
</script>
</head>
<body>
	<h1 align="center">게시판!</h1>
	<hr>
	<a href="index.jsp">홈으로 가기</a>
	<table class="type10">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody id="stick_td">
			<%
				Userbbs_db bbs = new Userbbs_db();
				ArrayList<User> list = bbs.bbs_list();

				String is_login = (String) session.getAttribute("memberid");
				if (is_login != null) {
					if (list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
			%>
			<tr id="view_td">
				<th scope="row"><a
					href="bbs_form.jsp?bbs_no=<%=list.get(i).getBbs_no()%>"><%=list.get(i).getBbs_no()%></a></th>
				<td><a href="bbs_contents.jsp?user=<%=list.get(i).getBbs_no()%>"><%=list.get(i).getBbs_title()%></a></td>
				<td><%=list.get(i).getUser_id()%></td>
				<td><%=list.get(i).getBbs_date()%></td>
			</tr>
			<%
					
				}
					}
				}else{
				
				%>
					<script>
						alert("로그인을 해야 볼 수 있다구!!^오^");
						history.go(-1);
					</script>
				<%
				}
			%>
		</tbody>
	</table>
	<a href="bbs_form.jsp">글쓰기</a>
</body>
</html>