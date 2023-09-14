package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;

public interface FreeboardService {
	public boolean createBoard(FreeboardVO board);
	public List<FreeboardVO> retrieveBoardList(PaginationInfo paging);
	public FreeboardVO retrieveBoard(int boNo);
	public boolean modifyBoard(FreeboardVO board);
	public boolean removeBoard(FreeboardVO board);
	
	public FreeboardVO boardAuthenticate(FreeboardVO input);
}
