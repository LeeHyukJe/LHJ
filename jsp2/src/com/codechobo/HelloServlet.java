package com.codechobo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html"); //mime 타입 설정
//		out.println("<!DOCTYPE html");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>");
//		out.println("hello");
//		out.println("</h1>");
//		out.println("</body>");
//		out.println("</html>");
		
		out.print("<input type='text' name='text' placeholder='any press key'> ");
		
		
		out.print("<html>                                                                                                  ");
		out.print("<head>                                                                                                     ");
		out.print("    <meta charset='UTF-8'>                                                                                 ");
		out.print("    <title>MyHompage</title>                                                                               ");
		out.print("    <link rel='stylesheet' href='Hompage.css' type='text/css' media='screen'/>                             ");
		out.print("</head>                                                                                                    ");
		out.print("<body>                                                                                                     ");
		out.print("                                                                                                           ");
		out.print("    <ul>                                                                                                   ");
		out.print("        <li class='home'><a href='HomePage.html'><img src='homeIcon.png' height='48' width='48'/></a></li> ");
		out.print("        <li><a href='addrbook_control.jsp?action=list'>회원리스트</a></li>                                      ");
		out.print("        <li><a href='addrbook_form.jsp'>회원가입</a></li>                                                      ");
		out.print("    </ul>                                                                                                  ");
		out.print("    <hr>                                                                                                   ");
		out.print("    <div class='gate'>                                                                                     ");
		out.print("    	<div class='winner'>                                                                                 ") ;
		out.print("    		The Winner Takes It All                                                                          ") ;
		out.print("    	</div>                                                                                               ") ;
		out.print("    </div>                                                                                                 ");
		out.print("	<div class='gradient1'>Copyright(c)2017 이혁제 All rights reserved. </div>                                  ") ;
        out.print("                                                                                                           ");
		out.print("</body>                                                                                                    ");
		out.print("</html>                                                                                                    ");
	}             
	
}
