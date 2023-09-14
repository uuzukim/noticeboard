package kr.or.ddit.prod.service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdDAO;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProdServiceImpl implements ProdService {
	@Inject
	private ProdDAO prodDAO;
	@Value("#{appInfo.prodSavePath}")
	private String prodSavePath; 
	@Value("#{appInfo.prodSavePath}")
	private Resource prodSaveRes;
	@PostConstruct
	public void init() {
		log.info("상품 이미지 저장 경로 : {}", prodSaveRes);
	}

	private ServiceResult processProdImage(ProdVO prod) {
		if(prod.getProdImage()==null) return ServiceResult.OK;
//		if(1==1) throw new RuntimeException("트랜잭션 관리 여부 확인을 위한 강제 발생 예외");
		try {
			File saveFile = new File(prodSaveRes.getFile(), prod.getProdImg());
			prod.getProdImage().transferTo(saveFile);
			return ServiceResult.OK;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
//	POP, FOP, OOP
//	선언적 프로그래밍에 의핸 트랜잭션 관리 : AOP
	
	@Override
	public ServiceResult createProd(ProdVO prod) {
		ServiceResult result = null;
		int cnt = prodDAO.insertProd(prod);
		if(cnt > 0) {
			result = processProdImage(prod);
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ProdVO retrieveProd(String prodId) throws PKNotFoundException {
		ProdVO prod = prodDAO.selectProd(prodId);
		if(prod==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 상품 없음", prodId));
		return prod;
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return prodDAO.selectProdList();
	}

	@Override
	public ServiceResult modifyProd(ProdVO prod) {
		ServiceResult result = null;
		int cnt = prodDAO.updateProd(prod);
		if(cnt > 0) {
			result = processProdImage(prod);
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

}














