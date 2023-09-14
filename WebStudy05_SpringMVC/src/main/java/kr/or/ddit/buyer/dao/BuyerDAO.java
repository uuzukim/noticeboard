package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BuyerVO;

/**
 * 거래처 관리 Persistence Layer
 *
 */
@Mapper
public interface BuyerDAO {
	/**
	 * 거래처 등록
	 * @param buyer
	 * @return row count > 0 : 성공
	 */
	public int insertBuyer(BuyerVO buyer);
	/**
	 * 거래처 상세 조회
	 * @param buyerId
	 * @return
	 */
	public BuyerVO selectBuyer(String buyerId);
	/**
	 * 거래처 목록 조회
	 * @return
	 */
	public List<BuyerVO> selectBuyerList();
	/**
	 * 거래처 수정
	 * @param buyer
	 * @return row count > 0 : 성공
	 */
	public int updateBuyer(BuyerVO buyer);
	/**
	 * 거래처 삭제
	 * @param buyerId
	 * @return row count > 0 : 삭제
	 */
	public int deleteBuyer(String buyerId);
}
