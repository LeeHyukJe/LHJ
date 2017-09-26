<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="jspbook.addrbook.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URLEncoder"%>
<jsp:useBean id="addrbean" scope="page"
	class="jspbook.addrbook.AddrBean" />
<jsp:useBean id="addrbook" scope="page"
	class="jspbook.addrbook.AddrBook" />
<jsp:setProperty name="addrbook" property="*" />
<%
	
		ArrayList<AddrBook> id_list = addrbean.getDBList();
		Iterator<AddrBook> it = id_list.iterator();
		String id = request.getParameter("ab_id");
		String password = request.getParameter("ab_pasword");
		String is_store = request.getParameter("is_store");
		while (it.hasNext()) {
			if ((it.next().getAb_id()).equals(id)) {
				session.setAttribute("memberid", id);
				session.setMaxInactiveInterval(60 * 60);

				//쿠기 설정
				if(is_store==null){
					//cookie = new Cookie("memeberid","");
					//cookie.setMaxAge(0);
					//response.addCookie(cookie);
					Cookie[] cookies=request.getCookies();
					if(cookies!=null && cookies.length>0){
						for(int i=0;i<cookies.length;i++){
							if(cookies[i].getName().equals("memberid")){
								Cookie cookie=new Cookie("memberid","");
								cookie.setMaxAge(0);
								response.addCookie(cookie);
							}
						}
					}
					
				}
				else if (is_store.equals("Remember ME!!!!")) {
					Cookie cookie = new Cookie("memberid", "lims2733");
					cookie.setMaxAge(600);
					response.addCookie(cookie);
				}
				
				response.sendRedirect("index2.jsp");
				//response.sendRedirect("addrbook_list.jsp");
				break;
			}
		}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<script>
		alert("아이디와 패스워드를 다시 입력하십시오.");
		//history.go(-1);
	</script>
</body>
</html>