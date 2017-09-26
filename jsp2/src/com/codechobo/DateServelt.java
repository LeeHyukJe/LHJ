package com.codechobo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/date")
public class DateServelt extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		out.print(new Date());
		
		String dice[]=new String[6];
		dice[0]="<img src='images/dice1.jpg'>";
		dice[1]="<img src='images/dice2.jpg'>";
		dice[2]="<img src='images/dice3.jpg'>";
		dice[3]="<img src='images/dice4.jpg'>";
		dice[4]="<img src='images/dice5.jpg'>";
		dice[5]="<img src='images/dice6.jpg'>";
		
		for(int i=0;i<dice.length;i++){
			int random=(int)(Math.random()*dice.length);
			out.print(dice[random]);
		}
		
	}
}
