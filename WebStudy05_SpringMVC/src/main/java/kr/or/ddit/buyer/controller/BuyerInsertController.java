package kr.or.ddit.buyer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.prod.dao.OthersDAO;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/buyer/buyerInsert.do")
public class BuyerInsertController{
	private final BuyerService service;
	private final OthersDAO othersDAO;
	
	@ModelAttribute("lprodList")
	public List<LprodVO> lprodList() {
		return othersDAO.selectLprodList();
	}
	
	@ModelAttribute("buyer")
	public BuyerVO buyer() {
		return new BuyerVO();
	}
	
	@GetMapping
	public String getHandler(){
		return "buyer/buyerForm";
	}
	
	@PostMapping
	public String postHandler(
		@Validated(InsertGroup.class) @ModelAttribute("buyer") BuyerVO buyer
		, BindingResult errors
		, Model model
	){
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createBuyer(buyer);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/buyer/buyerView.do?what="+buyer.getBuyerId();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요.");
				logicalViewName = "buyer/buyerForm";
			}
		}else {
			logicalViewName = "buyer/buyerForm";
		}
		
		return logicalViewName;
	}
}

















