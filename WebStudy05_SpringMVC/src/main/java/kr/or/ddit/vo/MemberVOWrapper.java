package kr.or.ddit.vo;

import java.security.Principal;

public class MemberVOWrapper implements Principal{
	private MemberVO realUser;

	public MemberVOWrapper(MemberVO realUser) {
		super();
		this.realUser = realUser;
	}

	@Override
	public String getName() {
		return realUser.getMemId();
	}
	
	public MemberVO getRealUser() {
		return realUser;
	}
	
}
