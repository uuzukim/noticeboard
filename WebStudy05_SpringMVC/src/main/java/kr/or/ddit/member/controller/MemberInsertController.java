package kr.or.ddit.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController{
	
	@Inject
	private final MemberService service;
	
	@ModelAttribute("member")
	public MemberVO member() {
		return new MemberVO();
	}
	
	/**
	 * 가입 양식 제공
	 */
	@GetMapping
	public String getHandler(){
		return "member/memberForm";
	}

	/**
	 * 양식을 통해 입력된 개인 정보 처리
	 *
	 */
	@PostMapping
	public String postHandler(
		@Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member // command object
		, Errors errors
		, Model model
	){
		String logicalViewName = null;
		
		if (!errors.hasErrors()) {
			ServiceResult result = service.createMember(member);
			switch (result) {
				case PKDUPLICATE:
					model.addAttribute("message", "아이디 중복");
					logicalViewName = "member/memberForm";
					break;
				case OK:
					logicalViewName = "redirect:/";
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
