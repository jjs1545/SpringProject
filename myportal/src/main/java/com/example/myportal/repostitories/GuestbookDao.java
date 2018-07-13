package com.example.myportal.repostitories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;

import com.example.myportal.vo.GuestbookVo;


@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;
	// selectAll v1
	/*public List<GuestbookVo> selectAll(){
		// 준비
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// applicationContext 얻기 -> @Autowired
		ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		
		// 결과 값을 담을 List 선언
		List<GuestbookVo> list = new ArrayList<>();
		
		try {
			// 로직
			DataSource ds = (DataSource)ctx.getBean("dataSource"); // 생성돼있는 Bean id로 끄집어 냄
			conn = ds.getConnection();
			
			stmt = conn.createStatement();
			String sql = " SELECT no, name, password, content, regdate FROM guestbook ORDER BY regdate DESC ";
			System.out.println("SQL : " + sql);
			// select문일 때 executeQuery를 사용
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
				
				GuestbookVo vo = new GuestbookVo(no, name, password, content, regdate);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println("SQLError");
			}
		}
//		System.out.println(list);
		return list;
	}*/
	
	// selectAll v2
	public List<GuestbookVo> selectAll() {
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		return list;
	}
	
	//insert
	public int insert(GuestbookVo vo) {
		int count = sqlSession.insert("guestbook.insert", vo);
		return count;
	}
	
	//delete
	public int delete(GuestbookVo vo) {
		int count = sqlSession.delete("guestbook.delete",vo);
		return count;
	}
}
