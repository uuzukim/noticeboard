package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaginationInfo;

/**
 * 회원 관리용 Business Logic Layer
 *
 */
public interface MemberService {
	/**
	 * 신규 회원 등록
	 * @param member
	 * @return 아이디 중복(PKDUPLICATE), 성공(OK), 실패(FAIL)
	 */
	public ServiceResult createMember(MemberVO member);
	/**
	 * 회원 상세 조회
	 * @param memId
	 * @return 존재하는 경우, 회원 정보 반환
	 * @throws PKNotFoundException 사용자가 존재하지 않을때 발생
	 */
	public MemberVO retrieveMember(String memId) throws PKNotFoundException;
	/** 
	 * 회원 목록 조회
	 * @param paging TODO
	 * @return 검색 조건에 일치하는 회원이 없는 경우, size == 0 반환
	 */
	public List<MemberVO> retrieveMemberList(PaginationInfo<MemberVO> paging);
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return 비번 인증 실패(INVALIDPASSWORD), 성공(OK), 실패(FAIL)
	 */
	public ServiceResult modifyMember(MemberVO member);
	/**
	 * 회원 탈퇴
	 * @param member
	 * @return 비번 인증 실패(INVALIDPASSWORD), 성공(OK), 실패(FAIL)
	 */
	public ServiceResult removeMember(MemberVO member);
}


































