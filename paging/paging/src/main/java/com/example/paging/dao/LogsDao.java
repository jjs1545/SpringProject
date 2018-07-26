package com.example.paging.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.paging.vo.LogVo;

public class LogsDao {
	private static final String DB_USER = "webdb";
	private static final String DB_PASS = "webdb";

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/myportal?serverTimezone=UTC";
		conn = DriverManager.getConnection(url, DB_USER, DB_PASS);

		return conn;
	}

	public int getMaxPageCount(int logsPerPage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int maxPage = 1;
		try {
			conn = getConnection();

			// 페이징의 대상이 되는 게시물의 총 개수와 정수 나눗셈의 몫, 나머지를 구함
			String sql = "SELECT tot, tot div ?, tot mod ? FROM " + "(SELECT count(*) tot FROM log) t";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, logsPerPage);
			pstmt.setInt(2, logsPerPage);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				maxPage = rs.getInt(2);
				int remains = rs.getInt(3);

				// 정수 나눗셈의 나머지가 있다면 한페이지 추가
				if (remains > 0) {
					maxPage += 1;
				}
			}

		} catch (ClassNotFoundException e) {
			System.err.println("JDBC 드라이버를 로드하지 못했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return maxPage;
	}

	public List<LogVo> getContentListByPage(int currPage, int logsPerPage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<LogVo> contents = new ArrayList<>();

		try {
			conn = getConnection();
			String sql = "SELECT id, log, created_at FROM log " +
						"ORDER BY created_at DESC, id DESC " +
						"LIMIT ?, ?";
			pstmt = conn.prepareStatement(sql);
			
			int startPos = (currPage - 1) * logsPerPage;
			pstmt.setInt(1, startPos);
			pstmt.setInt(2, logsPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				LogVo vo = new LogVo();
				vo.setId(rs.getInt(1));
				vo.setLog(rs.getString(2));
				vo.setCreatedAt(rs.getDate(3));
				
				contents.add(vo);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC 드라이버를 로드하지 못했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return contents;
	}
}
