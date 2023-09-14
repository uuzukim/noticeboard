package kr.or.ddit.calculate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
public class Case2ProcessController{
	private static final long serialVersionUID = 1L;

	@PostMapping(value="/calculate/Case2ProcessServlet", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> doPost(
		double left	
		, double right
		, OperatorType operator
	){
		double result = operator.biOperate(left, right);
		
		String expr = operator.expression(left, right);
		
		// native
		Map<String, Object> target = new HashMap<>();
		target.put("expr", expr);
		target.put("result", result);
		target.put("left", left);
		target.put("right", right);
		target.put("operator", operator);
		return target;
		
	}

}




















