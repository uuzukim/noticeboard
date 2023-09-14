package kr.or.ddit.file.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.file.vo.AtchFileDetailVO;
import kr.or.ddit.file.vo.AtchFileVO;

@Mapper
public interface AtchFileDAO {
	public AtchFileDetailVO selectAtchFileDetail(AtchFileDetailVO condition);
	public AtchFileVO selectAtchFileGroup(int atchFileId);
	
	public int insertAtchFileGroup(AtchFileVO atchFileGroup);
}
