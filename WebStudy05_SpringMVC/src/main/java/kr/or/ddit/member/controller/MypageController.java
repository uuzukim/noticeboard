package kr.or.ddit.member.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MypageController{
	
	private final MemberService service;
	
	@RequestMapping("/mypage")
	public String doGet(MemberVOWrapper principal, Model model){
		
		MemberVO detail = service.retrieveMember(principal.getName());
		
		model.addAttribute("member", detail);
		
		return "member/mypage";
	}
}




























