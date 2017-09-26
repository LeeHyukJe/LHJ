<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="jspbook.addrbook.*"%>
<jsp:useBean id="addrbean" scope="page"
	class="jspbook.addrbook.AddrBean" />
<jsp:useBean id="addrbook" scope="page"
	class="jspbook.addrbook.AddrBook" />
<jsp:setProperty name="addrbook" property="ab_picture" />
<!-- 생성자 역할 -->

<%
	try {
		request.setCharacterEncoding("UTF-8");
		String savePath = application.getRealPath("/upload/");
		String saveDir = "C://Program Files//Apache Software Foundation//Tomcat 8.5//webapps//ROOT//upload";
		int maxSize = 1024 * 1024 * 100;
		String enctype = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, enctype,
				new DefaultFileRenamePolicy());

		out.println("파일 업로드명" + multi.getFilesystemName("ab_picture") + "<br>");
		out.println("원래 파일명" + multi.getOriginalFileName("ab_picture") + "<br>");
		File file=multi.getFile("ab_picture");
		//String db_pic = multi.getOriginalFileName("ab_picture");
		
		addrbook.setAb_picture(file.getPath());
		addrbean.insertDB(addrbook);

		//System.out.print(application.getRealPath(addrbook.getAb_picture()));
		//File file=multi.getFile("ab_picture");

		//application.setAttribute("path", file.getPath());

	} catch (Exception e) {
		System.out.print(e);
	}

	//ArrayList<AddrBook> pic_list = addrbean.getDBList();
	//String[] f_names = new String[pic_list.size()];
	//File files[] = new File[pic_list.size()];
	//for (int i = 0; i < pic_list.size(); i++) {
	//	f_names[i] = pic_list.get(i).getAb_picture();
	//	if (f_names[i] == null)
	//		continue;
	//	files[i] = new File(f_names[i]);
	//	application.setAttribute(i + "", files[i].getPath().toString());
	//}
	
	//response.sendRedirect("index.jsp");
%>
