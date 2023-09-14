package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

/**
 * 상품 등록/수정 양식에서 사용될 분류 정보와 거래처 정보 조회.
 *
 */
@Mapper
public interface OthersDAO {
	public List<LprodVO> selectLprodList();
	public List<BuyerVO> selectBuyerList();
}
