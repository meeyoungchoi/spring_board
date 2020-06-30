package com.spring.review2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.review2.vo.BoardVO;



@Repository
public class BoardDAO implements IBoardDAO {

	
	public class BoardMapper implements RowMapper<BoardVO> {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO board = new BoardVO();
			board.setBoardNo(rs.getInt("board_No"));
			board.setUserId(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setTitle(rs.getString("title"));
			return board;
		}
		
	}


	@Autowired
	private JdbcTemplate template;
	
	
	
	
	@Override
	public void insert(BoardVO board) {
		String sql = "INSERT INTO board "
				+ "(writer,title,content) "
				+ "VALUES(?,?,?)";
		
		template.update(sql, board.getUserId(), board.getTitle(), board.getContent());
		
	}

	@Override
	public List<BoardVO> getList() {
		String sql = "SELECT * FROM board";
		return template.query(sql, new BoardMapper());
	}

	@Override
	public BoardVO getOneBoard(int boardNo) {
		String sql = "SELECT * FROM board WHERE board_No=?";
		return template.queryForObject(sql, new BoardMapper(), boardNo);
	}

	@Override
	public void modify(BoardVO board) {
		String sql = "UPDATE board SET "
				+ "writer=?, title=?, content=? "
				+ "WHERE board_No=?";
	
		
		
		template.update(sql, board.getUserId(), board.getTitle(), board.getContent(), board.getBoardNo());
		
	}

	@Override
	public void delete(int boardNo) {
		String sql = "DELETE FROM board where board_No=?";

		template.update(sql, boardNo);

	}
	
	@Override
	public List<BoardVO> getSearchList(String keyword) {
		System.out.println(keyword);
		String sql = "SELECT * FROM board "
				+ "WHERE writer LIKE ? "		
				+ "ORDER BY board_No DESC";
		return template.query(sql, new BoardMapper(), keyword);
	}

}
