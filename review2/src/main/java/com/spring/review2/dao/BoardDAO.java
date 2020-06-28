package com.spring.review2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.review2.vo.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	private List<BoardVO> list = new ArrayList<BoardVO>();
	
	
	@Override
	public void insert(BoardVO board) {
		list.add(board);
	}

	@Override
	public List<BoardVO> getList() {
		return list;
	}

	@Override
	public BoardVO getOneBoard(int index) {
		return list.get(index);
	}

	@Override
	public BoardVO modify(int index, BoardVO board) {
		list.set(index, board);
		
		
		return list.get(index);
	}

	@Override
	public void delete(int index) {
		list.remove(index);

	}

}
