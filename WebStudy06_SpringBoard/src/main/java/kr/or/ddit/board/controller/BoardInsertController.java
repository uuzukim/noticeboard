package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.validate.groups.InsertGroup;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/boardInsert.do")
public class BoardInsertController {
	
	private final FreeboardService service;
	
	@ModelAttribute("freeboard")
	public FreeboardVO board() {
		return new FreeboardVO();
	}
	
	@GetMapping
	public String boardForm() {
		return "board/boardForm";
	}
	
	@PostMapping
	public String boardInsert(
		@Validated(InsertGroup.class) @ModelAttribute("freeboard") FreeboardVO board
		, BindingResult errors
		, Model model
	) {
		String viewName = null;

		if(!errors.hasErrors()) {
			boolean success = service.createBoard(board);
			if(success) {
				viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
			}else {
				model.addAttribute("message", "새글 작성중 문제 발생");
				viewName = "board/boardForm";
			}
		}else {
			viewName = "board/boardForm";
		}
		
		return viewName;
	}
}










