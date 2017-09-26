package mvc_parctice;

import java.util.*;
import java.sql.*;

class User {
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_email;

	public User() {

	}

	public User(String user_id, String user_name, String user_password, String user_email) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_email = user_email;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_email=" + user_email + "]";
	}

}

public class MVCTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO udao = UserDAO.getInstance();
		// UserDAO udao=new UserDAO();
		List<User> list = udao.selectAllUser();
		System.out.println(list);
	}
}

class Dao {
	Connection conn;
	String tableName = "";
	String jdbc_driver;
	String jdbc_url;

	Dao() {
		this(null, "");
	}

	Dao(String tableName) {
		this(null, tableName);
	}

	Dao(Connection conn, String tableName) {
		this.tableName = tableName;

		jdbc_driver = "com.mysql.jdbc.Driver";
		jdbc_url = "jdbc:mysql://127.0.0.1:3306/db";
		try {
			//Class.forName(jdbc_driver);
			this.conn = DriverManager.getConnection(jdbc_url, "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

	void close(AutoCloseable... acs){
//		for (int i = 0; i < acs.length; i++) {
//			if (acs[i] != null) {
//				acs[i].close();
//			}
//		}

		for (AutoCloseable ac : acs) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	Connection setConnect() {
		return conn;
	}
}

class BoardDao extends Dao {
	public BoardDao() {

	}
}

class UserDAO extends Dao {
	String tableName;
	PreparedStatement pstmt;
	ResultSet rs;

	UserDAO() {
		this("");
	}

	UserDAO(String tableName) {
		this(null, tableName);
	}

	UserDAO(Connection conn, String tableName) {
		super(conn, tableName);
	}

	private static UserDAO userdao = new UserDAO();

	public static UserDAO getInstance() {
		return userdao;
	}

	int insertUser(User user) {
		String sql = "insert into mybbs (user_id,user_password, user_name,user_email) values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_password());
			pstmt.setString(4, user.getUser_email());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
			return -1;
		} finally {
			close(pstmt);
		}

	}

	int updateUser(User user) {
		String sql = "update mybbs set user_password=?, user_name=?, user_email=? where=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_password());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_email());
			pstmt.setString(4, user.getUser_id());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
			return -1;
		} finally {
			close(pstmt);
		}

	}

	User selectUser(String user_id) {
		String sql = "select * from mybbs where user_id=?";
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			rs.next();
			user.setUser_name(rs.getString(2));
			user.setUser_password(rs.getString(3));
			user.setUser_email(rs.getString(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
		} finally {
			close(pstmt,rs);
		}
		return user;
	}

	List<User> selectAllUser() {
		String sql = "select * from mybbs";
		ArrayList<User> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUser_id(rs.getString(1));
				user.setUser_password(rs.getString(2));
				user.setUser_name(rs.getString(3));
				user.setUser_email(rs.getString(4));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();

		} finally {
			close(pstmt,rs);
		}
		return list;
	}

	int deleteUser(String user_id) {
		String sql = "delete from mybbs where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rollback();
			return -1;
		} finally {
			close(pstmt);
		}
	}
}
