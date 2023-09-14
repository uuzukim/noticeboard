package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.vo.BuyerVO;

/**
 * 거래처 관리 Business Logic Layer
 *
 */
public interface BuyerService {
	/**
	 * 거래처 등록
	 * @param Buyer
	 * @return OK, FAIL
	 */
	public ServiceResult createBuyer(BuyerVO buyer);
	/**
	 * 거래처 상세 조회
	 * @param BuyerId
	 * @return
	 * @throws PKNotFoundException 해당 거래처가 없는 경우.
	 */
	public BuyerVO retrieveBuyer(String buyerId) throws PKNotFoundException;
	/**
	 * 거래처 목록 조회
	 * @return
	 */
	public List<BuyerVO> retrieveBuyerList();
	/**
	 * 거래처 수정
	 * @param Buyer
	 * @return OK, FAIL
	 */
	public ServiceResult modifyBuyer(BuyerVO buyer);
	
	/**
	 * 거래처 삭제?
	 * @param buyer
	 * @return
	 */
	public ServiceResult removeBuyer(String buyerId);
}
