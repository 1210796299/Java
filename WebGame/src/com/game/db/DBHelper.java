package com.game.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBHelper {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/game?useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String password = "52java";

	/** 连接数据库公共方法 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到数据库驱动类");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return conn;
	}

	/** 增刪改的公共方法 */
	public boolean update(String sql, List<Object> temp) throws Exception {
		// 1.连接数据库
		conn = getConnection();
		// 2.引入sql语句
		pstmt = conn.prepareStatement(sql);
		// 3.为问号赋值
		if (temp != null && temp.size() > 0) {
			for (int i = 0; i < temp.size(); i++) {
				pstmt.setObject(i + 1, temp.get(i));
			}
		}
		// 4.执行
		System.out.println("-----执行的增刪改sql语句：" + pstmt);
		// 5.返回结果
		int i = pstmt.executeUpdate();
		return i > 0 ? true : false;
	}

	/** 查询的公共方法 */
	public ResultSet query(String sql, List<Object> temp) throws Exception {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		if (temp != null && temp.size() > 0) {
			for (int i = 0; i < temp.size(); i++) {
				pstmt.setObject(i + 1, temp.get(i));
			}
		}
		System.out.println("-----执行的查询sql语句：" + pstmt);
		rs = pstmt.executeQuery();
		return rs;
	}

	/** 关闭数据库的公共方法 */
	public void colseAll() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBHelper db = new DBHelper();
		db.getConnection();
	}

}
