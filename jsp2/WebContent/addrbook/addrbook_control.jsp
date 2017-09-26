<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="jspbook.addrbook.*"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="addrbean" scope="page"
	class="jspbook.addrbook.AddrBean" />
<jsp:useBean id="addrbook" class="jspbook.addrbook.AddrBook" />
<jsp:setProperty name="addrbook" property="*" />

<%
	
	String action = request.getParameter("action");
	if (action.equals("list")) {
		response.sendRedirect("addrbook_list.jsp");
	} else if (action.equals("insert")) {
		if (addrbean.insertDB(addrbook)) {
			response.sendRedirect("addrbook_control.jsp?action=list");
		} else {
			throw new Exception("DB입력 오류");
		}

	} else if (action.equals("edit")) {
		//String id=request.getParameter("ab_id");
		AddrBook abook = addrbean.getDB(addrbook.getAb_id());
		if (!request.getParameter("upasswd").equals("1234")) {
			out.print("<script>alert('비밀번호가 틀렸습니다.'); history.go(-1);</script>");
		} else {
			request.setAttribute("ab", abook);
			pageContext.forward("addrbook_edit_form.jsp");
		}

	} else if (action.equals("update")) {
		if (addrbean.updateDB(addrbook)) {
			response.sendRedirect("addrbook_control.jsp?action=list");
		}
	} else if (action.equals("delete")) {
		if (addrbean.deleteDB(addrbook.getAb_id())) {
			out.print("<script>alert('삭제되었습니다.')</script>");
			pageContext.forward("addrbook_control.jsp?action=list");
		} else {
			throw new Exception("DB갱신 오류");
		}
	} else {
		//test
	}
%>
<jsp:include page="fileTest.jsp"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>