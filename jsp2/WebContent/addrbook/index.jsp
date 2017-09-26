<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jspbook.addrbook.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="addrbook" scope="page"
	class="jspbook.addrbook.AddrBook" />
<jsp:useBean id="addrbean" scope="page"
	class="jspbook.addrbook.AddrBean" />
<%
	ArrayList<AddrBook> list = addrbean.getDBList();
	String[] pic_list = new String[list.size()];
	Iterator<AddrBook> it = list.iterator();
	for (int i = 0; it.hasNext(); i++) {
		pic_list[i] = it.next().getAb_picture();
	}
	String memberId = (String) session.getAttribute("memberid");
	
	AddrBook user_pic=addrbean.getDB(memberId);
	String user_pic2=user_pic.getAb_picture();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www`.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>MyHompage</title>
<link rel="stylesheet" href="Hompage.css" type="text/css" media="screen" />
</head>
<style>
.img {
	width: 100%;
}
</style>
<body>


	<ul>
		<li class="home"><a href="index.jsp"><img src="homeIcon.png"
				height="48" width="48" /></a></li>
		<%
			if (memberId != null) {
		%>
		<li><a href="logout.jsp">로그아웃</a></li>
		<%
			} else {
		%>
		<li><a href="login_form.html">로그인</a></li>
		<%
			}
		%>
		<li><a href="addrbook_control.jsp?action=list">회원리스트</a></li>
		<li><a href="addrbook_form.jsp">회원가입</a></li>

	</ul>
	<hr>
	<div class="gate">
		<div class="winner">The Winner Takes It All</div>
	</div>
	<div>

		<div class="main_container">
			<div class="picture">
				<%
					try {
						
						if (list != null) {
							if (memberId!=null) {
							out.print("다른 사용자님들의 프로필 사진입니다.");
								for (int i = 0; i < pic_list[i].length(); i++) {
				%>
				<img src="<%=pic_list[i]%>">

				<%
								}
							}
						}
					} catch (Exception e) {
						System.out.print(e);
					}
				%>
				<%
					if(user_pic.getAb_picture()!=null){
						out.print(user_pic.getAb_name()+"님이 올리신 프로필 사진입니다.");
				%>
				
				<img src="<%=user_pic.getAb_picture() %>">
				<%
					}
				%>
			</div>
		</div>
	</div>
	<!-- <div class="gradient1">Copyright(c)2017 이혁제 All rights reserved.
	</div>
	<!-->

</body>
</html>