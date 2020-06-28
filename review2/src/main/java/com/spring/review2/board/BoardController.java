package com.spring.review2.board;

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
	public void show(@ModelAttribute("boardNum") int boardNum , Model model) {
		model.addAttribute("board", service.getOneBoard(boardNum));
	}
	
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNum") int boardNum, Model model) {
		model.addAttribute("board",service.getOneBoard(boardNum));
		
	}
	
	@PostMapping("/modify")
	public String update(@ModelAttribute("boardNum") int boardNum, Model model , BoardVO board) {
		
		model.addAttribute("board", service.modify(boardNum, board));
		return "redirect:/board/show";
	}
	
	@GetMapping("/delete")
	public String delete(int boardNum, Model model) {
		service.delete(boardNum);
		return "redirect:/board/list";
	}
	
	
}
