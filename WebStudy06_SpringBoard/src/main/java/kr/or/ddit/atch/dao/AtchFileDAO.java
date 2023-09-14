package kr.or.ddit.atch.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;

@Mapper
public interface AtchFileDAO {
	public AtchFileDetailVO selectAtchFileDetail(AtchFileDetailVO condition);
	public AtchFileVO selectAtchFileGroup(int atchFileId);
	
	public int insertAtchFileGroup(AtchFileVO atchFileGroup);
	
	/**
	 * 기존 파일 그룹내 신규 파일 첨부
	 * @param atchFileGroup
	 * @return
	 */
	public int insertAtchFileDetails(@Param("atchFileGroup") AtchFileVO atchFileGroup);
	
	/**
	 * 파일 그룹 제거
	 * @param atchFileId
	 * @return
	 */
	public int deleteAtchFileGroup(int atchFileId);
	/**
	 * 파일 그룹내 파일들 제거
	 * @param atchFileId
	 * @return
	 */
	public int deleteAtchFileDetails(int atchFileId);
	
	/**
	 * 파일 상세 한건 제거
	 * @param condition
	 * @return
	 */
	public int deleteAtchFileDetail(AtchFileDetailVO condition);
}
