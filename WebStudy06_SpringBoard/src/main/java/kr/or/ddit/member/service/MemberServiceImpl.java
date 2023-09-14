package kr.or.ddit.member.service;

import java.text.MessageFormat;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.MemberVOWrapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	// 의존관계 형성 --> 결합력 발생 --> 차후 DI(Dependency Injection) 구조로 해결.
	@Inject
	private MemberDAO memberDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = memberDAO.selectMemberForAuth(username);
		if(member==null) {
			throw new UsernameNotFoundException(MessageFormat.format("{0} 사용자 없음.", username));
		}
		return new MemberVOWrapper(member);
	}

}






























