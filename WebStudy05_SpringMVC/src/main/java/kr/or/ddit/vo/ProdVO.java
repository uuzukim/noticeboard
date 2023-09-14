package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Data Mapper 를 이용해서 두개 이상의 테이블로부터 데이터를 조회하는 방법
 * 1. 메인 테이블을 기준(1)으로 테이블간의 관계성을 파악함.
 * 	ex) PROD vs	BUYER - 1:1 하나의 상품은 하나의 거래처를 가짐(has a).
 * 		BUYER vs PROD - 1:N 하나의 거래처는 여러개의 거래 상품을 가짐(has many)
 * 2. 각 테이블로부터 조회된 데이터를 바인딩한 도메인 객체 간의 관계 형성 
 *	ex) ProdVO has a BuyerVO
 *		BuyerVO has many ProdVO
 * 3. 직접 조인 쿼리 작성
 * 4. resultType --> resultMap 으로 수동 바인딩 설정.
 * 	  has a : assocation
 * 	  has many : collection
 */
@Data
@EqualsAndHashCode(of = "prodId")
public class ProdVO implements Serializable {
	@NotBlank(groups = {UpdateGroup.class, DeleteGroup.class})
	private String prodId;
	@NotBlank
	private String prodName;
	@NotBlank
	private String prodLgu;
	private LprodVO lprod; // has a 관계 (1:1)
	@NotBlank
	private String prodBuyer;
	private BuyerVO buyer; // has a 관계 (1:1)
	@Min(0)
	private int prodCost;
	@Min(0)
	private int prodPrice;
	@NotNull
	@Min(0)
	private Integer prodSale;
	@NotBlank
	private String prodOutline;
	private String prodDetail;
	@NotBlank(groups = InsertGroup.class)
	private String prodImg;
	
	private MultipartFile prodImage;
	public void setProdImage(MultipartFile prodImage) {
		if(!prodImage.isEmpty()) {
			this.prodImage = prodImage;
			this.prodImg = UUID.randomUUID().toString();
		}
		
	}
	
	@Min(0)
	private int prodTotalstock;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate prodInsdate;
	@NotNull
	@Min(0)
	private Integer prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	private String prodUnit;
	private Integer prodQtyin;
	private Integer prodQtysale;
	private Integer prodMileage;
	
	private List<MemberVO> memList; // has many (1:N)
}








