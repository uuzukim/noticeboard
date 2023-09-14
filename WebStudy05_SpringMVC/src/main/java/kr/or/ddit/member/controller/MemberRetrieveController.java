package kr.or.ddit.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaginationInfo;
import kr.or.ddit.vo.SimpleCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberRetrieveController{
	
	private final MemberService service;
	
	@RequestMapping("/member/memberList.do")
	public String memberList(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, SimpleCondition simpleCondition
		, Model model
	){
		PaginationInfo<MemberVO> paging = new PaginationInfo<>(5, 3);
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		
		List<MemberVO> memberList = service.retrieveMemberList(paging);
		paging.setDataList(memberList);
		
		model.addAttribute("paging", paging);
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/memberView.do")
	public String memberView(@RequestParam(name="who", required = true) String memId, Model model){
		MemberVO member = service.retrieveMember(memId);
		
		model.addAttribute("member", member);
		
		return "member/ajax/memberView";
	}
}












