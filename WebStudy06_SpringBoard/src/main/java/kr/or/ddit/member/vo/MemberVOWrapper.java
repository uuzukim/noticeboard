package kr.or.ddit.member.vo;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class MemberVOWrapper extends User{
	private MemberVO realUser;

	public MemberVOWrapper(MemberVO realUser) {
		super(realUser.getMemId(), 
			  realUser.getMemPass(), 
			  !realUser.isMemDelete(), 
			  true, 
			  true, 
			  true, 
			  AuthorityUtils.createAuthorityList(realUser.getMemRole())
		);
		this.realUser = realUser;
	}

	
	public MemberVO getRealUser() {
		return realUser;
	}
	
}
