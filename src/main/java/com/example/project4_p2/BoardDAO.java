package com.example.project4_p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.project4_p2.BoardVO;
import com.example.project4_p2.JDBCUtil;

public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into WordCrud (WordLevel, WordVocab, WordMeaning) values (?,?,?)";
	private final String BOARD_UPDATE = "update WordCrud set WordLevel=?, WordVocab=?, WordMeaning=? where WordID=?";
	private final String BOARD_DELETE = "delete from WordCrud where WordID=?";
	private final String BOARD_GET = "select * from WordCrud where WordID=?";
	private final String BOARD_LIST = "select * from WordCrud order by WordID desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setInt(1, vo.getLevel());
			stmt.setString(2, vo.getVocab());
			stmt.setString(3, vo.getDef());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setInt(1, vo.getLevel());
			stmt.setString(2, vo.getVocab());
			stmt.setString(3, vo.getDef());
			stmt.setInt(4, vo.getSeq());
			
			
			System.out.println(vo.getLevel() + "-" + vo.getVocab() + "-" + vo.getDef() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("WordID"));
				one.setLevel(rs.getInt("WordLevel"));
				one.setVocab(rs.getString("WordVocab"));
				one.setDef(rs.getString("WordMeaning"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("WordID"));
				one.setLevel(rs.getInt("WordLevel"));
				one.setVocab(rs.getString("WordVocab"));
				one.setDef(rs.getString("WordMeaning"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
