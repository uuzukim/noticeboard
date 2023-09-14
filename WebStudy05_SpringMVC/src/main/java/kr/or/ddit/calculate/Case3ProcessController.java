package kr.or.ddit.calculate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.OperatorType;

@Controller
@RequestMapping("/calculate/Case3ProcessServlet")
public class Case3ProcessController{
	private static final long serialVersionUID = 1L;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected Map<String, Object> json(
		@RequestParam("leftOp") double left	
		, @RequestParam("rightOp") double right
		, @RequestParam("opParam") OperatorType operator
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

	@PostMapping(produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String html(
		@RequestParam("leftOp") double left	
		, @RequestParam("rightOp") double right
		, @RequestParam("opParam") OperatorType operator
	){
		double result = operator.biOperate(left, right);
			
		return operator.expression(left, right);
	}

}




















