package kr.or.ddit.member.controller;

import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MemberDeleteController{
	@Inject
	private MemberService service;
	
	@PostMapping("/member/memberDelete.do")
	public String postHandler(
		MemberVOWrapper principal
		, Optional<String> password
		, RedirectAttributes redirectAttributes
		, HttpSession session
	){
		String logicalViewName = null;
		if(password.filter(p->!p.isEmpty()).isPresent()) {
			MemberVO inputData = new MemberVO();
			inputData.setMemId(principal.getName());
			inputData.setMemPass(password.get());
			
			ServiceResult result = service.removeMember(inputData);
			switch (result) {
			case INVALIDPASSWORD:
				redirectAttributes.addFlashAttribute("message", "비번 오류");
				logicalViewName = "redirect:/mypage";
				break;
			case OK:
				session.invalidate();
				logicalViewName = "redirect:/";
				break;
			default:
				break;
			}
		}else {
			redirectAttributes.addFlashAttribute("message", "비번 누락");
			logicalViewName = "redirect:/mypage";
		}
		
		return logicalViewName;
	}
}

