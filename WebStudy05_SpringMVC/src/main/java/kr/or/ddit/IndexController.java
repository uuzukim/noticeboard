package kr.or.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController{
	
	@RequestMapping("/index.do")
	public String getHandler(Model model){
		
		model.addAttribute("welcomeMessage", "웰컴 페이지용 안내 메시지");
		
		return "index";
	}
}
