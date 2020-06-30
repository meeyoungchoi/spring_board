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
		return dao.getOneBoard(index);
	}

	
	@Override
	public void delete(int index) {
		dao.delete(index);

	}

	@Override
	public void modify(BoardVO board) {
		dao.modify( board);
		
	}

	@Override
	public List<BoardVO> getSearchList(String keyword) {
		keyword = "%" + keyword + "%";
		return dao.getSearchList(keyword);
	}

}
