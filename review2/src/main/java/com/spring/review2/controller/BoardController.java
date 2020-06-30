package com.spring.review2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.review2.service.IBoardService;
import com.spring.review2.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	
	@GetMapping("/write")
	public String info() {
		return "board/write-form";
	}
	
	
	@PostMapping("/write")
	public String insert(BoardVO board) {
		System.out.println("/review2/board/write: POST");
		service.insert(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void getList(Model model) {
		model.addAttribute("boards", service.getList());
	}
	
	@GetMapping("/show")
	public void show( int boardNo , Model model) {
		model.addAttribute("board", service.getOneBoard(boardNo));
	}
	
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNo") int boardNo, Model model) {
		model.addAttribute("board",service.getOneBoard(boardNo));
		
	}
	
	@PostMapping("/modify")
	public String update(BoardVO board) {
		
		service.modify(board);
		return "redirect:/board/show?boardNo=" + board.getBoardNo();
	}
	
	@GetMapping("/delete")
	public String delete(int boardNo, Model model) {
		service.delete(boardNo);
		return "redirect:/board/list";
	}
	
	@GetMapping("/searchList")
	public String search(String keyword, Model model) {
		System.out.println("/board/search: GET");
		model.addAttribute("boards", service.getSearchList(keyword));
		return "board/list";
	}
	
	
}
