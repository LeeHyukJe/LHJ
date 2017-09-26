package mvc_parctice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBCPInitListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ServletContext context=sce.getServletContext();
			String driver=context.getInitParameter("jdbcdriver");
			Class.forName(driver);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			System.out.println("데이터베이스 드라이버 연결해제");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
