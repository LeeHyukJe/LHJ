/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.20
 * Generated at: 2017-09-26 07:51:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mybbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("user");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      user.User user = null;
      user = (user.User) _jspx_page_context.getAttribute("user", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (user == null){
        user = new user.User();
        _jspx_page_context.setAttribute("user", user, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      user.User_db user_db = null;
      user_db = (user.User_db) _jspx_page_context.getAttribute("user_db", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (user_db == null){
        user_db = new user.User_db();
        _jspx_page_context.setAttribute("user_db", user_db, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

	ArrayList<User> list=user_db.db_list();
	String[] pic_list = new String[list.size()];
	Iterator<User> it = list.iterator();
	for (int i = 0; it.hasNext(); i++) {
		pic_list[i] = it.next().getUser_picture();
	}
	String memberId = (String) session.getAttribute("memberid");
	
	if(memberId!=null){
		User user_pic=user_db.getDB(memberId);
		String user_pic2=user_pic.getUser_picture();
	}
	//git test

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\"\r\n");
      out.write("          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("    <title>MyHome</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        body{\r\n");
      out.write("            font-family:\"Lato\", sans-serif;\r\n");
      out.write("            background-image:url('universe.jpg');\r\n");
      out.write("            background-repeat:no-repeat;\r\n");
      out.write("            background-size:100%;\r\n");
      out.write("            }\r\n");
      out.write("        .myslides{\r\n");
      out.write("            display:none;}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--navBar!-->\r\n");
      out.write("<div class=\"w3-top\">\r\n");
      out.write("    <div class=\"w3-bar w3-black w3-card-2\">\r\n");
      out.write("        <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\r\n");
      out.write("        <a href=\"index.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">HOME</a>\r\n");
      out.write("        ");

        	if(memberId==null){
        
      out.write("\r\n");
      out.write("        <a href=\"login.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">로그인</a>\r\n");
      out.write("        ");

        	}else{
        
      out.write("\r\n");
      out.write("         <a href=\"logout.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">로그아웃</a>\r\n");
      out.write("         ");

        }
         
      out.write("\r\n");
      out.write("        <a href=\"member_list.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">회원 리스트</a>\r\n");
      out.write("        <a href=\"join.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">회원가입</a>\r\n");
      out.write("        <a href=\"bbs_form.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">글쓰기</a>\r\n");
      out.write("        <a href=\"bbs_list.jsp\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">게시판</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\"><i class=\"fa fa-search\"></i></a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Navbar on small screens -->\r\n");
      out.write("<div id=\"navDemo\" class=\"w3-bar-block w3-black w3-hide w3-hide-large w3-hide-medium w3-top\" style=\"margin-top:46px\">\r\n");
      out.write("    ");

    	if(memberId==null){
    
      out.write("\r\n");
      out.write("    <a href=\"login.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">로그인</a>\r\n");
      out.write("    ");

    	}else{
    
      out.write("\r\n");
      out.write("    <a href=\"logout.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">로그아웃</a>\r\n");
      out.write("    ");

    	}
    
      out.write("\r\n");
      out.write("    <a href=\"join.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">회원가입</a>\r\n");
      out.write("    <a href=\"member_list.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">회원리스트</a>\r\n");
      out.write("    <a href=\"bbs_list.jsp\" class=\"w3-bar-item w3-button w3-padding-large\">게시판</a>\r\n");
      out.write("    \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("// Automatic Slideshow - change image every 4 seconds\r\n");
      out.write("var myIndex = 0;\r\n");
      out.write("carousel();\r\n");
      out.write("\r\n");
      out.write("function carousel() {\r\n");
      out.write("    var i;\r\n");
      out.write("    var x = document.getElementsByClassName(\"mySlides\");\r\n");
      out.write("    for (i = 0; i < x.length; i++) {\r\n");
      out.write("       x[i].style.display = \"none\";  \r\n");
      out.write("    }\r\n");
      out.write("    myIndex++;\r\n");
      out.write("    if (myIndex > x.length) {myIndex = 1}    \r\n");
      out.write("    x[myIndex-1].style.display = \"block\";  \r\n");
      out.write("    setTimeout(carousel, 4000);    \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// Used to toggle the menu on small screens when clicking on the menu button\r\n");
      out.write("function myFunction() {\r\n");
      out.write("    var x = document.getElementById(\"navDemo\");\r\n");
      out.write("    if (x.className.indexOf(\"w3-show\") == -1) {\r\n");
      out.write("        x.className += \" w3-show\";\r\n");
      out.write("    } else { \r\n");
      out.write("        x.className = x.className.replace(\" w3-show\", \"\");\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// When the user clicks anywhere outside of the modal, close it\r\n");
      out.write("var modal = document.getElementById('ticketModal');\r\n");
      out.write("window.onclick = function(event) {\r\n");
      out.write("  if (event.target == modal) {\r\n");
      out.write("    modal.style.display = \"none\";\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
