package kr.or.ddit.prod.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController{
	
	@Inject
	private ProdService service;
	@Inject
	private OthersDAO othersDAO;
	
	@ModelAttribute("lprodList")
	public List<LprodVO> lprodList() {
		return othersDAO.selectLprodList();
	}
	
	@ModelAttribute("buyerList")
	public List<BuyerVO> buyerList() {
		return othersDAO.selectBuyerList();
	}
	
	@GetMapping
	public String updateForm(
		Model model
		, @RequestParam("what") String prodId
	){
		ProdVO prod = service.retrieveProd(prodId);
		model.addAttribute("prod", prod);
		
		return "prod/prodEdit";
	}
	
	/**
	 * HandlerAdapter 를 이용하여 JSR-310(@Valid) 방식의 검증 단계
	 * 1. Hibernate Validator 와 같은 Validator 구현체를 빌드패스에 추가.
	 * 2. <mvc:annotation-driven /> 와 같은 설정으로 Validator 구현체를 빈으로 등록함.
	 * 3. MemberVO 와 같은 도메인 객체에 검증 조건을 어노테이션으로 설정(groups 설정 추가).
	 * 4. 컨트롤러의 핸들러 메소드에서 검증 대상이 되는 command object 에 
	 * 		@Valid / @Validated(group hint) 와 같은 어노테이션을 사용함.
	 * 5. 검증 대상이 되는 command object 바로 다음에, 검증 결과 데이터를 가진
	 * 		Errors / BindingResult 를 추가 파라미터로 설정하여 검증 결과를 확보.
	 * 6. errors.hasErrors() 결과에 따라 검증 통과 여부를 확인.
	 * 
	 * 7. form 커스텀 태그를 이용해 기존의 입력 데이터를 초기값으로 출력하고,
	 * 		검증 결과 메시지까지 출력.
	 * @param model
	 * @param prod
	 * @return
	 */
	@PostMapping
	public String updateProcess(
		Model model
		, @Validated(UpdateGroup.class) @ModelAttribute("prod") ProdVO prod // command object
		, BindingResult errors
	){
		
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyProd(prod);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/prod/prodView.do?what="+prod.getProdId();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				logicalViewName = "prod/prodEdit";
			}
		}else {
			logicalViewName = "prod/prodEdit";
		}
		
		return logicalViewName;
	}
	
}









