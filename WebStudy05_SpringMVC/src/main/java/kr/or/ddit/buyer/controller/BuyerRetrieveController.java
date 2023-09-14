package kr.or.ddit.buyer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.vo.BuyerVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/buyer")
public class BuyerRetrieveController{
	
	private final BuyerService service;
	
	@RequestMapping("buyerList.do")
	public String listHandler(Model model){
		
		List<BuyerVO> buyerList = service.retrieveBuyerList();
		model.addAttribute("buyerList", buyerList);
		
		return "buyer/buyerList";
	}
	
	@RequestMapping("buyerView.do")
	public String viewHandler(@RequestParam("what") String buyerId, Model model){
		
		BuyerVO buyer = service.retrieveBuyer(buyerId);
		
		model.addAttribute("buyer", buyer);
		
		return "buyer/buyerView";
	}
}
