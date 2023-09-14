package kr.or.ddit.buyer.service;

import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.buyer.dao.BuyerDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.vo.BuyerVO;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Inject
	private BuyerDAO buyerDAO;
	
	@Override
	public ServiceResult createBuyer(BuyerVO buyer) {
		return buyerDAO.insertBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public BuyerVO retrieveBuyer(String buyerId) throws PKNotFoundException {
		BuyerVO buyer = buyerDAO.selectBuyer(buyerId);
		if(buyer==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 거래처 없음", buyerId));
		return buyer;
	}

	@Override
	public List<BuyerVO> retrieveBuyerList() {
		return buyerDAO.selectBuyerList();
	}

	@Override
	public ServiceResult modifyBuyer(BuyerVO buyer) {
		return buyerDAO.updateBuyer(buyer) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public ServiceResult removeBuyer(String buyerId) {
		throw new IllegalStateException("거래처 정보 삭제는 지원하지 않습니다.");
	}

}
