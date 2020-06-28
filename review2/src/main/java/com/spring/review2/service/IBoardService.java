package com.spring.review2.service;

import java.util.List;

import com.spring.review2.vo.BoardVO;

public interface IBoardService {
	void insert(BoardVO board);
	
	List<BoardVO> getList();
	
	BoardVO getOneBoard(int index);
	
	BoardVO modify(int index, BoardVO board);
	
	void delete(int index);
	
}
