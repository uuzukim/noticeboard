package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;

@Mapper
public interface FreeboardDAO {
	public int insertBoard(FreeboardVO board);
	
	public long selectTotalRecord(PaginationInfo paging);
	public List<FreeboardVO> selectBoardList(PaginationInfo paging);
	
	public FreeboardVO selectBoard(int boNo);	
	public int updateBoard(FreeboardVO board);
	public int deleteBoard(FreeboardVO board);
}
