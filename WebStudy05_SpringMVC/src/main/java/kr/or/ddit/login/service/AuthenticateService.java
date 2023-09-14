package kr.or.ddit.login.service;

import kr.or.ddit.login.AuthenticateException;
import kr.or.ddit.vo.MemberVO;

/**
 * 인증 시스템을 위한 Business Logic Layer
 *
 */
public interface AuthenticateService {
	/**
	 * 인증 여부를 판단하기 위한 로직
	 * @param inputData
	 * @return 인증에 성공한 사용자에 대한 정보 반환(아이디, 비밀번호, 이메일 휴대폰, 이름)
	 * @throws AuthenticateException 인증 실패시 발생 예외
	 */
	public MemberVO authenticate(MemberVO inputData) throws AuthenticateException;
}
