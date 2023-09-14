package kr.or.ddit.member.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.vo.MemberVOWrapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MypageController {
	@RequestMapping("/mypage")
	public String mypage(Authentication authentication) {
		String username = authentication.getName();
		MemberVOWrapper wrapper = (MemberVOWrapper) authentication.getPrincipal();
		
		log.info(" 현재 인증 객체 : {} ", authentication);
		log.info(" 현재 인증된 사용자 아이디 : {} ", username);
		log.info(" 현재 인증된 사용자 객체 : {} ", wrapper);
		log.info(" 현재 인증된 사용자의 이름 : {} ", wrapper.getRealUser().getMemName());
		return "member/mypage";
	}
}
