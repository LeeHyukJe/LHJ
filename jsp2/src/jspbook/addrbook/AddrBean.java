package jspbook.addrbook;


import java.sql.*;
import java.util.*;

/**
 * file:AddrBean.java
 * desc:주소록 프로그램 DAO 클래스
 * @author 이혁제(lims2733@naver.com)
 */

public class AddrBean {
	Connection conn;
	PreparedStatement pstmt;
	
	String jdbc_driver;
	String jdbc_url;
	
	void connect() {
		
		
		if(System.getProperty("user.name").equals("lims2733")) {
			jdbc_driver="com.mysql.jdbc.Driver";
			jdbc_url="jdbc:mysql://127.0.0.1:3306/db";
		}
		else {
			jdbc_driver="oracle.jdbc.driver.OracleDriver";
			jdbc_url="jdbc:oracle:thin:@localhost:1521:xe";
		}
		
		try {
			Class.forName(jdbc_driver);
			conn=DriverManager.getConnection(jdbc_url,"root","1234");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void disconnect() {
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				System.out.println(e);
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public boolean updateDB(AddrBook addrbook) {
		connect();
		
		String sql="update addrbook set ab_name=?,ab_email=?, ab_comdept=?,ab_birth=?,ab_tel=?, ab_memo=? ab_password=? where ab_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addrbook.getAb_name());
			pstmt.setString(2, addrbook.getAb_email());
			pstmt.setString(3, addrbook.getAb_comdept());
			pstmt.setString(3, addrbook.getAb_birth());
			pstmt.setString(5, addrbook.getAb_tel());
			pstmt.setString(6, addrbook.getAb_memo());
			pstmt.setInt(7, addrbook.getAb_password());
			pstmt.setString(8, addrbook.getAb_id());
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean deleteDB(String gb_id) {
		connect();
		
		String sql="delete from addrbook where ab_id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, gb_id);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}finally {
			disconnect();
		}
		return true;
	}
	
	public boolean insertDB(AddrBook addrbook) {
		connect();
		
		String sql="insert into addrbook(ab_id,ab_name,ab_email,ab_comdept,ab_birth,ab_tel,ab_memo,ab_picture,ab_password) values(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addrbook.getAb_id());
			pstmt.setString(2, addrbook.getAb_name());
			pstmt.setString(3, addrbook.getAb_email());
			pstmt.setString(4, addrbook.getAb_comdept());
			pstmt.setString(5, addrbook.getAb_birth());
			pstmt.setString(6, addrbook.getAb_tel());
			pstmt.setString(7, addrbook.getAb_memo());
			pstmt.setString(8,addrbook.getAb_picture());
			pstmt.setInt(9, addrbook.getAb_password());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			disconnect();
		}
		return true;
	}
	
	public AddrBook getDB(String gb_id) {
		connect();
		
		String sql="select *from addrbook where ab_id=?";
		AddrBook addrbook=new AddrBook();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, gb_id );
			ResultSet rs=pstmt.executeQuery();
			rs.next();
				addrbook.setAb_id(rs.getString(1));
				addrbook.setAb_name(rs.getString(2));
				addrbook.setAb_email(rs.getString(3));
				addrbook.setAb_birth(rs.getString(4));
				addrbook.setAb_tel(rs.getString(5));
				addrbook.setAb_comdept(rs.getString(6));
				addrbook.setAb_memo(rs.getString(7));
				addrbook.setAb_picture(rs.getString(8));
				addrbook.setAb_password(rs.getInt(9));
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			disconnect();
		}
		return addrbook;
	}
	
	public ArrayList<AddrBook> getDBList(){
		connect(); //db와 연결
		ArrayList<AddrBook>datas=new ArrayList<>(); //addrbook객체를 담을 배열 생성
		String sql="select * from addrbook";
		
		try {
			pstmt=conn.prepareStatement(sql); //
			ResultSet rs=pstmt.executeQuery(); //쿼리문 실행
			while(rs.next()) {
				AddrBook addrbook=new AddrBook();
				addrbook.setAb_id(rs.getString(1)); //첫번째 행을 객체에 담음
				addrbook.setAb_name(rs.getString(2)); //두번째행을 객체에 담음
				addrbook.setAb_email(rs.getString(3)); //세번째 행을 객체에 담음
				addrbook.setAb_comdept(rs.getString(4)); //여섯번째 행을 객체에 담음
				addrbook.setAb_birth(rs.getString(5)); //네번째 행을 객체에 담음
				addrbook.setAb_tel(rs.getString(6)); //다섯번째 행을 객체에 담음
				addrbook.setAb_memo(rs.getString(7));
				addrbook.setAb_picture(rs.getString(8));
				addrbook.setAb_password(rs.getInt(9));
				datas.add(addrbook);
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			disconnect();
		}
		return datas;
	}
}
