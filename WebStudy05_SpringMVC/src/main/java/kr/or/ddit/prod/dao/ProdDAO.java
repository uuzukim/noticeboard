package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.ProdVO;

/**
 * 상품 관리 CRUD, Persistence Layer
 *
 */
@Mapper
public interface ProdDAO {
	public int insertProd(ProdVO prod);
	public ProdVO selectProd(String prodId);
	public List<ProdVO> selectProdList();
	public int updateProd(ProdVO prod);
}
