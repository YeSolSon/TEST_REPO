package com.mycompany.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.biz.board.BoardVO;
import com.mycompany.biz.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAO implements BoardService {

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	
	private final String BOARD_INSERT="insert into board (seq,title,writer,content) values ((select seq from (select ifnull(max(seq),0)+1 as seq from board)tmp),?,?,?);";
	private final String BOARD_UPDATE="update board set title=?,content=? where seq=?";
	private final String BOARD_DELETE="delete from board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	private final String BOARD_LIST=" select * from board order by seq desc";
	
	//CRUD

	@Override
	public void insertBoard(BoardVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1,vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();				
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	@Override
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	@Override
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	@Override
	public BoardVO getBoard(BoardVO vo) {
		BoardVO v = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				v.setSeq(rs.getInt("seq"));
				v.setTitle(rs.getString("title"));
				v.setWriter(rs.getString("writer"));
				v.setContent(rs.getString("content"));
				v.setRegDate(rs.getDate("regDate"));
				v.setCnt(rs.getInt("cnt"));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		
		return v;
	}
	@Override
	public List<BoardVO> getBoardList(BoardVO vo){
		ArrayList<BoardVO> boardVo = new ArrayList<BoardVO>();
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				BoardVO v2 = new BoardVO();
				v2.setSeq(rs.getInt("seq"));
				v2.setTitle(rs.getString("title"));
				v2.setWriter(rs.getString("writer"));
				v2.setContent(rs.getString("content"));
				v2.setRegDate(rs.getDate("regDate"));
				v2.setCnt(rs.getInt("cnt"));
				boardVo.add(v2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt,conn);		
		}
		return boardVo;
	}
}
