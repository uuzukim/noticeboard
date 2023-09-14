package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardDeleteController {
	private final FreeboardService service;
	
	@PostMapping("/board/boardDelete.do")
	public String boardDelete(FreeboardVO board, RedirectAttributes redirectAttributes) {
		boolean success = service.removeBoard(board);
		String viewName = null;
		if(success) {
			viewName = "redirect:/board/boardList.do";
		}else {
			redirectAttributes.addFlashAttribute("message", "게시글 삭제 실패, 비밀번호 확인");
			viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
		}
		return viewName;
	}
	
}
