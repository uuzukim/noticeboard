package kr.or.ddit.calculate;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
public class Case1ProcessController {
	private static final long serialVersionUID = 1L;

	@PostMapping(value="/calculate/Case1ProcessServlet", produces = "text/html;charset=UTF-8")
	@ResponseBody // 컨트롤러의 반환값이 reponse body 의 컨텐츠로 사용될때. (produeces 속성과 함께 사용)
	public String doPost(
		@RequestParam double leftOp	
		, @RequestParam double rightOp	
		, OperatorType opParam
	){
		double result = opParam.biOperate(leftOp, rightOp);
		
		return opParam.expression(leftOp, rightOp);
		
	}

}




















