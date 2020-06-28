package com.spring.review2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.review2.dao.IBoardDAO;
import com.spring.review2.vo.BoardVO;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDAO dao;
	
	
	@Override
	public void insert(BoardVO board) {
		System.out.println(board.toString());
		dao.insert(board);
	}

	@Override
	public List<BoardVO> getList() {
		return dao.getList();
	}

	@Override
	public BoardVO getOneBoard(int index) {
		return dao.getOneBoard(index - 1);
	}

	@Override
	public BoardVO modify(int index, BoardVO board) {
		return dao.modify((index - 1), board);
	}

	@Override
	public void delete(int index) {
		dao.delete(index - 1);

	}

}
