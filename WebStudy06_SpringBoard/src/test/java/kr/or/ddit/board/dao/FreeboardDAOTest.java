package kr.or.ddit.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;

@SpringJUnitWebConfig(locations = "file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
@Transactional
class FreeboardDAOTest {

	@Inject
	private FreeboardDAO dao;
	private PaginationInfo<FreeboardVO> paging;
	private FreeboardVO board;
	
	@BeforeEach
	public void setUp() {
		paging = new PaginationInfo<>();
		board = new FreeboardVO();
		board.setBoTitle("제목");
		board.setBoWriter("작성자");
		board.setBoIp("아이피");
		board.setBoMail("email");
		board.setBoContent("내용");
		board.setBoPass("비밀번호");
	}
	
	@Test
	void testInsertBoard() {
		assertEquals(1, dao.insertBoard(board));
	}

	@Test
	void testSelectTotalRecord() {
		long totalRecord = dao.selectTotalRecord(paging);
		assertNotEquals(0, totalRecord);
	}

	@Test
	void testSelectBoardList() {
		List<FreeboardVO> boardList = dao.selectBoardList(paging);
		assertNotNull(boardList);
	}

	@Test
	void testSelectBoard() {
		assertNotNull(dao.selectBoard(100));
	}

	@Test
	void testUpdateBoard() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteBoard() {
		fail("Not yet implemented");
	}

}
