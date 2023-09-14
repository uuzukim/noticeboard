package kr.or.ddit.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.validate.groups.AuthGroup;
import lombok.RequiredArgsConstructor;

@SessionAttributes("authentiatedBoard")
@RequiredArgsConstructor
@Controller
public class BoardUpdateAuthenticationController {
	
	private final FreeboardService service;
	
	@PostMapping("/board/updateAuth.do")
	public String boardAuthenticate(
		@Validated(AuthGroup.class) FreeboardVO input
		, Errors errors
		, Model model
		, RedirectAttributes redirectAttributes
	) {
		String viewName = null;
		FreeboardVO board = service.boardAuthenticate(input);
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "데이터 누락");
			viewName = "redirect:/board/boardView.do?what="+input.getBoNo();
		}else {
			if(board==null) {
				redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
				viewName = "redirect:/board/boardView.do?what="+input.getBoNo();
			}else {
				model.addAttribute("authentiatedBoard", board);
				redirectAttributes.addAttribute("what", board.getBoNo());
				viewName = "redirect:/board/boardUpdate.do";
			}
		}
		return viewName;
	}
}
