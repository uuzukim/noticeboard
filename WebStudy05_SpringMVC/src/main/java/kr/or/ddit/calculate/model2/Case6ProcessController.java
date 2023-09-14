package kr.or.ddit.calculate.model2;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.calculate.CalculateVO;

@Controller
@RequestMapping("/calculate/Case6ProcessServlet")
public class Case6ProcessController{
	
	@GetMapping
	public String case6Form(){
		return "calculate/case6Form";
	}
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String parameterToHtml(@ModelAttribute("calculate") CalculateVO commandObject){
		return "calculate/ajax/calculateResult";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String parameterToJson(@ModelAttribute("calculate") CalculateVO commandObject){
		return "jsonView";
	}
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String jsonToHtml(@RequestBody CalculateVO commandObject, Model model){
		model.addAttribute("calculate", commandObject);
		return "calculate/ajax/calculateResult";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String jsonToJson(@RequestBody CalculateVO commandObject, Model model){
		model.addAttribute("calculate", commandObject);
		return "jsonView";
	}
	
}





















