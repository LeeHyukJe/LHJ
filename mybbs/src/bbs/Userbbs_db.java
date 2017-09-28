package bbs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Userbbs_db {
	Connection conn;
	PreparedStatement pstmt;
	
	ResultSet rs;
	String jdbc_driver;
	String jdbc_url;
	

	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
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
	
	public ArrayList<User> bbs_list(){
		connect();
		String sql="select * from bbs";
		ArrayList<User> list=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				User user=new User();
				user.setBbs_no(rs.getInt(1));
				user.setUser_id(rs.getString(2));
				user.setBbs_title(rs.getString(3));
				user.setUser_data(rs.getString(4));
				user.setBbs_date(rs.getString(5));
				list.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	public User get_db(int bbs_no) {
		connect();
		String sql="select * from bbs where bbs_no=?";
		User user=new User();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bbs_no);
			rs=pstmt.executeQuery();
			
			rs.next();
			user.setUser_id(rs.getString(2));
			user.setBbs_title(rs.getString(3));
			user.setUser_data(rs.getString(4));
			user.setBbs_date(rs.getString(5));
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
		String sql="insert into bbs (user_id, bbs_title, user_data, bbs_date) values(?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getBbs_title());
			pstmt.setString(3, user.getUser_data());
			pstmt.setString(4, sdf.format(date));
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			disconnect();
		}
		return false;
	}
	
	public boolean update(User user) {
		connect();
		String sql="update bbs set bbs_title=?, user_data=?, bbs_date=? where bbs_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getBbs_title());
			pstmt.setString(2, user.getUser_data());
			pstmt.setString(3, sdf.format(date));
			pstmt.setInt(4, user.getBbs_no());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	public boolean delete(int bbs_no) {
		String sql="delete from bbs where bbs=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(bbs_no, 1);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			disconnect();
		}
		return false;
	}
}
