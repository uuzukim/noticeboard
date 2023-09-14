package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ProdRetrieveController{
	private final ProdService service;
	
	@RequestMapping("/prod/prodList.do")
	public String list(Model model){
		
		List<ProdVO> prodList = service.retrieveProdList();
		model.addAttribute("prodList", prodList);
		
		return "prod/prodList";
	}
	
	@RequestMapping("/prod/prodView.do")
	public ModelAndView view(@RequestParam(name = "what", required = true) String prodId ){
		
		ProdVO prod = service.retrieveProd(prodId);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("prod", prod);
		mav.setViewName("prod/prodView");
		return mav;
	}
}




















