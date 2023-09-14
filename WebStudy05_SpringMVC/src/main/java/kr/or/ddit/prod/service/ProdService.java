package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리 CRUD, Business Logic Layer
 *
 */
public interface ProdService {
	/**
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult createProd(ProdVO prod);
	/**
	 * @param prodId
	 * @return
	 * @throws PKNotFoundException 해당 상품이 없는 경우.
	 */
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException;
	public List<ProdVO> retrieveProdList();
	/**
	 * @param prod
	 * @return OK, FAIL
	 */
	public ServiceResult modifyProd(ProdVO prod);
}


























