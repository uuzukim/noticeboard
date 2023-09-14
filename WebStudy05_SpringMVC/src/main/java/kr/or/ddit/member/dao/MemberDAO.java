package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaginationInfo;

/**
 * 회원관리용 Persistence Layer
 *
 */
@Mapper
public interface MemberDAO {
	/**
	 * 신규 회원 등록
	 * @param member
	 * @return 등록된 레코드수 > 0 : 성공
	 */
	public int insertMember(MemberVO member);
	/**
	 * 인증에 활용할 회원 정보 조회
	 * @param memId 회원식별자(username)
	 * @return 존재하지 않는 경우, null 반환
	 */
	public MemberVO selectMemberForAuth(String memId);
	/**
	 * 회원 정보 상세 조회
	 * @param memId
	 * @return 존재하지 않는 경우, null 반환
	 */
	public MemberVO selectMember(String memId);
	/**
	 * 회원수 조회
	 * @return 검색 조건에 맞는 회원수 조회
	 */
	public long selectTotalRecord(PaginationInfo<MemberVO> paging);
	/**
	 * 회원 목록 조회
	 * @param paging TODO
	 * @return 조건에 맞는 목록이 없는 경우, size == 0 반환
	 */
	public List<MemberVO> selectMemberList(PaginationInfo<MemberVO> paging);
	/**
	 * 회원 정보 수정
	 * @param member
	 * @return 수정된 레코드수, > 0 성공
	 */
	public int updateMember(MemberVO member);
	/**
	 * 회원 정보 삭제(?)
	 * @param memId
	 * @return 삭제된 레코드수, > 0 성공
	 */
	public int deleteMember(@Param("memId") String memId);
}



















