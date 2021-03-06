package user;

import java.sql.*;
import java.util.ArrayList;

public class User_db {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String jdbc_driver;
	String jdbc_url;
	

	public void connect() {
		if(System.getProperty("user.name").equals("lims2733")) {
			jdbc_driver="com.mysql.jdbc.Driver";
			jdbc_url="jdbc:mysql://127.0.0.1:3306/db";
		}
		else if( System.getProperty("user.name").equals("우리집 컴퓨터")) {
			jdbc_driver="com.mysql.jdbc.Driver";
			jdbc_url="jdbc:mysql://localhost:3306/mybbs";
		}
		else {
			jdbc_driver="oracle.jdbc.driver.OracleDriver";
			System.out.print(System.getProperty("user.name"));
			jdbc_url="jdbc:oracle:thin:@localhost:1521:xe";
		}
		
		try {
			Class.forName(jdbc_driver);
			conn=DriverManager.getConnection(jdbc_url,"root","1234");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void disconnect() {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<User> db_list(){
		connect();
		String sql="select * from mybbs";
		ArrayList<User> list=new ArrayList<>();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				User user=new User();
				user.setUser_id(rs.getString(1));
				user.setUser_password(rs.getInt(2));
				user.setUser_name(rs.getString(3));
				user.setUser_email(rs.getString(4));
				user.setUser_college(rs.getString(5));
				user.setUser_picture(rs.getString(6));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			disconnect();
		}
		return list;
	}
	
	public User getDB(String user_id) {
		connect();
		String sql="select * from mybbs where user_id=?";
		User user=new User();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs=pstmt.executeQuery();
	
			rs.next();
			user.setUser_id(rs.getString(1));
			user.setUser_password(rs.getInt(2));
			user.setUser_name(rs.getString(3));
			user.setUser_email(rs.getString(4));
			user.setUser_college(rs.getString(5));
			user.setUser_picture(rs.getString(6));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return user;
	}
	
	public boolean insert(User user) {
		connect();
		
		String sql="insert into mybbs values(?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setInt(2, user.getUser_password());
			pstmt.setString(3, user.getUser_name());
			pstmt.setString(4, user.getUser_email());
			pstmt.setString(5, user.getUser_college());
			pstmt.setString(6, user.getUser_picture());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
	}
	
	public boolean update(User user) {
		connect();
		
		String sql="update mybbs set user_password=?, user_name=?, user_email=?, user_college=?, user_picture=? where user_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_password());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_email());
			pstmt.setString(4, user.getUser_college());
			pstmt.setString(5, user.getUser_picture());
			pstmt.setString(6, user.getUser_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
	}
	
	public boolean delete(String user_id) {
		connect();
		
		String sql="delete from mybbs where user_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
	}

}
