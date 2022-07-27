package com.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardVO;
import com.board.util.DBmanager;

public class BoardDAO {

	private BoardDAO() {
		
	}
	
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	//Read All Start
	public List<BoardVO> selectAllBoards() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBmanager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("NUM"));
				bVo.setName(rs.getString("NAME"));
				bVo.setPass(rs.getString("PASS"));
				bVo.setTitle(rs.getString("TITLE"));
				bVo.setContent(rs.getString("CONTENT"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("WRITEDATE"));					//BoardVO에서 import를 sql에 해당하는거로 해줘야 타입 에러 안남  실수없이 ipmort 확인합시다
				
				
				
				list.add(bVo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.close(conn, stmt, rs);
		}
		
		return list;
	}//Read All End
	
	
	//Update(new DB) start
	public void insertBoard(BoardVO bVo) {
		String sql = "INSERT INTO board(num, name, email, pass, title, content) VALUES(board_seq.nextval, ?, ?, ?, ?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getEmail());
			pstmt.setString(3, bVo.getPass());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.close(conn, pstmt);
		}
		
	}//Update End
	
	
	//Update (count add) stard
	public void updateReadCount(String num) {
		String sql = "UPDATE BOARD SET readcount = readcount+1 WHERE num = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBmanager.close(conn, pstmt);
		}
	}//Update (count add) End
	
	
	
	//Read by num Start
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "SELECT * FROM board WHERE num = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardVO bVo = null;
		
		
		
		try {
			conn = DBmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("NUM"));
				bVo.setName(rs.getString("NAME"));
				bVo.setEmail(rs.getString("EMAIL"));
				
				bVo.setPass(rs.getString("PASS"));
				bVo.setTitle(rs.getString("TITLE"));
				bVo.setContent(rs.getString("CONTENT"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("WRITEDATE"));		
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.close(conn, pstmt, rs);
		}
		
		return bVo;
	}//Read by num End
	
	
	//Update 
	public void updateBoard(BoardVO mVo) {
		
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET name = ?, pass = ?, email = ?, title = ?, content = ? WHERE NUM = ?";
		
		try {
			conn = DBmanager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getPass());
			pstmt.setString(3, mVo.getEmail());
			pstmt.setString(4, mVo.getTitle());
			pstmt.setString(5, mVo.getContent());
			pstmt.setInt(6, mVo.getNum());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.close(conn, pstmt);
		}
		
	}//Update End
	
	
	//Delete start
	public void deleteBoard(String num) {
		String sql = "DELETE BOARD WHERE NUM = ?";
		System.out.println(num);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBmanager.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.close(conn, pstmt);
		}
	}
	
	
}
