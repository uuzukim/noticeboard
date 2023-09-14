package kr.or.ddit.servlet02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GugudanController{
	@RequestMapping("/02/gugudan.do")
	public String doGet(
		@RequestParam(required = false,defaultValue = "2") int minDan
		, @RequestParam(required = false,defaultValue = "9") int maxDan
		, Model model
	){
		model.addAttribute("minDan", minDan);
		model.addAttribute("maxDan", maxDan);
		return "02/gugudan";
	}
}
















