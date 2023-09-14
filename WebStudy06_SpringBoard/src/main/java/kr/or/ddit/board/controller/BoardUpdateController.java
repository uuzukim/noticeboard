package kr.or.ddit.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.service.FreeboardService;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.RequiredArgsConstructor;

@SessionAttributes("authentiatedBoard")
@RequiredArgsConstructor
@Controller
public class BoardUpdateController {
	
	private final FreeboardService service;
	
	@ModelAttribute("targetBoard")
	public FreeboardVO board(@RequestParam int what) {
		return service.retrieveBoard(what);
	}
	
	
	@GetMapping("/board/boardUpdate.do")
	public String updateForm(
		@ModelAttribute("targetBoard") FreeboardVO board
		, Model model
		, RedirectAttributes redirectAttributes
	) {
		Map<String, Object> modelMap = model.asMap();
		String viewName = null;
		if(model.containsAttribute("authentiatedBoard") && modelMap.get("authentiatedBoard").equals(board)) {
			viewName = "board/boardEdit";
		}else {
			redirectAttributes.addFlashAttribute("message", "비밀번호를 입력하고 정상 루트로 수정을 시도하시오.");
			viewName = "redirect:/board/boardList.do";
		}
		return viewName;
	}
	
	@PostMapping("/board/boardUpdate.do")
	public String boardUpdate(
		@Validated(UpdateGroup.class) @ModelAttribute("targetBoard") FreeboardVO board
		, BindingResult errors
		, Model model
		, RedirectAttributes redirectAttributes
		, SessionStatus sessionStatus
	) {
		String viewName = null;
		if(model.containsAttribute("authentiatedBoard") && model.asMap().get("authentiatedBoard").equals(board)) {
			if(!errors.hasErrors()) {
				boolean success = service.modifyBoard(board);
				if(success) {
					sessionStatus.setComplete();
					viewName = "redirect:/board/boardView.do?what="+board.getBoNo();
				}else {
					model.addAttribute("message", "새글 작성중 문제 발생");
					viewName = "board/boardEdit";
				}
			}else {
				viewName = "board/boardEdit";
			}
		}else {
			redirectAttributes.addFlashAttribute("message", "비밀번호를 입력하고 정상 루트로 수정을 시도하시오.");
			viewName = "redirect:/board/boardList.do";
		}
		
		return viewName;
	}
}
