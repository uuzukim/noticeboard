package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController{
	
	@Inject
	private MemberService service;
	
	@GetMapping
	public String getHandler(Principal principal, Model model){
		MemberVO member = service.retrieveMember(principal.getName());
		
		model.addAttribute("member", member);
		
		return "member/memberForm";
	}
	
	@PostMapping
	public String postHandler(
		Principal principal	
		, @Validated(UpdateGroup.class) @ModelAttribute("member") MemberVO member
		, BindingResult errors
		, Model model
	) {

		member.setMemId(principal.getName());
		
		String logicalViewName = null;
		
		if (!errors.hasErrors()) {
			ServiceResult result = service.modifyMember(member);
			switch (result) {
				case INVALIDPASSWORD:
					model.addAttribute("message", "비밀번호 오류");
					logicalViewName = "member/memberForm";
					break;
				case OK:
					logicalViewName = "redirect:/mypage";
					break;
				default:
					model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "member/memberForm";
					break;
			}
		}else {
			logicalViewName = "member/memberForm";
		}
		return logicalViewName;
	}
	
}
